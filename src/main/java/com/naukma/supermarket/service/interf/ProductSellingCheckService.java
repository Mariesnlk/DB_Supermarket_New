package com.naukma.supermarket.service.interf;

import com.naukma.supermarket.model.ProductSellingCheck;

import java.util.Date;
import java.util.List;

public interface ProductSellingCheckService {

    //Скласти список чеків, видрукуваних певним касиром за певний період часу (з можливістю перегляду куплених товарів, їх к-сті та ціни)
    List<ProductSellingCheck> checksListByCashierFromPeriod(String idEmployee, Date dateFrom, Date dateTo);
}
