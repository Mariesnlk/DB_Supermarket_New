package com.naukma.supermarket.dao.interf;

import com.naukma.supermarket.model.CustomerCard;

import java.util.List;

public interface CustomerCardDAO extends CRUDDAO<CustomerCard, String> {

    // Список усіх постійних клієнтів, що мають карту клієнта з певним відсотком
    List<CustomerCard> customerWithPercent(Integer percent);

    // Вивести усю інформацію про покупця з певним прізвищем, що має карту клієнта
    CustomerCard customerWithSurname(String surname);

    List<CustomerCard> customerWithCashierCheck(String idEmployee);

}
