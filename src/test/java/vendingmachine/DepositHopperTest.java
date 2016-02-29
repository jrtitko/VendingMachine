package vendingmachine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DepositHopperTest {

    DepositHopper hopper;
    
    @Before
    public void setUp() {
        hopper = new DepositHopperImpl();
    }
    
    @Test
    public void addFunds() {
        hopper.addAmtDeposited(0.10);
        assertEquals(0.10, hopper.getAmtDeposited(), 0.001);
    }

    @Test
    public void clear() {
        hopper.addAmtDeposited(0.10);
        assertEquals(0.10, hopper.getAmtDeposited(), 0.001);
        hopper.clear();
        assertEquals(0.00, hopper.getAmtDeposited(), 0.001);
    }
}
