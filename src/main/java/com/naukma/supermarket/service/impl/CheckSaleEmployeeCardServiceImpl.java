package com.naukma.supermarket.service.impl;

import com.naukma.supermarket.dao.impl.CheckSaleEmployeeCardDAOImpl;
import com.naukma.supermarket.dao.interf.CheckSaleEmployeeCardDAO;
import com.naukma.supermarket.model.CheckSaleEmployeeCard;
import com.naukma.supermarket.service.interf.CheckSaleEmployeeCardService;

public class CheckSaleEmployeeCardServiceImpl implements CheckSaleEmployeeCardService {


    @Override
    public CheckSaleEmployeeCard checkInfo(String checkNumber) {
        CheckSaleEmployeeCardDAO checkInfo = new CheckSaleEmployeeCardDAOImpl();
        CheckSaleEmployeeCard info = checkInfo.checkInfo(checkNumber);
        return info;
    }
}
