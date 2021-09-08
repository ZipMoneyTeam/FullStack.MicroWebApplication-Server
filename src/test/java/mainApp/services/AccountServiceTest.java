package mainApp.services;

import javafx.beans.binding.When;
import mainApp.Application;
import mainApp.entities.AppUser;
import mainApp.repositories.AppUserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;


import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
class AccountServiceTest {

    @Autowired
    private AppUserService service;

    @MockBean
    private AppUserRepository repository;


    @Test
    void create() {
    }

    @Test
    void read() {
    }

    @Test
    void readByEmailId() {
//        AppUser appUser =  new AppUser();
//        appUser.setEmailId("manny@gmail.com");
//
//        when(repository.findByEmailId(appUser.getEmailId())).thenReturn( Stream
//                .of(    new AppUser("Manny", "Mbanefo","01-01-01", "1231231231", "manny@gmail.com" ))
//                .collect(Collectors.toList()));
//
//        Assert.assertEquals(1, service.readByEmailId);
    }

    @Test
    public void readAllAppUsers() {
        when(repository.findAll()).thenReturn(Stream
                .of(    new AppUser("Manny", "Mbanefo","01-01-01", "1231231231", null ),
                        new AppUser("Sitara", "Kaleemullah","01-01-01", "1234567890", null ),
                        new AppUser("Rex", "Casio","01-01-01", "1112223333", null ))
                .collect(Collectors.toList()));

        Assert.assertEquals(3, service.readAll().size());
    }
}