package org.technical.model;

public class Variant {
    private String name;
    private String sku;

    public Variant(String name, String sku, double additionalCost, int stockCount) {
        this.name = name;
        this.sku = sku;
        this.additionalCost = additionalCost;
        this.stockCount = stockCount;
    }

    private double additionalCost;
    private int stockCount;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getAdditionalCost() {
        return additionalCost;
    }

    public void setAdditionalCost(double additionalCost) {
        this.additionalCost = additionalCost;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }


}
