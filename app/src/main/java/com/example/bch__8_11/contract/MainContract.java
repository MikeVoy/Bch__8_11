package com.example.bch__8_11.contract;

import com.example.bch__8_11.bean.CatagoryBean;
import com.example.bch__8_11.bean.ProductCatagoryBean;

public interface MainContract {
    interface Model {
        void GetCatagoryhttp(ModelData gData);
        void GetProductCatagoryhttp(int cid,ModelData gData);
        public interface ModelData{
            void getData(CatagoryBean catagoryBean);
            void getData(ProductCatagoryBean productCatagoryBean);
        }

    }

    interface View {
       void GetCatagoryBean(CatagoryBean catagoryBean);
       void GetProductCatagoryBean(ProductCatagoryBean productCatagoryBean);
    }

    interface Presenter {
        void GetCatagoryhttp();
        void GetProductCatagoryhttp( int cid);
        void onDestry();
    }
}
