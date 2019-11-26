package com.example.demo.Rest;

import com.example.demo.CustomObjects.Status;
import com.example.demo.Entities.Product;
import com.example.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/service")
public class ProductController {

    @Autowired
    private ProductService productService;

    /*@GetMapping("/products")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }*/

    @GetMapping(value="/products",params="code")
    public Object getProductByCode(@RequestParam String code)
    {
        int productCode = Integer.parseInt(code);
        return productService.getProductByCode(productCode);
    }

    @GetMapping(value="/products",params="name")
    public List <Product> getProductsByName(@RequestParam String name)
    {
        return productService.getProductsByName(name);
    }

    @GetMapping(value="/products/prices")
    public List <Product> getProductsByPrice(@RequestParam (required=false) String order)
    {
        return productService.getProductsPrice(order);
    }

    @PutMapping(value="/products/{code}",params="deactivate")
    public Status deactivate(@PathVariable String code,@RequestParam String deactivate){
        int productCode = Integer.parseInt(code);
        return productService.deactivateProduct(productCode);
    }

   @PutMapping(value="/products/{code}",params="reactivate")
    public Status reactivate(@PathVariable String code,@RequestParam String reactivate){
        int productCode = Integer.parseInt(code);
        return productService.reactivateProduct(productCode);
    }

    @PostMapping("/products")
    public Status create(@RequestBody Product product){
        return productService.insertProduct(product);
    }



}
