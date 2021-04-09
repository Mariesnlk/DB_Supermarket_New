package com.naukma.supermarket.dao.interf;

import com.naukma.supermarket.model.CustomerCard;

import java.util.List;

public interface CustomerCardDAO extends CRUDDAO<CustomerCard, String> {

    List<CustomerCard> customerWithPercent(Integer percent);

    CustomerCard customerWithSurname(String surname);

    List<CustomerCard> customerWithCashierCheck(String idEmployee);

    List<CustomerCard> listAllCustomers();

}
