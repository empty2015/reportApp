package com.envrionment.report;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by mac on 12/11/16.
 */

public class PartSymbol2Holder extends RecyclerView.ViewHolder {

    private View view1;
    private View view2;
    private  TextView tv_label1;
    private  TextView tv_label2;
    private  TextView tv_label3;
    private  EditText edit_label;
    Context context;
    public PartSymbol2Holder(Context context,View view)
    {
        super(view);
        this.context = context;
        view1 = view.findViewById(R.id.list_item1);
        view2 = view.findViewById(R.id.ll_container_child);
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
        edit_label.setText("");
        ((LinearLayout)view2).removeAllViews();
        if(bean.getItems().size()>0)
        {
            for(int j = 0;j<bean.getItems().size();j++)
            {
                TablePart1Bean item = bean.getItems().get(j);
                View childView = LayoutInflater.from(context).inflate(R.layout.layout_table_item_subtitle,null);
                if(j>0)
                {
                    ((TextView)childView.findViewById(R.id.tv_label)).setVisibility(View.INVISIBLE);
                }
                ((TextView)childView.findViewById(R.id.tv_label1)).setText(item.getName());
                ((TextView)childView.findViewById(R.id.tv_label2)).setText(item.getUnits());
                ((TextView)childView.findViewById(R.id.tv_label3)).setText(item.getCode());
                ((EditText)childView.findViewById(R.id.edit_label)).setText("");
                ((LinearLayout)view2).addView(childView,LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            }
        }
    }
}
