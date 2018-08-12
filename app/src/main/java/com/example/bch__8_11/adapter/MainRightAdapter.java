package com.example.bch__8_11.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bch__8_11.R;
import com.example.bch__8_11.bean.ProductCatagoryBean;
import com.example.bch__8_11.myview.MyRecycle;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainRightAdapter extends RecyclerView.Adapter {
    private List<ProductCatagoryBean.DataBean> data;
    private Context context;

    public MainRightAdapter(List<ProductCatagoryBean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }
    public void AddList(List<ProductCatagoryBean.DataBean> li){
        data.addAll(li);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.main_recy_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ProductCatagoryBean.DataBean dataBean = data.get(position);
            String name = dataBean.getName();
            List<ProductCatagoryBean.DataBean.ListBean> list = dataBean.getList();
            ((ViewHolder) holder).mainRecyItemTite.setText(name);

            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
            ((ViewHolder) holder).mainRecyItemRecy.setLayoutManager(gridLayoutManager);
            MainRight_itemAdapter mainRight_itemAdapter = new MainRight_itemAdapter(list, context);
            ((ViewHolder) holder).mainRecyItemRecy.setAdapter(mainRight_itemAdapter);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.main_recy_item_recy)
        MyRecycle mainRecyItemRecy;
        @BindView(R.id.main_recy_item_tite)
        TextView mainRecyItemTite;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
