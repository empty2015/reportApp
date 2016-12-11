package com.envrionment.report;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by mac on 12/11/16.
 */

public class PartSymbol1Holder extends RecyclerView.ViewHolder {



    private  TextView tv_label1;
    private  TextView tv_label2;
    private  TextView tv_label3;
    private  EditText edit_label;

    public PartSymbol1Holder(View view)
    {
        super(view);
        tv_label1 = (TextView)view.findViewById(R.id.tv_label1);
        tv_label2 = (TextView)view.findViewById(R.id.tv_label2);
        tv_label3 = (TextView)view.findViewById(R.id.tv_label3);
        edit_label = (EditText)view.findViewById(R.id.edit_label);
    }

    public void bindData(TablePart1Bean bean)
    {
        tv_label1.setText(bean.getName());
        tv_label2.setText(bean.getUnits());
        tv_label3.setText(bean.getCode());

    }
}
