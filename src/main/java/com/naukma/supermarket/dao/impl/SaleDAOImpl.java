package com.naukma.supermarket.dao.impl;

import com.naukma.supermarket.dao.interf.SaleDAO;
import com.naukma.supermarket.database.DBHelper;
import com.naukma.supermarket.model.Sale;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleDAOImpl implements SaleDAO {

    private static final Logger LOG = Logger.getLogger(SaleDAOImpl.class);

    @Override
    public void create(Sale sale) {
        DBHelper dbHelper = new DBHelper();
        Connection connection = dbHelper.getConnection();

        PreparedStatement ps = null;

        try {

            String UPC = sale.getUPC();
            String checkNumber = sale.getCheck_number();
            Integer productNumber = sale.getProduct_number();
            Double sellingPrice = sale.getSelling_price();

            String query = "INSERT INTO db_supermarket.sale(UPC, check_number, product_number," +
                    " selling_price) VALUES(?, ?, ?, ?)";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, UPC);
            ps.setString(2, checkNumber);
            ps.setInt(3, productNumber);
            ps.setDouble(4, sellingPrice);

            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in SaleDaoImpl", e);
                    //System.out.println(e);
                }
            }
        }
    }

    @Override
    public Sale findById(String upc) {

        Sale sale = null;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String query = "SELECT * FROM db_supermarket.sale WHERE UPC = ?";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, upc);

            rs = ps.executeQuery();

            while (rs.next()) {

                String checkNumber = rs.getString("check_number");
                Integer productNumber = rs.getInt("product_number");
                Double sellingPrice = rs.getDouble("selling_price");

                sale = new Sale(upc, checkNumber, productNumber, sellingPrice);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in SaleDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return sale;
    }

    @Override
    public List<Sale> findAll() {
        List<Sale> saleList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM db_supermarket.sale";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            rs = ps.executeQuery();

            while (rs.next()) {

                String UPC = rs.getString("UPC");
                String checkNumber = rs.getString("check_number");
                Integer productNumber = rs.getInt("product_number");
                Double sellingPrice = rs.getDouble("selling_price");

                Sale sale = new Sale(UPC, checkNumber, productNumber, sellingPrice);
                saleList.add(sale);
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in SaleDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return saleList;
    }

    @Override
    public void update(Sale sale) {
        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {

            String newUPC = sale.getUPC();
            String newCheckNumber = sale.getCheck_number();
            Integer newProductNumber = sale.getProduct_number();
            Double newSellingPrice = sale.getSelling_price();

            String query =
                    "UPDATE db_supermarket.sale SET UPC = '" + newUPC +
                            "', check_number = '" + newCheckNumber + "', " +
                            "product_number = '" + newProductNumber + "', " +
                            "selling_price = '" + newSellingPrice +
                            "' WHERE UPC = ?";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, newUPC);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in SaleDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean delete(Sale sale) {

        boolean result = false;
        int changedRowsNumber = 0;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {
            String upc = sale.getUPC();

            String query = "DELETE FROM db_supermarket.sale WHERE UPC = ?";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, upc);

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
                    LOG.error("SQLException occurred in SaleDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return result;
    }
}

