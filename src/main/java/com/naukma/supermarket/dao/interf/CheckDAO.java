package com.naukma.supermarket.dao.interf;

import com.naukma.supermarket.model.Check;

import java.util.Date;
import java.util.List;

public interface CheckDAO extends CRUDDAO<Check, String> {

    Check totalSumOfChecks(String idEmployee, Date dateFrom, Date dateTo);

    Check totalSumOfChecksAllEmployees(Date dateFrom, Date dateTo);

    List<Check> allChecksFromPeriod(String idEmployee, Date dateFrom, Date dateTo);

    List<Check> checksFromPeriodOfCashier(String idEmployee, Date dateFrom, Date dateTo);

}