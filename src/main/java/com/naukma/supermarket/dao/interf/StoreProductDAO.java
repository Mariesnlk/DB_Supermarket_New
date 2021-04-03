package com.naukma.supermarket.dao.interf;

import com.naukma.supermarket.model.StoreProduct;

public interface StoreProductDAO extends CRUDDAO<StoreProduct, String> {

    // За UPC-товару знайти ціну продажу товару, кількість наявних одиниць товару
    StoreProduct findSomethingByUpc(String upc);

}
