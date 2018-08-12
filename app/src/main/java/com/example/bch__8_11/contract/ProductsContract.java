package com.example.bch__8_11.contract;

import com.example.bch__8_11.bean.CatagoryBean;
import com.example.bch__8_11.bean.ProductCatagoryBean;
import com.example.bch__8_11.bean.ProductsBean;

public interface ProductsContract {
    interface Model {
        void GetProductCatagoryhttp(int pscid,ModelData gData);
        public interface ModelData{
            void getData(ProductsBean productsBean);

        }

    }

    interface View {
        void GetCatagoryBean(ProductsBean productsBean);
    }

    interface Presenter {
        void GetProductsBean( int pscid);
        void onDestry();
    }
}
