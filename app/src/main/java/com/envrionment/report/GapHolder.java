package com.envrionment.report;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by mac on 12/11/16.
 */

public class GapHolder extends RecyclerView.ViewHolder {

    View view;
    public GapHolder(View view)
    {
        super(view);
        this.view = view.findViewById(R.id.space1);
    }

    public void bindData(TablePart1Bean bean)
    {
        view.setBackgroundColor(Integer.valueOf(bean.getColor().replace("#",""),16));
    }
}
