package com.naukma.supermarket.dao.impl;

import com.naukma.supermarket.dao.interf.StoreProductDAO;
import com.naukma.supermarket.database.DBHelper;
import com.naukma.supermarket.model.Product;
import com.naukma.supermarket.model.StoreProduct;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreProductDAOImpl implements StoreProductDAO {

    private static final Logger LOG = Logger.getLogger(StoreProductDAOImpl.class);

    @Override
    public void create(StoreProduct product) {
        DBHelper dbHelper = new DBHelper();
        Connection connection = dbHelper.getConnection();

        PreparedStatement ps = null;

        try {
            String upc = product.getUPC();
            String UPCprom = product.getUPC_prom();
            Integer idProduct = product.getId_product();
            Double sellingPrice = product.getSelling_price();
            Integer productsNumber = product.getProducts_number();
            Boolean promotionalProduct = product.getPromotional_product();

            String query = "INSERT INTO db_supermarket.store_product(UPC, UPC_prom, id_product, selling_price," +
                    "products_number, promotional_product) VALUES(?,?,?,?,?,?)";


            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, upc);
            ps.setString(2, UPCprom);
            ps.setInt(3, idProduct);
            ps.setDouble(4, sellingPrice);
            ps.setInt(5, productsNumber);
            ps.setBoolean(6, promotionalProduct);

            ps.executeUpdate();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    LOG.error("SQLException occurred in StoreProductDaoImpl", e);
                    //System.out.println(e);
                }
            }
        }
    }

    @Override
    public StoreProduct findById(String upc) {

        StoreProduct product = null;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String query = "SELECT * FROM db_supermarket.store_product WHERE UPC = ?";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, upc);

            rs = ps.executeQuery();

            while (rs.next()) {

                String UPCprom = rs.getString("UPC_prom");
                Integer idProduct = rs.getInt("id_product");
                Double sellingPrice = rs.getDouble("selling_price");
                Integer productsNumber = rs.getInt("products_number");
                Boolean promotionalProduct = rs.getBoolean("promotional_product");

                product = new StoreProduct(upc, UPCprom, idProduct, sellingPrice, productsNumber, promotionalProduct);
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
        return product;
    }

    @Override
    public List<StoreProduct> findAll() {
        List<StoreProduct> productList = new ArrayList<>();

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String query = "SELECT * FROM db_supermarket.store_product";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            rs = ps.executeQuery();

            while (rs.next()) {

                String upc = rs.getString("UPC");
                String UPCprom = rs.getString("UPC_prom");
                Integer idProduct = rs.getInt("id_product");
                Double sellingPrice = rs.getDouble("selling_price");
                Integer productsNumber = rs.getInt("products_number");
                Boolean promotionalProduct = rs.getBoolean("promotional_product");

                StoreProduct product = new StoreProduct(upc, UPCprom, idProduct, sellingPrice, productsNumber, promotionalProduct);
                productList.add(product);
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
        return productList;
    }

    @Override
    public void update(StoreProduct product) {
        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {

            String newUpc = product.getUPC();
            String newUPCprom = product.getUPC_prom();
            Integer newIdProduct = product.getId_product();
            Double newSellingPrice = product.getSelling_price();
            Integer newProductsNumber = product.getProducts_number();
            Boolean newPromotionalProduct = product.getPromotional_product();

            String query =
                    "UPDATE db_supermarket.store_product SET UPC = '" + newUpc + "', UPC_prom = '" + newUPCprom + "', " +
                            "id_product = '" + newIdProduct + "', " + "selling_price = '" + newSellingPrice +
                            "'," + "products_number = '" + newProductsNumber + "', " + "promotional_product = '" + newPromotionalProduct +
                            "' WHERE UPC = ?";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, newUpc);

            ps.executeUpdate();

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
    }

    @Override
    public boolean delete(StoreProduct product) {

        boolean result = false;
        int changedRowsNumber = 0;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        try {
            String upc = product.getUPC();

            String query = "DELETE FROM db_supermarket.store_product WHERE UPC = ?";
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
                    LOG.error("SQLException occurred in StoreProductDaoImpl", e);
                    //e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public StoreProduct findSomethingByUpc(String  upc) {
        StoreProduct product = null;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String query = "SELECT selling_price, products_number FROM db_supermarket.store_product WHERE UPC = ?";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, upc);

            rs = ps.executeQuery();

            while (rs.next()) {

                Double sellingPrice = rs.getDouble("selling_price");
                Integer productsNumber = rs.getInt("products_number");

                product = new StoreProduct(sellingPrice, productsNumber); //maybe need to add id
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
        return product;
    }

    @Override
    public StoreProduct findProductInfoByUPC(String upc) {
        StoreProduct product = null;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String query = "SELECT S.selling_price, S.products_number, " +
                    "P.product_name, P.characteristics " +
                    "FROM db_supermarket.store_product S " +
                    "INNER JOIN db_supermarket.product P " +
                    "ON S.id_product = P.id_product";
            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, upc);

            rs = ps.executeQuery();

            while (rs.next()) {

                Double sellingPrice = rs.getDouble("selling_price");
                Integer productsNumber = rs.getInt("products_number");

                product = new StoreProduct(sellingPrice, productsNumber); //maybe need to add id
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
        return product;
    }
}

