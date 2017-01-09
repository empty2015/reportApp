package com.envrionment.report.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.envrionment.report.R;
import com.envrionment.report.fragment.BaseFragment;
import com.envrionment.report.fragment.Table101Part1Fragment;
import com.envrionment.report.fragment.Table101Part2Fragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mac on 12/11/16.
 */

public class Table101Activity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.tv_title)
    TextView tv_title;
    BaseFragment part1Fragment;
    BaseFragment part2Fragment;

    @BindView(R.id.iv_back)
    ImageView iv_back;

    @BindView(R.id.tv_left)
    TextView tv_left;

    @BindView(R.id.tv_right)
    TextView tv_right;

    @Override
    public int getLayoutId() {
        return R.layout.activity_table101;
    }

    @Override
    public void initView() {

        tv_title.setText("基101表信息填写");
        iv_back.setVisibility(View.VISIBLE);
        tv_right.setVisibility(View.VISIBLE);
        part1Fragment = new Table101Part1Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fl_container,part1Fragment);
        transaction.commit();
    }

    @Override
    public void initListener() {

    }

    @OnClick({R.id.rl_back,R.id.tv_left,R.id.tv_right})
    @Override
    public void onClick(View view) {

        int id = view.getId();
        switch (id)
        {
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_right:
                nextPage();
                break;
            case R.id.tv_left:
                previousPage();
                break;
            default:
                break;
        }
    }

    private void previousPage()
    {
        tv_left.setVisibility(View.GONE);
        iv_back.setVisibility(View.VISIBLE);
        tv_right.setVisibility(View.VISIBLE);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.setCustomAnimations(R.animator.slide_in_left,R.animator.slide_out_right);
        transaction.hide(part2Fragment).show(part1Fragment);
        transaction.commit();

    }

    private void nextPage()
    {
        tv_left.setVisibility(View.VISIBLE);
        iv_back.setVisibility(View.GONE);
        tv_right.setVisibility(View.GONE);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.animator.slide_in_right,R.animator.slide_out_left);
        if(part2Fragment==null)
        {
            part2Fragment = new Table101Part2Fragment();
            transaction.add(R.id.fl_container,part2Fragment).hide(part1Fragment);
        }
        else
        {
            transaction.hide(part1Fragment).show(part2Fragment);
        }
        transaction.commit();
    }

}
