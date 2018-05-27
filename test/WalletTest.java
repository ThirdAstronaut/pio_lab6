import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WalletTest {

    private Account account;
    private Wallet wallet;
    private Cryptocurrency crypto;

    @Mock
    private  AccountSettings accountSettings;


    @BeforeAll
     void setUp() {
        account = new Account(1L, 'u', "xyz", "zyx", accountSettings);
        wallet = new Wallet();
        crypto = new Cryptocurrency(Cryptos.valueOf("LTC"), 150.2);

    }

    @Test
    void addNewCoinToWallet() {
        double amount = 10.0;

        assertTrue(wallet.addCoinToWallet(crypto, amount));
        assertEquals(1, wallet.getCryptos().size());
        assertEquals(amount, wallet.getCryptos().get(crypto), 0.00000001);

    }


    @Test
    void addMoreOfAnExistingCoinToWalletThroughAccount() {

        double amount = 10.0;
        double additionalAmount = 21.120;

        assertTrue(account.getWallet().addCoinToWallet(crypto, amount));
        assertTrue(account.getWallet().addCoinToWallet(crypto, additionalAmount));

        assertEquals(1, account.getWallet().getCryptos().size());
        assertEquals(amount + additionalAmount, account.getWallet().getCryptos().get(crypto), 0.00000001);

    }


    @AfterAll
    void tearDown() {
        account = null;
    }

}