package com.envrionment.report.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.envrionment.report.holder.EquipDetailHolder;
import com.envrionment.report.holder.GapHolder;
import com.envrionment.report.holder.PartSymbol1Holder;
import com.envrionment.report.holder.PartSymbol2Holder;
import com.envrionment.report.R;
import com.envrionment.report.TablePartBean;

import java.util.List;

/**
 * Created by mac on 12/11/16.
 */

public class Myadapter extends RecyclerView.Adapter {

    List<TablePartBean> datas;

    public void setDatas(List<TablePartBean> datas)
    {
        this.datas = datas;
        notifyDataSetChanged();
    }

    public void addDatas(List<TablePartBean> datas)
    {
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

    public void clear()
    {
        datas.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder = null;
        switch (viewType)
        {
            case TablePartBean.SHOW_TYPE_NOMRAL:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_table_item,null);
                holder = new PartSymbol1Holder(view);
                break;
            case TablePartBean.SHOW_TYPE_MUL:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_table_item2,null);
                holder = new PartSymbol2Holder(parent.getContext(),view);
                break;
            case TablePartBean.SHOW_TYPE_GAP:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_gap,null);
                holder = new GapHolder(view);
                break;
            case TablePartBean.SHOW_TYPE_EQUIP:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_euip_list,null);
                holder = new EquipDetailHolder(parent.getContext(),view);
                break;
        }
        return holder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position))
        {
            case TablePartBean.SHOW_TYPE_NOMRAL:
                ((PartSymbol1Holder) holder).bindData(datas.get(position));
                break;
            case TablePartBean.SHOW_TYPE_MUL:
                ((PartSymbol2Holder) holder).bindData(datas.get(position));
                break;
            case TablePartBean.SHOW_TYPE_GAP:
                ((GapHolder) holder).bindData(datas.get(position));
                break;
            case TablePartBean.SHOW_TYPE_EQUIP:
                ((EquipDetailHolder)holder).bindData(datas.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getType();
    }

}
