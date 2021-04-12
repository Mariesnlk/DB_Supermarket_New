package com.naukma.supermarket.service.impl;

import com.naukma.supermarket.dao.impl.SaleDAOImpl;
import com.naukma.supermarket.dao.interf.SaleDAO;
import com.naukma.supermarket.model.Sale;
import com.naukma.supermarket.model.StoreProduct;
import com.naukma.supermarket.service.interf.SaleService;
import com.naukma.supermarket.service.interf.StoreProductService;

import java.util.Date;
import java.util.List;

public class SaleServiceImpl implements SaleService {

    @Override
    public void create(Sale sale) {
        double coeff = 0;
        StoreProductService storeProductService = new StoreProductServiceImpl();
        List<StoreProduct> allStoreProducts = storeProductService.findAll();
        for (StoreProduct storeProduct : allStoreProducts) {
            if (storeProduct.getUPC().equals(sale.getUPC())) {
                if (storeProduct.getPromotional_product()) {
                    coeff = 1.2;
                } else {
                    coeff = 1.3;
                }
                sale.setSelling_price(storeProduct.getSelling_price() + coeff * storeProduct.getSelling_price());
            }
        }
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
        double coeff = 0;
        StoreProductService storeProductService = new StoreProductServiceImpl();
        List<StoreProduct> allStoreProducts = storeProductService.findAll();
        for (StoreProduct storeProduct : allStoreProducts) {
            if (storeProduct.getUPC().equals(sale.getUPC())) {
                if (storeProduct.getPromotional_product()) {
                    coeff = 1.2;
                } else {
                    coeff = 1.3;
                }
                sale.setSelling_price(storeProduct.getSelling_price() + coeff * storeProduct.getSelling_price());
            }
        }
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

    @Override
    public Sale productCount(String productName, Date startDate, Date finishDate) {
        SaleDAO saleDAO = new SaleDAOImpl();
        Sale productCount = saleDAO.productCount(productName, startDate, finishDate);
        return productCount;
    }
}
