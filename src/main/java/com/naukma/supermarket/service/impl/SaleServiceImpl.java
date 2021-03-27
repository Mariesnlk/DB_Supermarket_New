package com.naukma.supermarket.service.impl;

import com.naukma.supermarket.dao.impl.SaleDAOImpl;
import com.naukma.supermarket.dao.interf.SaleDAO;
import com.naukma.supermarket.model.Sale;
import com.naukma.supermarket.service.interf.SaleService;

import java.util.List;

public class SaleServiceImpl implements SaleService {

    @Override
    public void create(Sale sale) {
        SaleDAO saleDAO = new SaleDAOImpl();
        saleDAO.create(sale);
    }

    @Override
    public Sale findById(String upc) {
        SaleDAO saleDAO = new SaleDAOImpl();
        Sale sale = saleDAO.findById(upc);
        return sale;
    }

    @Override
    public List<Sale> findAll() {
        SaleDAO saleDAO = new SaleDAOImpl();
        List<Sale> sales = saleDAO.findAll();
        return sales;
    }

    @Override
    public void update(Sale sale) {
        SaleDAO saleDAO = new SaleDAOImpl();
        saleDAO.update(sale);
    }

    @Override
    public boolean delete(Sale sale) {
        SaleDAO saleDAO = new SaleDAOImpl();
        boolean result = saleDAO.delete(sale);
        //System.out.println("Delete sale: " + result);
        return result;
    }
}
