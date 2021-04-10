package com.naukma.supermarket.dao.interf;

import com.naukma.supermarket.model.Sale;

import java.util.Date;

public interface SaleDAO extends CRUDDAO<Sale, String> {

    Sale productCount(String productName, Date startDate, Date finishDate);

}
