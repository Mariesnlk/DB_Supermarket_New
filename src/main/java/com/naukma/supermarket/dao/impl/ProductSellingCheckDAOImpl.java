package com.naukma.supermarket.dao.impl;

import com.naukma.supermarket.dao.interf.ProductSellingCheckDAO;
import com.naukma.supermarket.database.DBHelper;
import com.naukma.supermarket.model.ProductSellingCheck;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductSellingCheckDAOImpl implements ProductSellingCheckDAO {

    private static final Logger LOG = Logger.getLogger(ProductSellingCheckDAOImpl.class);

    @Override
    public List<ProductSellingCheck> checksListByCashierFromPeriod(String idEmployee, Date dateFrom, Date dateTo) {
        List<ProductSellingCheck> list = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT P.product_name, S.product_number, S.selling_price, C.check_number, C.id_employee\n" +
                    "FROM db_supermarket.product  P\n" +
                    "INNER JOIN db_supermarket.store_product ST ON P.id_product=ST.id_product\n" +
                    "INNER JOIN db_supermarket.sale S ON ST.UPC=S.UPC\n" +
                    "INNER JOIN db_supermarket.check C ON S.check_number=C.check_number\n" +
                    "WHERE C.print_date BETWEEN ? AND  ? AND C.id_employee IN \n" +
                    "(SELECT id_employee \n" +
                    "FROM db_supermarket.employee\n" +
                    "WHERE id_employee = ? AND role = 'cashier')";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, String.valueOf(dateFrom));
            ps.setString(2, String.valueOf(dateTo));
            ps.setString(3, String.valueOf(idEmployee));

            rs = ps.executeQuery();

            while (rs.next()) {

                String productName = rs.getString("product_name");
                Integer productNumber = rs.getInt("product_number");
                Double sellingPrice = rs.getDouble("selling_price");
                String checkNumber = rs.getString("check_number");

                ProductSellingCheck productSellingCheck = new ProductSellingCheck(productName, productNumber,
                        sellingPrice, checkNumber, idEmployee);
                list.add(productSellingCheck);
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
        return list;
    }

    @Override
    public List<ProductSellingCheck> checksListByAllFromPeriod(Date dateFrom, Date dateTo) {
        List<ProductSellingCheck> list = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT P.product_name, S.product_number, S.selling_price, C.check_number, C.id_employee\n" +
                    "FROM db_supermarket.product  P\n" +
                    "INNER JOIN db_supermarket.store_product ST ON P.id_product=ST.id_product\n" +
                    "INNER JOIN db_supermarket.sale S ON ST.UPC=S.UPC\n" +
                    "INNER JOIN db_supermarket.check C ON S.check_number=C.check_number\n" +
                    "WHERE C.print_date BETWEEN ? AND  ? AND C.id_employee IN (SELECT id_employee \n" +
                    "FROM db_supermarket.employee\n" +
                    "WHERE role = 'cashier')";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, String.valueOf(dateFrom));
            ps.setString(2, String.valueOf(dateTo));

            rs = ps.executeQuery();

            while (rs.next()) {

                String productName = rs.getString("product_name");
                Integer productNumber = rs.getInt("product_number");
                Double sellingPrice = rs.getDouble("selling_price");
                String checkNumber = rs.getString("check_number");
                String idEmployee = rs.getString("id_employee");

                ProductSellingCheck productSellingCheck = new ProductSellingCheck(productName, productNumber,
                        sellingPrice, checkNumber, idEmployee);
                list.add(productSellingCheck);
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
        return list;
    }

    @Override
    public List<ProductSellingCheck> listProductsByCheck(String checkNumber) {
        List<ProductSellingCheck> listProducts = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT S.selling_price, S.product_number, P.product_name\n" +
                    "FROM db_supermarket.check C\n" +
                    "INNER JOIN db_supermarket.sale S\n" +
                    "ON C.check_number=S.check_number\n" +
                    "INNER JOIN db_supermarket.store_product SP\n" +
                    "ON S.UPC=SP.UPC\n" +
                    "INNER JOIN db_supermarket.product P\n" +
                    "ON SP.id_product=P.id_product\n" +
                    "WHERE C.check_number = ?";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, String.valueOf(checkNumber));

            rs = ps.executeQuery();

            while (rs.next()) {

                String productName = rs.getString("product_name");
                Integer productNumber = rs.getInt("product_number");
                Double sellingPrice = rs.getDouble("selling_price");

                ProductSellingCheck productSellingCheck = new ProductSellingCheck(productName, productNumber,
                        sellingPrice);
                listProducts.add(productSellingCheck);
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
        return listProducts;
    }
}
