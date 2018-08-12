package com.example.bch__8_11.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bch__8_11.ProductsActivity;
import com.example.bch__8_11.R;
import com.example.bch__8_11.bean.ProductCatagoryBean;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainRight_itemAdapter extends RecyclerView.Adapter {
    private List<ProductCatagoryBean.DataBean.ListBean> list;
    private Context context;

    public MainRight_itemAdapter(List<ProductCatagoryBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.main_recy_item_recy, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).mainRecyItemRecyTitle.setText(list.get(position).getName());
            ((ViewHolder) holder).mainRecyItemRecyImg.setImageURI(list.get(position).getIcon());
            ((ViewHolder) holder).view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String pscid = list.get(position).getPscid();
                    EventBus.getDefault().postSticky(pscid);
                    Intent intent = new Intent(context, ProductsActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.main_recy_item_recy_img)
        SimpleDraweeView mainRecyItemRecyImg;
        @BindView(R.id.main_recy_item_recy_title)
        TextView mainRecyItemRecyTitle;
        View view;

        ViewHolder(View view) {
            super(view);
            this.view = view;
            ButterKnife.bind(this, view);
        }
    }
}
