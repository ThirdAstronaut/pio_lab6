import org.junit.jupiter.api.*;
import org.mockito.Mock;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountTest {

    private Account account;

    @Mock
    private AccountSettings accountSettings;


    @BeforeEach
    void setUp() {
        account = new Account(1L, 'u', "xyz", "zyx", accountSettings);
    }

    /**pętla for
     * timeout*/
    @Test
    @Tag("Notes")
    void addNoteToNewCoins() {
        String content = "interesting, I want to buy: ";
        String title = "x";
        int i = 0;
        for (Cryptos c : Cryptos.values()) {
            int finalI = i;
            assertTimeout(Duration.ofMillis(10), () -> account.addNote(c.name(), content + finalI, title));
            assertEquals(content + finalI, account.getNotes().get(c.name()).get(0).getContent());
            i++;
        }

        assertEquals(Cryptos.values().length, account.getNotes().size());

    }

    /**wyjątki*/
    @Test
    @DisplayName("Test assert wrong note's params")
    @Tag("Notes")
    void addWrongTitleAndContentNote() {

        String cryptoName = "BTC";
        String content = "interesting";
        String title = "x";

        assertThrows(IllegalArgumentException.class, () -> {
            account.addNote(cryptoName, "", title);
        }, "Wrong arguments");

        assertThrows(IllegalArgumentException.class, () -> {
            account.addNote(cryptoName, content, "");
        }, "Wrong arguments");


    }

    @Test
    @Tag("Notes")
    void addNoteToExistingCoin() {

        String cryptoName = "BTC";
        String contentNote1 = "interesting";
        String contentNote2 = "buy next week";
        String titleNote1 = "x";
        String titleNote2 = "xyz";

        assertTrue(account.addNote(cryptoName, contentNote1, titleNote1));
        assertTrue(account.addNote(cryptoName, contentNote2, titleNote2));

        assertEquals(titleNote2, account.getNotes().get(cryptoName).get(1).getTitle());
        assertEquals(contentNote2, account.getNotes().get(cryptoName).get(1).getContent());

        assertEquals(1, account.getNotes().size());
        assertEquals(2, account.getNotes().get(cryptoName).size());
    }

    @AfterAll
    void tearDown() {
        account = null;
    }


}




