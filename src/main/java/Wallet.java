import java.util.ArrayList;

public class Wallet {

    private ArrayList<IChargeable> cards;

    public Wallet(){
        this.cards = new ArrayList<>();
    }

    public ArrayList<IChargeable> getCards() {
        return cards;
    }

    public void setCards(ArrayList<IChargeable> cards) {
        this.cards = cards;
    }

    public IChargeable choosePaymentMethod(String paymentMethod){
        IChargeable cardToSelect = null;
        for (IChargeable card:cards){
            if (card.getClass().getSimpleName() == paymentMethod){
                cardToSelect = card;
            }
        }
        return cardToSelect;
    }

    public void payWithSelectedMethod(double purchaseAmount, String paymentMethod){
        IChargeable cardToUse = choosePaymentMethod(paymentMethod);
        cardToUse.charge(purchaseAmount);
    }

    public void addCardToWallet(IChargeable cardToAdd){
        cards.add(cardToAdd);
    }
}
