package com.naukma.supermarket.service.impl;

import com.naukma.supermarket.dao.impl.CustomerCardDAOImpl;
import com.naukma.supermarket.dao.interf.CustomerCardDAO;
import com.naukma.supermarket.model.CustomerCard;
import com.naukma.supermarket.service.interf.CustomerCardService;

import java.util.List;

public class CustomerCardServiceImpl implements CustomerCardService {

    @Override
    public void create(CustomerCard customerCard) {
        CustomerCardDAO customerCardDAO = new CustomerCardDAOImpl();
        customerCardDAO.create(customerCard);
    }

    @Override
    public CustomerCard findById(String cardNum) {
        CustomerCardDAO customerCardDAO = new CustomerCardDAOImpl();
        CustomerCard customerCard = customerCardDAO.findById(cardNum);
        return customerCard;
    }

    @Override
    public List<CustomerCard> findAll() {
        CustomerCardDAO customerCardDAO = new CustomerCardDAOImpl();
        List<CustomerCard> customerCards = customerCardDAO.findAll();
        return customerCards;
    }

    @Override
    public void update(CustomerCard customerCard) {
        CustomerCardDAO customerCardDAO = new CustomerCardDAOImpl();
        customerCardDAO.update(customerCard);
    }

    @Override
    public boolean delete(CustomerCard customerCard) {
        CustomerCardDAO customerCardDAO = new CustomerCardDAOImpl();
        boolean result = customerCardDAO.delete(customerCard);
        //System.out.println("Delete customerCard: " + result);
        return result;
    }

    @Override
    public List<CustomerCard> customerWithPercent(Integer percent) {
        CustomerCardDAO customerCardDAO = new CustomerCardDAOImpl();
        List<CustomerCard> customerCards = customerCardDAO.customerWithPercent(percent);
        return customerCards;
    }

    @Override
    public List<CustomerCard> customerWithCashierCheck(String idEmployee) {
        CustomerCardDAO customerCardDAO = new CustomerCardDAOImpl();
        List<CustomerCard> customerCards = customerCardDAO.customerWithCashierCheck(idEmployee);
        return customerCards;
    }

    @Override
    public CustomerCard customerWithSurname(String surname) {
        CustomerCardDAO customerCardDAO = new CustomerCardDAOImpl();
        CustomerCard customerCard = customerCardDAO.customerWithSurname(surname);
        return customerCard;
    }
}
