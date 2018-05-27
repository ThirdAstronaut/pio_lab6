import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AdministratorTest {

    private Administrator administrator;

    @BeforeAll
    void setUp() {
        administrator = new Administrator("a", "x", "a", "0", 'a', new Date(), 1, BigDecimal.valueOf(2100));
    }

    /**grouped tests*/
    @Nested
    @DisplayName("adds bonus properly when percent value > 0")
    class ProperBonusAdd {

        /**value source*/
        @ParameterizedTest
        @ValueSource(ints = {5, 10, 50})
        void shouldGiveBonusForProperSalary(int percent) {
            assertEquals(administrator.getSalary().add(BigDecimal.valueOf(percent).multiply(administrator.getSalary()).divide(BigDecimal.valueOf(100))), administrator.giveBonus(percent));

        /*Administrator administrator = mock(Administrator.class);
        when(administrator.getSalary()).thenReturn(baseSalary);


        assertEquals(baseSalary, administrator.getSalary());

        when(administrator.giveBonus(percentValue)).thenReturn(baseSalary.add(BigDecimal.valueOf(percentValue).multiply(baseSalary).divide(BigDecimal.valueOf(100))));
        assertEquals(BigDecimal.valueOf(2310), administrator.giveBonus(percentValue));
*/
        }
    }

    @Nested
    @DisplayName("adds bonus properly when percent value > 0")
    class ExceptionHandling {

        /**repeated test*/
        @RepeatedTest(value = 100, name = "Repetition {currentRepetition} of {totalRepetition}")
        void shouldntIncreaseSalaryForNegativePercentInput() {
            assertThrows(IllegalArgumentException.class, () -> {
                administrator.giveBonus(-12);
            }, "Percent can't be negative!");
        }
    }

    @AfterAll
    void tearDown() {
        administrator = null;
    }

}