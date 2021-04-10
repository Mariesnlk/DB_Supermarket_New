package com.naukma.supermarket.service.impl;

import com.naukma.supermarket.dao.impl.ProductSellingCheckDAOImpl;
import com.naukma.supermarket.dao.interf.ProductSellingCheckDAO;
import com.naukma.supermarket.model.ProductSellingCheck;
import com.naukma.supermarket.service.interf.ProductSellingCheckService;

import java.util.Date;
import java.util.List;

public class ProductSellingCheckServiceImpl implements ProductSellingCheckService {

    @Override
    public List<ProductSellingCheck> checksListByCashierFromPeriod(String idEmployee, Date dateFrom, Date dateTo) {
        ProductSellingCheckDAO productSellingCheckDAO = new ProductSellingCheckDAOImpl();
        List<ProductSellingCheck> list = productSellingCheckDAO.checksListByCashierFromPeriod(idEmployee, dateFrom, dateTo);
        return list;
    }
}
