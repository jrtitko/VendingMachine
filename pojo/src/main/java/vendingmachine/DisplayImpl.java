package vendingmachine;

public class DisplayImpl implements Display {

    public static final String INSERT_COIN = "INSERT COIN";
    public static final String EXACT_CHANGE = "EXACT CHANGE";
    public static final String THANK_YOU = "THANK YOU";
    public static final String SOLD_OUT = "SOLD OUT";

    private String         message = "";
    private DepositHopper  depositHopper;
    private ChangeHopper   changeHopper;

    /* (non-Javadoc)
     * @see vendingmachine.DisplayInterface#setDisplayMessage(java.lang.String)
     */
    public void setDisplayMessage(String message) {
        this.message = (message == null)?"":message;
    }

    /* (non-Javadoc)
     * @see vendingmachine.DisplayInterface#setDisplayPrice(double)
     */
    public void setDisplayPrice(double price) {
        this.message = (price == 0)?"":String.format("Price: $%1$4.2f", price);
    }

    /* (non-Javadoc)
     * @see vendingmachine.DisplayInterface#getDisplay()
     */
    public String getDisplay() {
        if (!message.isEmpty()) {
            String hold = message;
            message = "";
            return hold;
        } else if (depositHopper.getAmtDeposited() > 0.0) {
            return String.format("$%1$4.2f", depositHopper.getAmtDeposited());
        } else if (changeHopper.isExactChange()) {
            return EXACT_CHANGE;
        } else {
            return INSERT_COIN;
        }
    }

    public void setDepositHopper(DepositHopper depositHopper) {
        this.depositHopper = depositHopper;
    }

    public void setChangeHopper(ChangeHopper changeHopper) {
        this.changeHopper = changeHopper;        
    }

}
