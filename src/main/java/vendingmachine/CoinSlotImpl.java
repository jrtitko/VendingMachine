package vendingmachine;

import java.util.Optional;

public class CoinSlotImpl implements CoinSlot {

    /* (non-Javadoc)
     * @see vendingmachine.CoinSlotInterface#insertCoin(int, int)
     */
    public double insertCoin(int diameter, int weight) {
        Optional<Coin> coin = Coin.find(diameter, weight);
        return (coin.isPresent()) ? coin.get().value() : 0.0;
    }
}
