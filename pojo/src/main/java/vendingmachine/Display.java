package vendingmachine;

public interface Display {

    public abstract void setDisplayMessage(String message);

    public abstract void setDisplayPrice(double price);

    public abstract String getDisplay();

}
