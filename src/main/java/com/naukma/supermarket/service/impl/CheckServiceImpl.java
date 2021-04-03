package com.naukma.supermarket.service.impl;

import com.naukma.supermarket.dao.impl.CheckDAOImpl;
import com.naukma.supermarket.dao.interf.CheckDAO;
import com.naukma.supermarket.model.Check;
import com.naukma.supermarket.service.interf.CheckService;

import java.util.Date;
import java.util.List;

public class CheckServiceImpl implements CheckService {

    @Override
    public void create(Check check) {
        CheckDAO checkDAO = new CheckDAOImpl();
        checkDAO.create(check);
    }

    @Override
    public Check findById(String checkNum) {
        CheckDAO checkDAO = new CheckDAOImpl();
        Check check = checkDAO.findById(checkNum);
        return check;
    }

    @Override
    public List<Check> findAll() {
        CheckDAO checkDAO = new CheckDAOImpl();
        List<Check> checks = checkDAO.findAll();
        return checks;
    }

    @Override
    public void update(Check check) {
        CheckDAO checkDAO = new CheckDAOImpl();
        checkDAO.update(check);
    }

    @Override
    public boolean delete(Check check) {
        CheckDAO checkDAO = new CheckDAOImpl();
        boolean result = checkDAO.delete(check);
        //System.out.println("Delete check: " + result);
        return result;
    }

    @Override
    public Check totalSumOfChecks(String idEmployee, Date dateFrom, Date dateTo) {
        CheckDAO checkDAO = new CheckDAOImpl();
        Check check = checkDAO.totalSumOfChecks(idEmployee, dateFrom, dateTo);
        return check;
    }
}
