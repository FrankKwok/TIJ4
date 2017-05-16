package com.github.frankkwok.tij4.generics;

import com.github.frankkwok.tij4.util.Generator;

import java.util.ArrayList;

/**
 * Page 484
 * Exercise 19: Following the form of Store.java, build a model of a containerized cargo ship.
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class CargoShip extends ArrayList<Container> {
    public CargoShip(int containerNumber, int productNumber) {
        for (int i = 0; i < containerNumber; i++) {
            add(new Container(productNumber));
        }
    }

    public static void main(String[] args) {
        System.out.println(new CargoShip(10, 20));
    }
}

class Product {
    private final int id;
    private String description;
    private double price;

    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
        System.out.println(toString());
    }

    public String toString() {
        return id + ": " + description + ", price: $" + price;
    }

    public void priceChange(double change) {
        price += change;
    }

    public static Generator<Product> generator = () -> new Product((int) (Math.random() * 1000),
            "Test", Math.random() * 1000.0);
}

class Container extends ArrayList<Product> {
    public Container(int productNumber) {
        Generators.fill(this, Product.generator, productNumber);
    }
}
