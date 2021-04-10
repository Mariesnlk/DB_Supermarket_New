package com.naukma.supermarket.dao.impl;

import com.naukma.supermarket.dao.interf.StoreProductAndProductDAO;
import com.naukma.supermarket.database.DBHelper;
import com.naukma.supermarket.model.StoreProduct;
import com.naukma.supermarket.model.StoreProductAndProduct;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreProductAndProductDAOImpl  implements StoreProductAndProductDAO {

    private static final Logger LOG = Logger.getLogger(StoreProductAndProductDAOImpl.class);

    @Override
    public StoreProductAndProduct findInfoByUPC(String upc) {
        StoreProductAndProduct storeProductAndProduct = null;

        DBHelper objectDBHelper = new DBHelper();
        Connection connection = objectDBHelper.getConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            String query = "SELECT store_product.selling_price, store_product.products_number, product.product_name, product.characteristics\n" +
                    "FROM db_supermarket.store_product\n" +
                    "INNER JOIN db_supermarket.product\n" +
                    "ON store_product.id_product = product.id_product\n" +
                    "WHERE UPC=?";

            ps = connection.prepareStatement(query);

            LOG.debug("Executed query" + query);

            ps.setString(1, upc);

            rs = ps.executeQuery();

            while (rs.next()) {

                Double sellingPrice = rs.getDouble("selling_price");
                Integer productsNumber = rs.getInt("products_number");
                String productName = rs.getString("product_name");
                String characters = rs.getString("characteristics");

                storeProductAndProduct = new StoreProductAndProduct(sellingPrice, productsNumber, productName, characters);
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
        return storeProductAndProduct;
    }
}
