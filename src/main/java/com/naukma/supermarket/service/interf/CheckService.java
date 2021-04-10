package com.naukma.supermarket.service.interf;

import com.naukma.supermarket.model.Check;

import java.util.Date;
import java.util.List;

public interface CheckService extends CRUDService<Check, String> {
    //Загальна сума проданих товарів з чеків, видрукуваних певним касиром за певний період часу
    Check totalSumOfChecks(String idEmployee, Date dateFrom, Date dateTo);

    // Загальна сума проданих товарів з чеків, видрукуваних усіма касиром за певний період часу
    Check totalSumOfChecksAllEmployees(Date dateFrom, Date dateTo);

    List<Check> allChecksFromPeriod(String idEmployee, Date dateFrom, Date dateTo);

    //Скласти список чеків,  видрукуваних даним касиром за певний період часу
    List<Check> checksFromPeriodOfCashier(String idEmployee, Date dateFrom, Date dateTo);

}
