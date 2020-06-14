package org.academy.api.pojo.karyna.chelpan;

import java.util.Map;

public class Product {
    private long id;
    private String name;
    private Map<String, Integer> quantity;
    private Map<String, Integer> weight;
    private double price;

    public Product(long id, String name, Map<String, Integer> quantity, Map<String, Integer> weight, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(Map<String, Integer> quantity) {
        this.quantity = quantity;
    }

    public Map<String, Integer> getWeight() {
        return weight;
    }

    public void setWeight(Map<String, Integer> weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
