package com.naukma.supermarket.dao.interf;

import com.naukma.supermarket.model.Product;

import java.util.List;

public interface ProductDAO extends CRUDDAO<Product, Integer> {

    // Скласти список усіх товарів, відсортованих за назвою
    List<Product> allProductsSortedByName();

    List<Product> productByCategory(String nameCategory);

    List<Product> productByCategoryOrdered(String nameCategory);

}
