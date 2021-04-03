package com.naukma.supermarket.service.interf;

import com.naukma.supermarket.model.Check;

import java.util.Date;

public interface CheckService extends CRUDService<Check, String> {

    Check totalSumOfChecks(String idEmployee, Date dateFrom, Date dateTo);

}
