package com.naukma.supermarket.service.interf;

import com.naukma.supermarket.model.Product;

import java.util.List;

public interface ProductService extends CRUDService<Product, Integer> {

    List<Product> allProductsSortedByName();

}
