package my.vlong.java.javahero;

import java.util.Scanner;

public class AgricultureProduct extends Product {

    private static final int NUMBER = 500;

    private int expiryTime;
    private float currentPrice;

    public void inputProduct(Scanner scanner) throws ProductException {
        if (scanner == null) {
            return;
        }

        System.out.println("=== Enter product information ===");
        System.out.println("Enter product name : ");
        this.name = scanner.nextLine();

        System.out.println("Enter product expiry time : ");
        this.expiryTime = scanner.nextInt();

        System.out.println("Enter product current price : ");
        this.currentPrice = scanner.nextFloat();

        if (!this.validateInput()) {
            throw new ProductException("Product info input is not valid");
        }
    }

    public void displayProduct() {
        System.out.println("=== Product info ===");
        System.out.println(String.format("Product id: %d", this.id));
        System.out.println(String.format("Product name: %s", this.name));
        System.out.println(String.format("Product expiry date: %d", this.expiryTime));
        System.out.println(String.format("Product current price: %.2f", this.currentPrice));
        System.out.println(String.format("Product sale price: %.2f", this.salePrice));
    }

    public void calculateSalePrice() {
        if (this.expiryTime > 0 && this.currentPrice > 0) {
            this.salePrice = this.currentPrice + this.expiryTime * NUMBER;
        }
    }

    public boolean validateInput() {
        return true;
    }
}
