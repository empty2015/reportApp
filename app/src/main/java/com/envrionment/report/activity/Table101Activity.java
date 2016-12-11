package com.envrionment.report.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.envrionment.report.R;
import com.envrionment.report.fragment.BaseFragment;
import com.envrionment.report.fragment.Table101Part1Fragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by mac on 12/11/16.
 */

public class Table101Activity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.tv_title)
    TextView tv_title;
    BaseFragment part1Fragment;

    @BindView(R.id.iv_back)
    ImageView iv_back;

    @Override
    public int getLayoutId() {
        return R.layout.activity_table101;
    }

    @Override
    public void initView() {

        tv_title.setText("基101表信息填写");
        iv_back.setVisibility(View.VISIBLE);
        part1Fragment = new Table101Part1Fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fl_container,part1Fragment);
        transaction.commit();
    }

    @Override
    public void initListener() {

    }

    @OnClick({R.id.rl_back})
    @Override
    public void onClick(View view) {

        int id = view.getId();
        switch (id)
        {
            case R.id.rl_back:
                finish();
                break;
            default:
                break;
        }
    }

}
