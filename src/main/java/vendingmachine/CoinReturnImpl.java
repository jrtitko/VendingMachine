package vendingmachine;

public class CoinReturnImpl implements CoinReturn {

    public static final String COIN_RETURNED = "Invalid Coin";

    private double amountReturned;
    
    /* (non-Javadoc)
     * @see vendingmachine.CoinReturnInterface#returnCoin()
     */
    public String returnCoin() {
        return COIN_RETURNED;
    }

    /* (non-Javadoc)
     * @see vendingmachine.CoinReturnInterface#getAmountReturned()
     */
    public double getAmountReturned() {
        double hold = amountReturned;
        amountReturned = 0.0;
        return hold;
    }
    
    /* (non-Javadoc)
     * @see vendingmachine.CoinReturnInterface#setAmountReturned(double)
     */
    public void setAmountReturned(double amountReturned) {
        this.amountReturned = amountReturned;
    }
}
