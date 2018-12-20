package my.vlong.java.javahero;

import java.util.Scanner;

public abstract class Product {
    private static int COUNTER = 0;

    protected int id;
    protected String name;
    protected float salePrice;

    public Product() {
        this.id = ++COUNTER;
    }

    public abstract void inputProduct(Scanner scanner) throws ProductException;

    public abstract void displayProduct();

    public abstract void calculateSalePrice();

    public abstract boolean validateInput();
}
