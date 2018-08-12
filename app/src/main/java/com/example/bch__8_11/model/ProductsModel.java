package com.example.bch__8_11.model;

import com.example.bch__8_11.api.ApiInterface;
import com.example.bch__8_11.bean.ProductsBean;
import com.example.bch__8_11.contract.ProductsContract;
import com.example.bch__8_11.untils.RetroRx;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ProductsModel implements ProductsContract.Model {
    @Override
    public void GetProductCatagoryhttp(int pscid, final ModelData gData) {
        ApiInterface apiInterface = RetroRx.setSerice(ApiInterface.class);
        apiInterface.GetProductsBean(pscid)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ProductsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ProductsBean productsBean) {
                    gData.getData(productsBean);
                    }
                });
    }
}
