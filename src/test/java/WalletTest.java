import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WalletTest {

    private GiftCard giftcard;
    private DebitCard debitCard;
    private CreditCard creditCard;
    private Wallet wallet;

    @Before
    public void before(){
        giftcard = new GiftCard(50.00);
        debitCard = new DebitCard( 1234567890, "12/28", 123, 12345678, 123456);
        creditCard = new CreditCard(1234567890, "12/28", 123, 1000);
        wallet = new Wallet();
    }

    @Test
    public void walletStartsWithNoCards(){
        assertEquals(0, wallet.getCards().size());
    }
    @Test
    public void walletCanAddCards(){
        wallet.addCardToWallet(giftcard);
        wallet.addCardToWallet(debitCard);
        wallet.addCardToWallet(creditCard);
        assertEquals(3, wallet.getCards().size());

    }
    @Test
    public void walletCanSelectPaymentMethod(){
        wallet.addCardToWallet(giftcard);
        wallet.addCardToWallet(debitCard);
        wallet.addCardToWallet(creditCard);
        IChargeable result = wallet.choosePaymentMethod("GiftCard");
        assertEquals(giftcard, result);
    }
    @Test
    public void walletCanPayWithSelectedCard(){
        wallet.addCardToWallet(giftcard);
        wallet.addCardToWallet(debitCard);
        wallet.addCardToWallet(creditCard);
        wallet.payWithSelectedMethod(50.00, "GiftCard");
        assertEquals(0.00, giftcard.getBalance(), 0.0);
    }
}
