package com.emc.shoppingcart.services;

import java.util.List;

import com.emc.shoppingcart.model.Product;

public interface ProductService {
public String addProduct(Product product);
public String removeProduct(long productId);
public String updateProduct(Product product);
public List<Product> getProducts();
public String removeMultipleProducts(List<Integer> productidList);
public String transactionExProduct(Product product) ;
}
