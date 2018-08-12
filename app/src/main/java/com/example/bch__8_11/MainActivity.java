package com.example.bch__8_11;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bch__8_11.adapter.MainRightAdapter;
import com.example.bch__8_11.adapter.MyTabAdapter;
import com.example.bch__8_11.base.BaseActivity;
import com.example.bch__8_11.bean.CatagoryBean;
import com.example.bch__8_11.bean.ProductCatagoryBean;
import com.example.bch__8_11.contract.MainContract;
import com.example.bch__8_11.presenter.MainPresenter;
import com.orhanobut.logger.Logger;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.logging.HttpLoggingInterceptor;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.TabView;

public class MainActivity extends BaseActivity implements MainContract.View {

    @BindView(R.id.home_recy)
    RecyclerView homeRecy;
    @BindView(R.id.home_title)
    TextView homeTitle;
    @BindView(R.id.home_verticaltab)
    VerticalTabLayout homeVerticaltab;
    private MainContract.Presenter presenter;
    private MainRightAdapter mainRightAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
        presenter.GetCatagoryhttp();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        homeRecy.setLayoutManager(manager);
    }

    @Override
    public void GetCatagoryBean(CatagoryBean catagoryBean) {
        List<CatagoryBean.DataBean> data = catagoryBean.getData();
        Logger.e(catagoryBean.toString());
        TabAdapter tabAdapter = new MyTabAdapter(data);
        ((MyTabAdapter) tabAdapter).setCid(new MyTabAdapter.getCid() {
            @Override
            public void getCid(String cid) {
                int i = Integer.parseInt(cid);
                presenter.GetProductCatagoryhttp(i);
            }
        });
        homeVerticaltab.setTabAdapter(tabAdapter);
        homeVerticaltab.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {
                if (position >6){
                    Toast.makeText(MainActivity.this,"此条目无数据",Toast.LENGTH_SHORT).show();
                }else {
                    homeRecy.scrollToPosition(position);
                }

            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });


    }

    @Override
    public void GetProductCatagoryBean(ProductCatagoryBean productCatagoryBean) {
        List<ProductCatagoryBean.DataBean> data = productCatagoryBean.getData();
        HttpLoggingInterceptor.Logger.DEFAULT.log(productCatagoryBean.toString());
        if (data.size() <= 0) {
            Toast.makeText(this,"此条目无数据",Toast.LENGTH_SHORT).show();

        }else {
            Logger.e(productCatagoryBean.toString());
            if (mainRightAdapter == null){
                mainRightAdapter = new MainRightAdapter(data, MainActivity.this);
                homeRecy.setAdapter(mainRightAdapter);
            }else {
                mainRightAdapter.AddList(data);
            }

        }

    }
}
