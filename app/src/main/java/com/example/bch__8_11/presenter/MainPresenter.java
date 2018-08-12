package com.example.bch__8_11.presenter;

import com.example.bch__8_11.bean.CatagoryBean;
import com.example.bch__8_11.bean.ProductCatagoryBean;
import com.example.bch__8_11.contract.MainContract;
import com.example.bch__8_11.model.MainModel;

public class MainPresenter implements MainContract.Presenter, MainContract.Model.ModelData {
    private MainContract.View view;
    private MainContract.Model model;

    public MainPresenter(MainContract.View view) {
        this.view = view;
        this.model = new MainModel();
    }

    @Override
    public void GetCatagoryhttp() {
        model.GetCatagoryhttp(this);
    }

    @Override
    public void GetProductCatagoryhttp(int cid) {
        model.GetProductCatagoryhttp(cid, this);
    }

    @Override
    public void onDestry() {
        if (view != null) {
            view = null;
            model = null;
        }
    }

    @Override
    public void getData(CatagoryBean catagoryBean) {
        view.GetCatagoryBean(catagoryBean);
    }

    @Override
    public void getData(ProductCatagoryBean productCatagoryBean) {
        view.GetProductCatagoryBean(productCatagoryBean);
    }
}
