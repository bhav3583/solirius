package org.technical.model;

import java.util.List;

public class ProductPojo {
    private String name;
    private String description;
    private double price;
    private List<Variant> variants;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

    public static ProductPojo getRequestBody(String name, String description, double price, List<Variant> variants){
      ProductPojo productPojo = new ProductPojo();
      productPojo.setName(name);
      productPojo.setDescription(description);
      productPojo.setPrice(price);
      productPojo.setVariants(variants);
      return productPojo;
    }
}
