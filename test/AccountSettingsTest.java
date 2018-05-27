import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountSettingsTest {

    private AccountSettings accountSettings;

    @Mock
    private Languages languages;

    @BeforeAll
    void setUp() {
        accountSettings = new AccountSettings(languages, new Font(Fonts.Arial, 1));
    }

    /**asssert true
     * method source*/
    @ParameterizedTest
    @MethodSource("fontSizes")
    void changeFontSize(int a) {
        assertTrue(accountSettings.changeFontSize(a));
    }

    private static Stream fontSizes() {
        return Stream.of(15, 30, 149);
    }

    /**asssert false
     * method source*/
    @ParameterizedTest
    @MethodSource("invalidFontSizes")
    void changeFontSizeToInvalid(int a) {
        assertFalse(accountSettings.changeFontSize(a));
    }

    private static Stream invalidFontSizes() {
        return Stream.of(0, 151);
    }


    @Test
    void defaultFontsSizes() {
        assertArrayEquals(new int[]{14, 25}, accountSettings.getDefaultFontsSizes());
    }

    @AfterAll
    void tearDown() {
        accountSettings = null;
    }

}