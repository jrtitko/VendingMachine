package vendingmachine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoinSlotTest {

    CoinSlot coinSlot;

    @Before
    public void setUp() {
        coinSlot = new CoinSlotImpl();
    }

    @Test
    public void insertValidCoin() {
        assertEquals(0.05, coinSlot.insertCoin(2, 2), 0.001);
    }

    @Test
    public void insertInvalidCoin() {
        assertEquals(0.00, coinSlot.insertCoin(0, 0), 0.001);
    }
}
