package mainApp.entities;

import javafx.beans.binding.BooleanExpression;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @InjectMocks
    Transaction transaction;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTransactionId() {
        //Given
        Long expected = 2L;
        transaction.setTransactionId(2L);
        //When
        Long actual = transaction.getTransactionId();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getType() {
        //Given
        String expected = "Deposit";
        transaction.setType("Deposit");
        //When
        String actual = transaction.getType();
        //Then
        Assert.assertEquals(expected, actual);


    }

    @Test
    public void getStatus() {
        //Given
        Boolean expected = true;
        transaction.setStatus(true);
        //When
        Boolean actual = transaction.getStatus();

        //Then
        Assert.assertEquals(true, actual);

    }

    @Test
    public void getInfo() {
        //Given
        String expected =  "info";
        transaction.setInfo("info");
        //When
        String actual = transaction.getInfo();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getDate() {
        //Given
        Instant instant = Instant.now();
        transaction.setDate(instant);

        //When
        Instant actual = transaction.getDate();

        assertNotNull(actual);
    }

    @Test
    public void getAccountId() {
        //Given
        Long expected = 1L;
        Account account =  new Account();
        account.setAccountId(1L);

        //When
        Long actual = account.getAccountId();

        //Then
        Assert.assertEquals(expected, actual);

    }
}

