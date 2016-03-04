package vendingmachine;

import java.util.Optional;

public enum Product {
    COKE (1, 1.00),
    CHIPS (2, 0.50),
    CANDY (3, 0.65);
    
    private int location;
    private double price;
    
    Product (int location, double price) {
        this.location = location;
        this.price = price;
    }

    public double price() {
        return price;
    }
    
    public static Optional<Product> find(int location) {
        for (Product product : Product.values()) {
            if (product.location == location) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }
}
