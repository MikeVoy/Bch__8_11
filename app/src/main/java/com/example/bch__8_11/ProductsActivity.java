package com.example.bch__8_11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bch__8_11.adapter.ProductAdapter;
import com.example.bch__8_11.bean.ProductsBean;
import com.example.bch__8_11.contract.ProductsContract;
import com.example.bch__8_11.presenter.ProductsPresenter;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductsActivity extends AppCompatActivity implements ProductsContract.View {

    @BindView(R.id.Products_recy)
    RecyclerView ProductsRecy;
    @BindView(R.id.Products_img)
    ImageView ProductsImg;
    private ProductsPresenter productsPresenter;
    private boolean idLin = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        productsPresenter = new ProductsPresenter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ProductsRecy.setLayoutManager(linearLayoutManager);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getData(String pscid) {
        Logger.e(pscid);
        int id = Integer.parseInt(pscid);
        if (productsPresenter == null) {
            productsPresenter = new ProductsPresenter(this);
        }
        productsPresenter.GetProductsBean(id);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void GetCatagoryBean(ProductsBean productsBean) {
        Logger.e(productsBean.toString());
        List<ProductsBean.DataBean> data = productsBean.getData();
        if (data.size() <= 0){
            Toast.makeText(this,"没有数据",Toast.LENGTH_SHORT).show();
        }else {
            ProductAdapter productAdapter = new ProductAdapter(data, this);
            ProductsRecy.setAdapter(productAdapter);
        }

    }

    @OnClick(R.id.Products_img)
    public void onViewClicked() {
        if (idLin){
            idLin = false;
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
            ProductsRecy.setLayoutManager(gridLayoutManager);
        }else {
            idLin = true;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            ProductsRecy.setLayoutManager(linearLayoutManager);
        }
    }
}
