package my.vlong.java.javahero;

import java.util.Scanner;

public class DigitalProduct extends Product {

    private static final int NUMBER = 1000;

    private int volume;

    public void inputProduct(Scanner scanner) throws ProductException {
        if (scanner == null) {
            return;
        }

        System.out.println("=== Enter product information ===");
        System.out.println("Enter product name : ");
        this.name = scanner.nextLine();

        System.out.println("Enter product volume : ");
        this.volume = scanner.nextInt();

        if (!this.validateInput()) {
            throw new ProductException("Product info input is not valid");
        }
    }

    public void displayProduct() {
        System.out.println("=== Product info ===");
        System.out.println(String.format("Product id: %d", this.id));
        System.out.println(String.format("Product name: %s", this.name));
        System.out.println(String.format("Product volume: %d", this.volume));
        System.out.println(String.format("Product sale price: %.2f", this.salePrice));
    }

    public void calculateSalePrice() {
        this.salePrice = 0;
        if (volume > 0) {
            this.salePrice = this.volume * NUMBER;
        }
    }

    public boolean validateInput() {
        if (this.name == null || "".equals(this.name)) {
            return false;
        }

        if (this.volume <= 0) {
            return false;
        }

        return true;
    }
}
