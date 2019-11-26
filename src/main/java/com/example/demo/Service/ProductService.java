package com.example.demo.Service;

import com.example.demo.CustomObjects.Status;
import com.example.demo.Database.ProductMockedData;
import com.example.demo.Entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private ProductMockedData productMockedData=ProductMockedData.getInstance();
    private Status status = new Status();

    public Status insertProduct(Product product)
    {
        if (productMockedData.createProduct(product)!=null)
        {
            status.setStatus("201");
            status.setMessage("Product created successfully");
        }
        else
        {
            status.setStatus("404");
            status.setMessage("There was an issue with the creation of the product, try again");
        }
        return status;
    }

    public List<Product> getAllProducts()
    {
        return productMockedData.getAllProducts();
    }

    public Object getProductByCode(int productCode)
    {
        Product p = productMockedData.getProductByCode(productCode);
        if (p!=null)
         return p;
        else
        {
            status.setStatus("404");
            status.setMessage("Product not found");
            return status;
        }

    }

    public List<Product> getProductsByName(String name)
    {
        return productMockedData.getProductsByName(name);
    }

    public List<Product> getProductsPrice(String order)
    {
        return productMockedData.getProductsPrice(order);
    }

    public Status deactivateProduct(int productCode)
    {
        if (productMockedData.deactivateProduct(productCode)!=null)
        {
            status.setStatus("200");
            status.setMessage("Product deactivated successfully");
        }
        else
        {
            status.setStatus("404");
            status.setMessage("Product not found");
        }
        return status;
    }

    public Status reactivateProduct(int productCode)
    {
        if (productMockedData.reactivateProduct(productCode)!=null)
        {
            status.setStatus("200");
            status.setMessage("Product reactivated successfully");
        }
        else
        {
            status.setStatus("404");
            status.setMessage("Product not found");
        }
        return status;
    }


}
