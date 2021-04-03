package com.naukma.supermarket.dao.interf;

import com.naukma.supermarket.model.Check;

import java.util.Date;

public interface CheckDAO extends CRUDDAO<Check, String> {

    Check totalSumOfChecks(String idEmployee, Date dateFrom, Date dateTo);

}