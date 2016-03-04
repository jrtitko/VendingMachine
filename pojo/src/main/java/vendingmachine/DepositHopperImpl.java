package vendingmachine;

public class DepositHopperImpl implements DepositHopper {

    private double amtDeposited = 0;

    /* (non-Javadoc)
     * @see vendingmachine.DepositHopperInterface#getAmtDeposited()
     */
    public double getAmtDeposited() {
        return amtDeposited;
    }

    /* (non-Javadoc)
     * @see vendingmachine.DepositHopperInterface#addAmtDeposited(double)
     */
    public void addAmtDeposited(double amtDeposited) {
        this.amtDeposited += amtDeposited;
    }
    
    /* (non-Javadoc)
     * @see vendingmachine.DepositHopperInterface#clear()
     */
    public void clear() {
        amtDeposited = 0;
    }
}
