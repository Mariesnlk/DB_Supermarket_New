package com.naukma.supermarket.service.interf;

import com.naukma.supermarket.model.CustomerCard;

import java.util.List;

public interface CustomerCardService extends CRUDService<CustomerCard, String> {

    List<CustomerCard> customerWithPercent(Integer percent);

    List<CustomerCard> customerWithCashierCheck(String idEmployee);

    CustomerCard customerWithSurname(String surname);

}
