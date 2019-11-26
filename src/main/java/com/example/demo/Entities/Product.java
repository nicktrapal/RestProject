package com.example.demo.Entities;

public class Product {
    private int code;
    private String name;
    private Double price;
    private String expirationDate;
    private String availabilityDate;
    private boolean activated;

    public Product(){}

    public Product(int code,String name,double price,String expirationDate,String availabilityDate)
    {

        setName(name);
        setPrice(price);
        setExpirationDate(expirationDate);
        setAvailabilityDate(availabilityDate);
        setActivated(true);
    }

    public boolean isActivated() { return activated; }

    public void setActivated(boolean activated) { this.activated = activated; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getAvailabilityDate() {
        return availabilityDate;
    }

    public void setAvailabilityDate(String availabilityDate) {
        this.availabilityDate = availabilityDate;
    }
}
