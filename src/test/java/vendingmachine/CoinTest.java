package vendingmachine;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

public class CoinTest {

    @Test
    public void nickle() {
        Optional<Coin> coin = Coin.find(2, 2);
        assertTrue(coin.isPresent());
        assertEquals(Coin.NICKLE, coin.get());
        assertEquals(0.05, coin.get().value(), 0.001);
    }

    @Test
    public void dime() {
        Optional<Coin> coin = Coin.find(1, 1);
        assertTrue(coin.isPresent());
        assertEquals(Coin.DIME, coin.get());
        assertEquals(0.10, coin.get().value(), 0.001);
    }

    @Test
    public void quarter() {
        Optional<Coin> coin = Coin.find(3, 3);
        assertTrue(coin.isPresent());
        assertEquals(Coin.QUARTER, coin.get());
        assertEquals(0.25, coin.get().value(), 0.001);
    }

    @Test
    public void invalidCoin() {
        Optional<Coin> coin = Coin.find(0, 0);
        assertFalse(coin.isPresent());
    }
}
