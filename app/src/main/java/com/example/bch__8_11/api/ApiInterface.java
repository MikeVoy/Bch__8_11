package com.example.bch__8_11.api;



import com.example.bch__8_11.bean.CatagoryBean;
import com.example.bch__8_11.bean.ProductCatagoryBean;
import com.example.bch__8_11.bean.ProductsBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiInterface {
    @GET("product/getCatagory")
    Observable<CatagoryBean> GetCatagoryBean();
    @GET("product/getProductCatagory")
    Observable<ProductCatagoryBean>  GetProductCatagoryBean(@Query("cid") int cid);
    @GET("product/getProducts")
    Observable<ProductsBean>  GetProductsBean(@Query("pscid") int pscid);
}
