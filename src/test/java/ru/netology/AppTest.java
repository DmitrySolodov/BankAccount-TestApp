package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.stream.Stream;

public class AppTest {
    //JUnitTests
    public static Stream<Arguments> methodSource () {
        return Stream.of(
                Arguments.of(-500, 600, false),
                Arguments.of(100, 100, false),
                Arguments.of(-1000, 300, true)
        );
    }
    @ParameterizedTest
    @MethodSource("methodSource")
    public void testAddMoneyToCreditAccount(int count, int amount, boolean expectedResult) {
        //given
        Account account = new CreditAccount(count);

        //when
        boolean result = new CreditAccount(count).addMoney(amount);

        //then:
        Assertions.assertEquals(expectedResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testTransferFromCheckingAccount () {
        //given
        boolean expected = true;
        Account account = new CheckingAccount(300);
        //when
        boolean result = account.transfer(new SavingsAccount(100), 200);

        //then:
        Assertions.assertEquals(result, expected);
        Assertions.assertThrows(NullPointerException.class, () -> new CheckingAccount(1000).transfer(null, 300));
    }

    //HamcrestTests
    @ParameterizedTest
    @MethodSource("methodSource")
    public void HamcrestTestAddMoneyToCreditAccount(int count, int amount, boolean expectedResult) {
        //given
        Account account = new CreditAccount(count);

        //when
        boolean result = new CreditAccount(count).addMoney(amount);

        //then:
        assertThat(expectedResult, is(result));
    }

    @Test
    public void hamcrestTestTransferFromCheckingAccount () {
        //given
        boolean expected = true;
        Account account = new CheckingAccount(300);

        //when
        boolean result = account.transfer(new SavingsAccount(100), 200);

        //then:

        assertThat(account, notNullValue());
        assertThat(expected, is(result));
    }

}
