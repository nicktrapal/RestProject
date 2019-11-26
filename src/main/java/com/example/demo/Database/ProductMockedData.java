package com.example.demo.Database;

import com.example.demo.Entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductMockedData {
    private List<Product> products = new ArrayList<>();

    private static ProductMockedData instance = null;

    public static ProductMockedData getInstance()
    {
        if (instance == null)
            instance = new ProductMockedData();

        return instance;
    }

    public Product createProduct(Product newProduct)
    {
        if (newProduct != null)
        {
            newProduct.setActivated(true);

            if (products.size() != 0)
                newProduct.setCode(products.get(products.size() - 1).getCode() + 1);
            else
                newProduct.setCode(1);

            products.add(newProduct);
        }

        return newProduct;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductByCode(int productCode)
    {
        for (Product p : products) {
            if (p.getCode() == productCode && p.isActivated())
                return p;
        }

        return null;
    }

    public List<Product> getProductsByName(String productName)
    {
        List<Product> matches = new ArrayList<Product>();

        for (Product p : products) {
            if (p.getName().contains(productName) && p.isActivated())
                matches.add(p);
        }
        return matches;
    }

    public Product deactivateProduct(int productCode)
    {
        for (Product p : products)
        {
            if (p.getCode() == productCode)
            {
                p.setActivated(false);
                return p;
            }
        }

        return null;
    }

    public Product reactivateProduct(int productCode)
    {
        for (Product p : products)
        {
            if (p.getCode() == productCode)
            {
                p.setActivated(true);
                return p;
            }
        }

        return null;
    }

    public List<Product> getProductsPrice(String order)
    {
        List<Product> products_sorted = new ArrayList<>(products);
        for (Product p : products_sorted)
        {
            if (!p.isActivated())
                products_sorted.remove(p);
        }

        if (products_sorted.size()>0)
        {
            if (order == null || order.equals("asc"))
                products_sorted.sort(Comparator.comparing(Product::getPrice));
            else if (order.equals("desc"))
                products_sorted.sort(Comparator.comparing(Product::getPrice).reversed());
        }

        return products_sorted;
    }

}
