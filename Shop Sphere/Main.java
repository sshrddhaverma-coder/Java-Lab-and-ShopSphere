import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class Main {

    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Product> cart = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        products.add(new Product(1, "Laptop", 55000));
        products.add(new Product(2, "Smartphone", 25000));
        products.add(new Product(3, "Headphones", 1500));
        products.add(new Product(4, "Keyboard", 800));
        products.add(new Product(5, "Mouse", 500));

        int choice;

        System.out.println("=================================");
        System.out.println("       WELCOME TO SHOPSPHERE");
        System.out.println("=================================");

        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. Place Order");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewProducts();
                    break;

                case 2:
                    addToCart();
                    break;

                case 3:
                    viewCart();
                    break;

                case 4:
                    removeFromCart();
                    break;

                case 5:
                    placeOrder();
                    break;

                case 6:
                    System.out.println("Thank you for using ShopSphere!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }

    static void viewProducts() {
        System.out.println("\n----- AVAILABLE PRODUCTS -----");

        for (Product p : products) {
            System.out.println(
                p.id + ". " + p.name + " - Rs. " + p.price
            );
        }
    }

    static void addToCart() {
        viewProducts();

        System.out.print("\nEnter Product ID: ");
        int id = sc.nextInt();

        for (Product p : products) {
            if (p.id == id) {
                cart.add(p);
                System.out.println(p.name + " added to cart.");
                return;
            }
        }

        System.out.println("Product not found!");
    }

    static void viewCart() {

        if (cart.isEmpty()) {
            System.out.println("\nYour cart is empty.");
            return;
        }

        System.out.println("\n----- YOUR CART -----");

        double total = 0;

        for (Product p : cart) {
            System.out.println(p.name + " - Rs. " + p.price);
            total += p.price;
        }

        System.out.println("---------------------");
        System.out.println("Total: Rs. " + total);
    }

    static void removeFromCart() {

        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        viewCart();

        System.out.print("\nEnter Product ID to remove: ");
        int id = sc.nextInt();

        for (Product p : cart) {
            if (p.id == id) {
                cart.remove(p);
                System.out.println(p.name + " removed from cart.");
                return;
            }
        }

        System.out.println("Product not found in cart.");
    }

    static void placeOrder() {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty. Add products first.");
            return;
        }

        double total = 0;

        for (Product p : cart) {
            total += p.price;
        }

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total Amount: Rs. " + total);
        System.out.println("Order placed successfully!");
        System.out.println("Thank you for shopping with ShopSphere.");

        cart.clear();
    }
}