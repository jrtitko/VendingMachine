package vendingmachine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {

    int NICKLE[]    = {2, 2};
    int DIME[]      = {1, 1};
    int QUARTER[]   = {3, 3};
    int PENNY[]     = {0, 0};
    
    VendingMachine  vendingMachine;
    DisplayImpl     display;         
    DepositHopper   depositHopper;
    ChangeHopper    changeHopper;
    CoinReturn      coinReturn;
    CoinSlot        coinSlot;

    @Before
    public void setUp() {
        display = new DisplayImpl();
        depositHopper = new DepositHopperImpl();
        changeHopper = new ChangeHopperImpl();
        display.setDepositHopper(depositHopper);
        display.setChangeHopper(changeHopper);
        coinReturn = new CoinReturnImpl();
        coinSlot = new CoinSlotImpl();
        vendingMachine = new VendingMachine(coinSlot, coinReturn, display, depositHopper);
    }

    @Test
    public void initialState() {
        assertMachineState(0.00, DisplayImpl.INSERT_COIN);
    }
    
    @Test
    public void insertValidCoin() {
        insertCoins(NICKLE);
        assertMachineState(0.05, "$0.05");
    }

    @Test
    public void insertMultipleValidCoin() {
        insertCoins(NICKLE, DIME, QUARTER);
        assertMachineState(0.40, "$0.40");
    }

    @Test
    public void insertInvalidCoin() {
        insertCoins(PENNY);
        assertMachineState(0.00, DisplayImpl.INSERT_COIN);
    }
    
    @Test
    public void insertMixValidAndInvalidCoin() {
        insertCoins(DIME, PENNY, NICKLE);
        assertMachineState(0.15, "$0.15");
    }
    
    @Test
    public void selectColaWithInsufficientCoins() {
        vendingMachine.selectProduct(1);
        assertMachineState(0.0, "Price: $1.00");
        assertMachineState(0.0, DisplayImpl.INSERT_COIN);
    }

    @Test
    public void selectChipsWithCorrectCoins() {
        insertCoins(QUARTER, QUARTER);
        vendingMachine.selectProduct(2);
        assertMachineState(0.0, DisplayImpl.THANK_YOU);
        assertEquals(0.0, coinReturn.getAmountReturned(), 0.001);
        assertMachineState(0.0, DisplayImpl.INSERT_COIN);
    }

    @Test
    public void selectCandyWithMakingChange() {
        insertCoins(QUARTER, QUARTER, QUARTER);
        vendingMachine.selectProduct(3);
        assertMachineState(0.0, DisplayImpl.THANK_YOU);
        assertEquals(0.10, coinReturn.getAmountReturned(), 0.001);
        assertMachineState(0.0, DisplayImpl.INSERT_COIN);
    }

    @Test
    public void returnCoins() {
        insertCoins(QUARTER);
        vendingMachine.returnCoins();
        assertEquals(0.25, coinReturn.getAmountReturned(), 0.001);
        assertMachineState(0.0, DisplayImpl.INSERT_COIN);
    }
    
    @Test
    public void soldOut() {
        insertCoins(QUARTER);
        vendingMachine.selectProduct(4);
        assertMachineState(0.25, DisplayImpl.SOLD_OUT);
        assertMachineState(0.25, "$0.25");        
    }
    
    private void assertMachineState(double deposited, String displayMessage) {
        assertEquals(deposited, depositHopper.getAmtDeposited(), 0.001);
        assertEquals(displayMessage, display.getDisplay());        
    }

    private void insertCoins(int[]... coins) {
        for (int[] coin : coins) {
            vendingMachine.insertCoin(coin[0], coin[1]);
        }
    }
}
