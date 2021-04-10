package com.naukma.supermarket.service.interf;

import com.naukma.supermarket.model.Sale;

import java.util.Date;

public interface SaleService extends CRUDService<Sale, String> {

    //Визначити загальну кількість одиниць певного товару, проданого за певний період часу
    Sale productCount(String productName, Date startDate, Date finishDate);


}
