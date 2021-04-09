package com.naukma.supermarket.dao.interf;

import com.naukma.supermarket.model.Product;
import com.naukma.supermarket.model.StoreProduct;

import java.util.List;

public interface StoreProductDAO extends CRUDDAO<StoreProduct, String> {

    // За UPC-товару знайти ціну продажу товару, кількість наявних одиниць товару
    StoreProduct findSomethingByUpc(String upc);

    StoreProduct findProductInfoByUPC(String upc);

    List<StoreProduct> allStoreProductsByProductName(String productName);
}
