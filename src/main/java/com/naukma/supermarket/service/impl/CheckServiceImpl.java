package com.naukma.supermarket.service.impl;

import com.naukma.supermarket.dao.impl.CheckDAOImpl;
import com.naukma.supermarket.dao.interf.CheckDAO;
import com.naukma.supermarket.model.Check;
import com.naukma.supermarket.model.CustomerCard;
import com.naukma.supermarket.model.Sale;
import com.naukma.supermarket.service.interf.CheckService;
import com.naukma.supermarket.service.interf.CustomerCardService;
import com.naukma.supermarket.service.interf.SaleService;

import java.util.Date;
import java.util.List;

public class CheckServiceImpl implements CheckService {

    @Override
    public void create(Check check) {
        check.setVat((check.getSum_total() * 0.2) / 1.2);//пдв

        double sum = 0;

        SaleService saleService = new SaleServiceImpl();
        List<Sale> saleList = saleService.findAll();
        for (Sale sale : saleList) {
            if (sale.getCheck_number().equals(check.getCheck_number())) {
                sum += sale.getProduct_number() * sale.getSelling_price();//сума без пдв
            }
        }

        CustomerCardService customerCardService = new CustomerCardServiceImpl();
        List<CustomerCard> allStoreProducts = customerCardService.findAll();
        for (CustomerCard customerCard : allStoreProducts) {
            if (customerCard.getCard_number().equals(check.getCard_number())) {
                check.setSum_total(sum - check.getSum_total() * customerCard.getPercent());//загальна сума зі знижкою
            }
        }

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
        check.setVat((check.getSum_total() * 0.2) / 1.2);//пдв

        double sum = 0;

        SaleService saleService = new SaleServiceImpl();
        List<Sale> saleList = saleService.findAll();
        for (Sale sale : saleList) {
            if (sale.getCheck_number().equals(check.getCheck_number())) {
                sum += sale.getProduct_number() * sale.getSelling_price();//сума без пдв
            }
        }

        CustomerCardService customerCardService = new CustomerCardServiceImpl();
        List<CustomerCard> allStoreProducts = customerCardService.findAll();
        for (CustomerCard customerCard : allStoreProducts) {
            if (customerCard.getCard_number().equals(check.getCard_number())) {
                check.setSum_total(sum - check.getSum_total() * customerCard.getPercent());//загальна сума зі знижкою
            }
        }

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

    @Override
    public Check totalSumOfChecksAllEmployees(Date dateFrom, Date dateTo) {
        CheckDAO checkDAO = new CheckDAOImpl();
        Check check = checkDAO.totalSumOfChecksAllEmployees(dateFrom, dateTo);
        return check;
    }

    @Override
    public List<Check> allChecksFromPeriod(String idEmployee, Date dateFrom, Date dateTo) {
        CheckDAO checkDAO = new CheckDAOImpl();
        List<Check> checks = checkDAO.allChecksFromPeriod(idEmployee, dateFrom, dateTo);
        return checks;
    }

    @Override
    public List<Check> checksFromPeriodOfCashier(String idEmployee, Date dateFrom, Date dateTo) {
        CheckDAO checkDAO = new CheckDAOImpl();
        List<Check> checks = checkDAO.checksFromPeriodOfCashier(idEmployee, dateFrom, dateTo);
        return checks;
    }
}
