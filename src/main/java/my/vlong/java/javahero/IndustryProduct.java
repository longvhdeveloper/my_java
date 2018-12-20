package my.vlong.java.javahero;

import java.util.Scanner;

public class IndustryProduct extends Product {

    private static final int NUMBER = 1000;

    private int warrantyTime;
    private float originalPrice;

    public void inputProduct(Scanner scanner) throws ProductException {
        if (scanner == null) {
            return;
        }

        System.out.println("=== Enter product information ===");
        System.out.println("Enter product name : ");
        this.name = scanner.nextLine();

        System.out.println("Enter product warranty time : ");
        this.warrantyTime = scanner.nextInt();

        System.out.println("Enter product original price : ");
        this.originalPrice = scanner.nextFloat();

        if (!this.validateInput()) {
            throw new ProductException("Product info input is not valid");
        }
    }

    public void displayProduct() {
        System.out.println("=== Product info ===");
        System.out.println(String.format("Product id: %d", this.id));
        System.out.println(String.format("Product name: %s", this.name));
        System.out.println(String.format("Product warranty time: %d", this.warrantyTime));
        System.out.println(String.format("Product original price: %.2f", this.originalPrice));
        System.out.println(String.format("Product sale price: %.2f", this.salePrice));
    }

    public void calculateSalePrice() {
        if (this.warrantyTime > 0 && this.originalPrice > 0) {
            this.salePrice = this.originalPrice + this.warrantyTime * NUMBER;
        }
    }

    public boolean validateInput() {
        return true;
    }
}
