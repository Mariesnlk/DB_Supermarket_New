package com.naukma.supermarket.service.impl;

import com.naukma.supermarket.dao.impl.StoreProductDAOImpl;
import com.naukma.supermarket.dao.interf.StoreProductDAO;
import com.naukma.supermarket.model.StoreProduct;
import com.naukma.supermarket.service.interf.StoreProductService;

import java.util.List;

public class StoreProductServiceImpl implements StoreProductService {

    @Override
    public void create(StoreProduct product) {
        StoreProductDAO productDAO = new StoreProductDAOImpl();
        productDAO.create(product);
    }

    @Override
    public StoreProduct findById(String upc) {
        StoreProductDAO productDAO = new StoreProductDAOImpl();
        StoreProduct product = productDAO.findById(upc);
        return product;
    }

    @Override
    public List<StoreProduct> findAll() {
        StoreProductDAO productDAO = new StoreProductDAOImpl();
        List<StoreProduct> products = productDAO.findAll();
        return products;
    }

    @Override
    public void update(StoreProduct product) {
        StoreProductDAO productDAO = new StoreProductDAOImpl();
        productDAO.update(product);
    }

    @Override
    public boolean delete(StoreProduct product) {
        StoreProductDAO productDAO = new StoreProductDAOImpl();
        boolean result = productDAO.delete(product);
        //System.out.println("Delete product: " + result);
        return result;
    }

    @Override
    public StoreProduct findSomethingByUpc(String upc) {
        StoreProductDAO productDAO = new StoreProductDAOImpl();
        StoreProduct product = productDAO.findSomethingByUpc(upc);
        return product;
    }
}
