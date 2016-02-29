package vendingmachine;

import java.util.Optional;

public class VendingMachine {

    private CoinSlot   coinSlot;
    private CoinReturn coinReturn;
    private Display    display;
    private DepositHopper   depositHopper;
    
    public VendingMachine(CoinSlot coinSlot, CoinReturn coinReturn, Display display, DepositHopper depositHopper) {
        this.coinSlot = coinSlot;
        this.coinReturn = coinReturn;
        this.display = display;
        this.depositHopper = depositHopper;
    }

    public void insertCoin(int diameter, int weight) {
        double value = coinSlot.insertCoin(diameter, weight);
        if (value == 0.00) {
            coinReturn.returnCoin();
        } else {
            depositHopper.addAmtDeposited(value);
        }
    }

    public void selectProduct(int location) {
        Optional<Product> product = Product.find(location);
        if (product.isPresent()) {
            processSelection(product);
        } else {
            display.setDisplayMessage(DisplayImpl.SOLD_OUT);
        }
    }

    private void processSelection(Optional<Product> product) {
        if (product.get().price() > depositHopper.getAmtDeposited()) {
            display.setDisplayPrice(product.get().price());
        } else {
            dispenseProduct(product);
        }
    }

    private void dispenseProduct(Optional<Product> product) {
        display.setDisplayMessage(DisplayImpl.THANK_YOU);
        depositHopper.addAmtDeposited(-1 * product.get().price());
        if (depositHopper.getAmtDeposited() > 0.0) {
            returnCoins();
        }
    }
    
    public void returnCoins() {
        coinReturn.setAmountReturned(depositHopper.getAmtDeposited());
        depositHopper.clear();
    }
}
