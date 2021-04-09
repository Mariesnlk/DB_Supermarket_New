package com.naukma.supermarket.service.interf;

import com.naukma.supermarket.model.StoreProduct;

import java.util.List;

public interface StoreProductService extends CRUDService<StoreProduct, String> {

    StoreProduct findSomethingByUpc(String upc);

    StoreProduct findProductInfoByUPC(String upc);

    List<StoreProduct> allStoreProductsByProductName(String productName);

}

