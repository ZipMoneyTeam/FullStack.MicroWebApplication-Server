package mainApp.controllers;

import mainApp.entities.Account;
import mainApp.entities.AccountCreationResult;
import mainApp.entities.AppUser;
import mainApp.services.AccountService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import mainApp.entities.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = AccountController.class)
@ActiveProfiles("test")
class AccountControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;
    private AccountController accountController;

    private List<Account> accountList;
    @Before
    public void setUp() {
        accountController = Mockito.mock(AccountController.class);
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
        AppUser appUser =  new AppUser();
        appUser.setEmailId("manny@gmail.com");
        AppUser appUser2 =  new AppUser();
        appUser.setEmailId("sitara@gmail.com");
        AppUser appUser3 =  new AppUser();
        appUser.setEmailId("rex@gmail.com");

        this.accountList = new ArrayList<>();
        this.accountList.add(new Account(1L, "Manny", "Checking", 1000.00, appUser));
        this.accountList.add(new Account(1L, "Sitara", "Savings", 1000.00, appUser2));
        this.accountList.add(new Account(1L, "Rex", "Checking", 1000.00, appUser3));
    }



    @Test
    void createAccountTest() {
        Account account = new Account();
        AccountCreationResult expected =  AccountCreationResult.SUCCESS;
        ResponseEntity<AccountCreationResult> newAccount = accountController.create(account);

        BDDMockito
                .given(accountService.create(account)!= null)
                .willReturn(true);

    }
}