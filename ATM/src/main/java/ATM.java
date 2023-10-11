import bank.CardNetworkFactory;
import bank.ICardNetwork;

public class ATM {
    private Card card;
    private Integer pin;

    private ICardNetwork cardNetwork;

    public void handleCardSwipe(Card card, Integer pin) {
        validateCredentials(card, pin);
        this.cardNetwork = CardNetworkFactory.getInstance("visa");
        this.card = card;
        this.pin = pin;
    }

    public void removeCard() {
        this.card = null;
        this.pin = null;
        this.cardNetwork = null;
    }

    public void withdrawFunds(Integer amount) {

    }

    public void transferFunds(Integer amount, String IFSC, String accountNumber) {

    }

    public void checkBalance() {

    }

    private void validateCredentials(Card card, Integer pin) {

    }
}
