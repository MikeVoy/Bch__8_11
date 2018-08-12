package com.example.bch__8_11.adapter;

import com.example.bch__8_11.bean.CatagoryBean;

import java.util.List;

import q.rorbin.verticaltablayout.widget.ITabView;

public class MyTabAdapter implements q.rorbin.verticaltablayout.adapter.TabAdapter {
    private List<CatagoryBean.DataBean> list;
    private getCid cid;

    public void setCid(getCid cid) {
        this.cid = cid;
    }

    public MyTabAdapter(List<CatagoryBean.DataBean> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ITabView.TabBadge getBadge(int position) {
        return null;
    }

    @Override
    public ITabView.TabIcon getIcon(int position) {
        return null;
    }

    @Override
    public ITabView.TabTitle getTitle(int position) {
        ITabView.TabTitle build = new ITabView.TabTitle.Builder()
                .setContent(list.get(position).getName())
                .build();
        cid.getCid(list.get(position).getCid());

        return build;
    }

    @Override
    public int getBackground(int position) {
        return 0;
    }

    public interface getCid {
        void getCid(String cid);
    }
}
