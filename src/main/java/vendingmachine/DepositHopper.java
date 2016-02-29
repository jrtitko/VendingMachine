package vendingmachine;

public interface DepositHopper {

    public abstract double getAmtDeposited();

    public abstract void addAmtDeposited(double amtDeposited);

    public abstract void clear();

}
