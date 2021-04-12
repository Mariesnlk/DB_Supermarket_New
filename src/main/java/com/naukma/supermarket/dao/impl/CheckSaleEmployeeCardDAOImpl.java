package com.naukma.supermarket.dao.impl;

import com.naukma.supermarket.dao.interf.CheckSaleEmployeeCardDAO;
import com.naukma.supermarket.database.DBHelper;
import com.naukma.supermarket.model.CheckSaleEmployeeCard;
import org.apache.log4j.Logger;

import java.sql.*;

public class CheckSaleEmployeeCardDAOImpl implements CheckSaleEmployeeCardDAO {

    private static final Logger LOG = Logger.getLogger(CheckSaleEmployeeCardDAOImpl.class);

    @Override
    public CheckSaleEmployeeCard checkInfo(String checkNumber) {
        CheckSaleEmployeeCard checkInfo = null;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String query = "SELECT SUM(S.product_number*S.selling_price) AS sum_product_total, C.check_number, C.print_date, C.vat, E.empl_surname, E.empl_name, E.empl_patronymic\n" +
                    "FROM db_supermarket.check C\n" +
                    "INNER JOIN db_supermarket.sale S\n" +
                    "ON C.check_number=S.check_number\n" +
                    "INNER JOIN db_supermarket.employee E\n" +
                    "ON C.id_employee=E.id_employee\n" +
                    "INNER JOIN db_supermarket.customer_card CC\n" +
                    "ON C.card_number=CC.card_number\n" +
                    "WHERE C.check_number = ?";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, checkNumber);

            rs = ps.executeQuery();

            while (rs.next()) {

                Double sumProductTotal = rs.getDouble("sum_product_total");
                Date printDate = rs.getDate("print_date");
                Double vat = rs.getDouble("vat");
                String emplSurname = rs.getString("empl_surname");
                String emplName = rs.getString("empl_name");
                String emplPatronymic = rs.getString("empl_patronymic");

                checkInfo = new CheckSaleEmployeeCard(sumProductTotal, checkNumber, printDate, vat,
                        emplSurname, emplName, emplPatronymic);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in StoreProductDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return checkInfo;
    }
}
