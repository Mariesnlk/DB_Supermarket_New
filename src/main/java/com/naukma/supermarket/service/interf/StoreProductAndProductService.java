package com.naukma.supermarket.service.interf;


import com.naukma.supermarket.model.StoreProductAndProduct;

public interface StoreProductAndProductService {

    StoreProductAndProduct findInfoByUPC(String upc);
}
