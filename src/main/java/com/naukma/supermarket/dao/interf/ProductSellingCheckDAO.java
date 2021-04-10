package com.naukma.supermarket.dao.interf;

import com.naukma.supermarket.model.ProductSellingCheck;

import java.util.Date;
import java.util.List;

public interface ProductSellingCheckDAO {

    List<ProductSellingCheck> checksListByCashierFromPeriod(String idEmployee, Date dateFrom, Date dateTo);
}
