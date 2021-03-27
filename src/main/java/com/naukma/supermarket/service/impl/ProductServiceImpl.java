package com.naukma.supermarket.service.impl;

import com.naukma.supermarket.dao.impl.ProductDAOImpl;
import com.naukma.supermarket.dao.interf.ProductDAO;
import com.naukma.supermarket.model.Product;
import com.naukma.supermarket.service.interf.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Override
    public void create(Product product) {
        ProductDAO productDAO = new ProductDAOImpl();
        productDAO.create(product);
    }

    @Override
    public Product findById(Integer id) {
        ProductDAO productDAO = new ProductDAOImpl();
        Product product = productDAO.findById(id);
        return product;
    }

    @Override
    public List<Product> findAll() {
        ProductDAO productDAO = new ProductDAOImpl();
        List<Product> products = productDAO.findAll();
        return products;
    }

    @Override
    public void update(Product product) {
        ProductDAO productDAO = new ProductDAOImpl();
        productDAO.update(product);
    }

    @Override
    public boolean delete(Product product) {
        ProductDAO productDAO = new ProductDAOImpl();
        boolean result = productDAO.delete(product);
        //System.out.println("Delete product: " + result);
        return result;
    }
}
