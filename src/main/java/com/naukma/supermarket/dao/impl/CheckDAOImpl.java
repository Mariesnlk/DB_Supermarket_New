package com.naukma.supermarket.dao.impl;

import com.naukma.supermarket.dao.interf.CheckDAO;
import com.naukma.supermarket.database.DBHelper;
import com.naukma.supermarket.model.Check;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CheckDAOImpl implements CheckDAO {

    private static final Logger LOG = Logger.getLogger(CheckDAOImpl.class);

    @Override
    public void create(Check check) {
        DBHelper dbHelper = new DBHelper();
        Connection connection = dbHelper.getConnection();

        PreparedStatement ps = null;

        try {

            String checkNumber = check.getCheck_number();
            String idEmployee = check.getId_employee();
            String cardNumber = check.getCard_number();
            Date printDate = (Date) check.getPrint_date();
            Double sumTotal = check.getSum_total();
            Double vat = check.getVat();

            String query = "INSERT INTO db_supermarket.check(check_number, id_employee, card_number, print_date, " +
                    "sum_total, vat) VALUES(?, ?, ?, ?, ?, ?)";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, checkNumber);
            ps.setString(2, idEmployee);
            ps.setString(3, cardNumber);
            ps.setDate(4, printDate);
            ps.setDouble(5, sumTotal);
            ps.setDouble(6, vat);

            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CheckDaoImpl", e);
                    //System.out.println(e);
                }
            }
        }
    }

    @Override
    public Check findById(String checkNum) {

        Check check = null;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String query = "SELECT * FROM db_supermarket.check WHERE check_number = ?";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, checkNum);

            rs = ps.executeQuery();

            while (rs.next()) {

                String idEmployee = rs.getString("id_employee");
                String cardNumber = rs.getString("card_number");
                Date printDate = rs.getDate("print_date");
                Double sumTotal = rs.getDouble("sum_total");
                Double vat = rs.getDouble("vat");

                check = new Check(checkNum, idEmployee, cardNumber, printDate, sumTotal, vat);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CheckDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return check;
    }

    @Override
    public List<Check> findAll() {
        List<Check> checkList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM db_supermarket.check";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            rs = ps.executeQuery();

            while (rs.next()) {

                String checkNumber = rs.getString("check_number");
                String idEmployee = rs.getString("id_employee");
                String cardNumber = rs.getString("card_number");
                Date printDate = rs.getDate("print_date");
                Double sumTotal = rs.getDouble("sum_total");
                Double vat = rs.getDouble("vat");

                Check check = new Check(checkNumber, idEmployee, cardNumber, printDate, sumTotal, vat);
                checkList.add(check);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CheckDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return checkList;
    }

    @Override
    public void update(Check check) {
        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {

            String newCheckNumber = check.getCheck_number();
            String newIdEmployee = check.getId_employee();
            String newCardNumber = check.getCard_number();
            Date newPrintDate = (Date) check.getPrint_date();
            Double newSumTotal = check.getSum_total();
            Double newVat = check.getVat();

            String query =
                    "UPDATE db_supermarket.check SET id_employee  = '" + newIdEmployee + "', card_number = '" + newCardNumber + "', " +
                            "print_date = '" + newPrintDate + "', " + "sum_total = '" + newSumTotal +
                            "'," + "vat = '" + newVat +
                            "' WHERE check_number = ?";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, newCheckNumber);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CheckDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean delete(Check check) {

        boolean result = false;
        int changedRowsNumber = 0;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {
            String checkNum = check.getCheck_number();

            String query = "DELETE FROM db_supermarket.check WHERE check_number = ?";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, checkNum);

            //System.out.println(ps);
            changedRowsNumber = ps.executeUpdate();
            System.out.println("changedRowsNumber=" + changedRowsNumber);
            if (changedRowsNumber > 0) {
                result = true;
            }

        } catch (Exception e) {
            System.out.println(e);
            result = false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CheckDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public Check totalSumOfChecks(String idEmployee,  java.util.Date dateFrom, java.util.Date dateTo) {
        Check check = null;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String query = "SELECT SUM(sum_total) AS total_sum_all_checks FROM db_supermarket.check WHERE id_employee = ? AND print_date BETWEEN ? AND ?";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, idEmployee);
            ps.setString(2, String.valueOf(dateFrom));
            ps.setString(3, String.valueOf(dateTo));

            rs = ps.executeQuery();

            while (rs.next()) {

                Double sumTotal = rs.getDouble("sum_total");

                check = new Check(sumTotal);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in CheckDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return check;
    }
}

