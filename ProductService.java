package com.example.amazon;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    private ArrayList<Product> productsList = new ArrayList<>();

    public ArrayList<Product> getProducts() {

        return productsList;
    }

    public void addProduct(Product product) {

        productsList.add(product);
    }

    public void updateProduct(int index, Product product) {
        productsList.set(index, product);
    }

    public void deleteProduct(int index) {
        productsList.remove(index);
    }
}