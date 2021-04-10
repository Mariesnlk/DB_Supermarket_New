package com.naukma.supermarket.dao.interf;

import com.naukma.supermarket.model.StoreProduct;

import java.util.List;

public interface StoreProductDAO extends CRUDDAO<StoreProduct, String> {

    StoreProduct findSomethingByUpc(String upc);

    StoreProduct findProductInfoByUPC(String upc);

    List<StoreProduct> allStoreProductsByProductName(String productName);
}
