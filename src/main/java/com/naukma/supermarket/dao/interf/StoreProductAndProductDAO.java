package com.naukma.supermarket.dao.interf;

import com.naukma.supermarket.model.StoreProductAndProduct;

public interface StoreProductAndProductDAO {

    StoreProductAndProduct findInfoByUPC(String upc);
}
