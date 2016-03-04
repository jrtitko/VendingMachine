package vendingmachine;

import java.util.Optional;

public enum Coin {
    NICKLE(2, 2, 0.05), // second largest coin (in diameter) with second size weight
    DIME(1, 1, 0.10), QUARTER(3, 3, 0.25);

    private final int    diameter;	// in relative size of the coin compared to the others
    private final int    weight;  // in relative weight of the coin compared to the others
    private final double value;   // the value of the coin.

    Coin(int diameter, int weight, double value) {
        this.diameter = diameter;
        this.weight = weight;
        this.value = value;
    }

    public double value() {
        return value;
    }

    public static Optional<Coin> find(int diameter, int weight) {
        for (Coin coin : values()) {
            if (coin.diameter == diameter && coin.weight == weight) {
                return Optional.of(coin);
            }
        }
        return Optional.empty();
    }
}
