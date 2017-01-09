package com.envrionment.report.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.envrionment.report.R;
import com.envrionment.report.TablePartResult;
import com.envrionment.report.adapter.Myadapter;
import com.envrionment.report.utils.FileUtil;

/**
 * Created by mac on 12/11/16.
 */

public class Table101Part1Fragment extends BaseFragment {

    LinearLayout ll_container;
    private boolean needGap = false;

    RecyclerView recycler_view;
    Myadapter myadapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_table101_part1,null);
        ll_container = (LinearLayout)view.findViewById(R.id.ll_container);
        recycler_view = (RecyclerView)view.findViewById(R.id.recycler_view);
//        initListItem(inflater);
        //创建布局管理器
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler_view.setLayoutManager(mLayoutManager);
        initData();
        return view;
    }

    private void initData()
    {
        String content = FileUtil.getAssetsFile(getActivity(),"table_part1.txt");
        TablePartResult result = FileUtil.gsonConver(content,TablePartResult.class);
        if(result!=null)
        {
            myadapter = new Myadapter();
            recycler_view.setAdapter(myadapter);
            myadapter.setDatas(result.getItems());

        }

    }

}
