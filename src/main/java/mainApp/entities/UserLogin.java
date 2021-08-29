package mainApp.entities;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserLogin {

// UserLogin does not need id number because we can simplify it and just use the unique emailId
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    Long id;
    @Id
    String emailId;
    String password;

    public UserLogin() {
    }

    public UserLogin(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

