package com.example.bch__8_11.model;

import com.example.bch__8_11.api.ApiInterface;
import com.example.bch__8_11.bean.CatagoryBean;
import com.example.bch__8_11.bean.ProductCatagoryBean;
import com.example.bch__8_11.contract.MainContract;
import com.example.bch__8_11.untils.RetroRx;

import okhttp3.logging.HttpLoggingInterceptor;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainModel implements MainContract.Model {
    @Override
    public void GetCatagoryhttp(final ModelData gData) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        RetroRx.setInterceptor(httpLoggingInterceptor);
        ApiInterface apiInterface = RetroRx.setSerice(ApiInterface.class);
        apiInterface.GetCatagoryBean()
                .subscribeOn(Schedulers.io())//IO线程加载数据
                .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
                .subscribe(new Observer<CatagoryBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CatagoryBean catagoryBean) {
                        gData.getData(catagoryBean);
                    }
                });

    }

    @Override
    public void GetProductCatagoryhttp(int cid, final ModelData gData) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        RetroRx.setInterceptor(httpLoggingInterceptor);
        ApiInterface apiInterface = RetroRx.setSerice(ApiInterface.class);
        apiInterface.GetProductCatagoryBean(cid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProductCatagoryBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ProductCatagoryBean productCatagoryBean) {
                        gData.getData(productCatagoryBean);
                    }
                });
    }
}
