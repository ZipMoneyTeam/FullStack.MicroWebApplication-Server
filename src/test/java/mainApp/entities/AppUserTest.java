package mainApp.entities;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {
    @InjectMocks
    AppUser user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getFirstName() {
        //Given
        String expected = "Sitara";
        user.setFirstName("Sitara");
        //when
        String actual = user.getFirstName();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getLastName() {
        //Given
        String expected = "Kaleemullah";
        user.setLastName("Kaleemullah");
        //when
        String actual = user.getLastName();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getBirthDate() {
        //Given
        String expected = "01-01-2000";
        user.setBirthDate("01-01-2000");
        //when
        String actual = user.getBirthDate();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getPhoneNumber() {
        //Given
        String expected = "1234567890";
        user.setPhoneNumber("1234567890");

        //when
        String actual = user.getPhoneNumber();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getEmailId() {
        //Given
        String expected =  "manny@gmail.com";
        user.setEmailId("manny@gmail.com");
        //when
        String actual = user.getEmailId();

        //Then
        Assert.assertEquals(expected, actual);
    }
}