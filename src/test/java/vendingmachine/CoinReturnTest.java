package vendingmachine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoinReturnTest {

    CoinReturn coinReturn;

    @Before
    public void setUp() {
        coinReturn = new CoinReturnImpl();
    }

    @Test
    public void coinReturnMessage() {
        assertEquals(CoinReturnImpl.COIN_RETURNED, coinReturn.returnCoin());
    }

    @Test
    public void amountReturned() {
        coinReturn.setAmountReturned(0.35);
        assertEquals(0.35, coinReturn.getAmountReturned(), 0.001);  // give amount only once
        assertEquals(0.00, coinReturn.getAmountReturned(), 0.001);  // then clear it.
    }
}
