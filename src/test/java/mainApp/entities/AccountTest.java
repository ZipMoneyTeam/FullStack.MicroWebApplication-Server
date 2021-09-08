package mainApp.entities;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @InjectMocks
    Account account;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAccountId() {
        //Given
        Long expected =  1L;
        account.setAccountId(1L);

        //When
        Long actual = account.getAccountId();

        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    void getAccountName() {
        //Given
        String expected = "Manny";
        account.setAccountName("Manny");
        //When
        String actual = account.getAccountName();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getAccountType() {
        //Given
        String expected = "Checking";
        account.setAccountType(expected);
        //when
        String actual = account.getAccountType();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getAmount() {
        //Given
        Double expected = 1000.00;
        account.setAmount(1000.00);
        //when
        Double actual = account.getAmount();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getAppUser() {
        //Given
        AppUser appUser = new AppUser();
        AppUser expected = appUser;
        account.setAppUser(appUser);

        //when
        AppUser actual = account.getAppUser();

        //Then
        Assert.assertEquals(expected, actual);
    }
}