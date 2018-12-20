package my.vlong.java.javahero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {

    private static final int ENTRY_PRODUCT = 1;
    private static final int DISPLAY_PRODUCT = 2;
    private static final int FINd_MAX_PRODUCT_PRICE = 3;
    private static final int EXIT = 4;

    private static final int DIGITAL_PRODUCT = 1;
    private static final int INDUSTRY_PRODUCT = 2;
    private static final int AGRICULTURE_PRODUCT = 3;
    private static final int RETURN_MAIN_MENU = 4;

    private List<Product> products;

    private Scanner scanner;

    public ProductManagement() {
        this.products = new ArrayList<Product>();
        this.scanner = new Scanner(System.in);
    }

    private void displayMenu() {
        System.out.println("=== Product Management System ===");
        System.out.println("1. Entry product info");
        System.out.println("2. Display product info");
        System.out.println("3. Find max sale price of product");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
    }

    private void executeMenu() {
        int choice = 0;

        do {
            this.displayMenu();

            choice = this.scanner.nextInt();
            if (choice < ENTRY_PRODUCT || choice > EXIT) {
                System.out.println("Please enter choice 1 - 4.");
                continue;
            }

            switch (choice) {
                case ENTRY_PRODUCT:
                    this.entryProduct();
                    break;
                case DISPLAY_PRODUCT:
                    this.displayProductListInfo();
                    break;
                case FINd_MAX_PRODUCT_PRICE:
                    break;
            }

        } while (choice != EXIT);
    }

    private void entryProduct() {
        int choice = 0;
        do {
            Product product = null;
            displayEntryProductMenu();

            choice = this.scanner.nextInt();
            scanner.nextLine();
            if (choice < DIGITAL_PRODUCT || choice > RETURN_MAIN_MENU) {
                System.out.println("Please enter choice 1 - 4.");
                continue;
            }

            switch (choice) {
                case DIGITAL_PRODUCT:
                    product = new DigitalProduct();
                    break;
                case INDUSTRY_PRODUCT:
                    product = new IndustryProduct();
                    break;
                case AGRICULTURE_PRODUCT:
                    product = new AgricultureProduct();
                    break;
            }

            if (product != null) {
                try {
                    product.inputProduct(this.scanner);
                    product.calculateSalePrice();
                    this.products.add(product);
                    System.out.println("Add product success.");
                } catch (ProductException e) {
                    System.out.println(e.getMessage());
                }
            }

        } while (choice != RETURN_MAIN_MENU);

        // return main menu
        this.executeMenu();
    }

    private void displayEntryProductMenu() {
        System.out.println("=== Product type ===");
        System.out.println("1. Digital Product");
        System.out.println("2. Industry Product");
        System.out.println("3. Agriculture Product");
        System.out.println("4. Return main menu");
        System.out.println("Enter your choice: ");
    }

    private void displayProductListInfo() {
        if (this.products == null || this.products.size() == 0) {
            return;
        }

        for (Product product : products) {
            if (product == null) {
                continue;
            }
            product.displayProduct();
        }
    }

    public void run() {
        this.executeMenu();
    }
}
