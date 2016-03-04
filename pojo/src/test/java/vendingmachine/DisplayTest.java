package vendingmachine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DisplayTest {

    private DisplayImpl     display;
    private DepositHopper   depositHopper;
    private ChangeHopper    changeHopper;
    
    @Before
    public void setUp() {
        display = new DisplayImpl();
        depositHopper = new DepositHopperImpl();
        changeHopper = new ChangeHopperImpl();
        display.setDepositHopper(depositHopper);
        display.setChangeHopper(changeHopper);
    }

    @Test
    public void insertCoinMessage() {
        depositHopper.addAmtDeposited(0.0);
        assertEquals(DisplayImpl.INSERT_COIN, display.getDisplay());
    }

    @Test
    public void exactChangeMessage() {
        changeHopper.setExactChange(true);
        assertEquals(DisplayImpl.EXACT_CHANGE, display.getDisplay());
    }

    @Test
    public void coinValueMessage_nickle() {
        depositHopper.addAmtDeposited(0.05);
        assertEquals("$0.05", display.getDisplay());
    }

    @Test
    public void coinValueMessage_dime() {
        depositHopper.addAmtDeposited(0.10);
        assertEquals("$0.10", display.getDisplay());
    }

    @Test
    public void coinValueMessage_dollar() {
        depositHopper.addAmtDeposited(1);
        assertEquals("$1.00", display.getDisplay());
    }

    @Test
    public void coinValueMessage_tendollar() {
        depositHopper.addAmtDeposited(10);
        assertEquals("$10.00", display.getDisplay());
    }

    @Test
    public void displayPriceOnceThenInsertCoin() {
        display.setDisplayPrice(0.65);
        assertEquals("Price: $0.65", display.getDisplay());
        assertEquals(DisplayImpl.INSERT_COIN, display.getDisplay());
    }
}
