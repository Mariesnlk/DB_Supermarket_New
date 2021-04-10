package com.naukma.supermarket.service.impl;

import com.naukma.supermarket.dao.impl.StoreProductAndProductDAOImpl;
import com.naukma.supermarket.dao.interf.StoreProductAndProductDAO;
import com.naukma.supermarket.model.StoreProductAndProduct;
import com.naukma.supermarket.service.interf.StoreProductAndProductService;

public class StoreProductAndProductServiceImpl implements StoreProductAndProductService {

    @Override
    public StoreProductAndProduct findInfoByUPC(String upc) {
        StoreProductAndProductDAO storeProductAndProductDAO = new StoreProductAndProductDAOImpl();
        StoreProductAndProduct product = storeProductAndProductDAO.findInfoByUPC(upc);
        return product;
    }
}
