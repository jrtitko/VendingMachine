package vendingmachine;

public class ChangeHopperImpl implements ChangeHopper {

    private boolean exactChange = false;

    /* (non-Javadoc)
     * @see vendingmachine.ChangeHopperInterface#isExactChange()
     */
    public boolean isExactChange() {
        return exactChange;
    }

    /* (non-Javadoc)
     * @see vendingmachine.ChangeHopperInterface#setExactChange(boolean)
     */
    public void setExactChange(boolean exactChange) {
        this.exactChange = exactChange;
    }
    
    
}
