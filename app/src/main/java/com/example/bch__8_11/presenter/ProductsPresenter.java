package com.example.bch__8_11.presenter;

import com.example.bch__8_11.bean.ProductsBean;
import com.example.bch__8_11.contract.ProductsContract;
import com.example.bch__8_11.model.ProductsModel;

public class ProductsPresenter implements ProductsContract.Presenter {
    private ProductsContract.View view;
    private ProductsContract.Model model;

    public ProductsPresenter(ProductsContract.View view) {
        this.view = view;
        this.model = new ProductsModel();
    }

    @Override
    public void GetProductsBean(int pscid) {
        model.GetProductCatagoryhttp(pscid, new ProductsContract.Model.ModelData() {
            @Override
            public void getData(ProductsBean productsBean) {
                view.GetCatagoryBean(productsBean);
            }
        });
    }

    @Override
    public void onDestry() {
        if (view != null) {
            view = null;
            model = null;
        }
    }
}
