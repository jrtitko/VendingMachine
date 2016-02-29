package vendingmachine;

public interface CoinReturn {

    public abstract String returnCoin();

    public abstract double getAmountReturned();

    public abstract void setAmountReturned(double amountReturned);

}
