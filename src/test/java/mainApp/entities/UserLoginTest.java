package mainApp.entities;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class UserLoginTest {

    @InjectMocks
    UserLogin login;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void getEmailId() {
        //Given
        String expected = "manny@gmail.com";
        login.setEmailId("manny@gmail.com");
        //When
        String actual = login.getEmailId();
        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void getPassword() {
        //Given
        String expected = "password";
        login.setPassword("password");
        //When
        String actual = login.getPassword();
        //Then
        Assert.assertEquals(expected, actual);
    }
}