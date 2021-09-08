package mainApp.services;

import mainApp.Application;
import mainApp.dto.RegistrationDto;
import mainApp.entities.AppUser;
import mainApp.entities.UserLogin;
import mainApp.repositories.AppUserRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
class AppUserServiceTest {

    @Autowired
    private AppUserService appService;

    @MockBean
    private AppUserRepository repository;


    @Test
    void create() {
        //Given
        AppUser user = new AppUser("Manny", "Mbanefo","01-01-01", "1231231231", "manny@gmail.com" );
        AppUser expected = user;
        //When
        //RegistrationDto userDto =  new RegistrationDto("Manny", "Mbanefo","01-01-01", "1231231231", "manny@gmail.com", "mannypass" );
        when(repository.save(user)).thenReturn(user);

        AppUser actual = appService.create(user);
        //Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    void read() {
//        UserLogin user = new UserLogin("manny@gmail.com", "mannypass");
//        when(repository.(user))
//
//        AppUser actual = service.read(user);
//
//
//        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRead() {


    }

    @Test
    public void readAllAppUsers() {
        //Given
        int expected = 3;

        //When
        when(repository.findAll()).thenReturn(Stream
                .of(    new AppUser("Manny", "Mbanefo","01-01-01", "1231231231", null ),
                        new AppUser("Sitara", "Kaleemullah","01-01-01", "1234567890", null ),
                        new AppUser("Rex", "Casio","01-01-01", "1112223333", null ))
                .collect(Collectors.toList()));
        int actual = appService.readAll().size();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    void update() {

    }

    @Test
    public void deleteTest() {
        //Given
        int expected = 2;
        //When
        when(repository.findAll()).thenReturn(Stream
                .of(    new AppUser("Manny", "Mbanefo","01-01-01", "1231231231", "manny@gmail.com" ),
                        new AppUser("Sitara", "Kaleemullah","01-01-01", "1234567890", "sitara@gmail.com" ),
                        new AppUser("Rex", "Casio","01-01-01", "1112223333", "rex@gmail.com" ))
                .collect(Collectors.toList()));
        repository.deleteByEmailId("manny@gmail.com");
        int actual = appService.readAll().size();
        //Then
        //verify(repository, times(1)).delete("sitara@gmail.com");
        Assert.assertEquals(expected, actual);

        //Given
//        AppUser user1 = new AppUser("Manny", "Mbanefo","01-01-01", "1231231231", "manny@gmail.com" );
//        AppUser expected1 = user1;
//        when(repository.save(expected1)).thenReturn(expected1);
//
//        appService.create(expected1);
//        //When
//        appService.delete(expected1);
//
//        //Then
//        verify(repository, times(1)).delete(expected1);


    }

    @Test
    void deleteByEmailIdTest() {
        //Given
        AppUser user =  new AppUser("Sitara", "Kaleemullah","01-01-01", "1234567890", "sitara@gmail.com" );
        //When
        when(repository.save(user)).thenReturn(user);
        appService.delete("sitara@gmail.com");
        //appService.delete(user);
        //Then
        verify(repository, times(1)).delete(user);
        //verify(repository, times(1)).delete(user);
    }
}