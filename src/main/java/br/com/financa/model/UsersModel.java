package br.com.financa.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UsersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_sequence")
    @Column(name="userid")
    private Long userId;

    @Column(name = "useremail")
    @NotBlank
    @Email
    private String userEmail;

    @Column(name = "userpassword")
    @NotBlank
    private String userPassword;

    @Column(name = "userfone")
    @NotBlank
    private String userFone;

    @Column(name = "userstatus")
    @NotBlank
    @Size(max = 1)
    private String userStatus;

//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public String getUserEmail() {
//        return userEmail;
//    }
//
//    public void setUserEmail(String userEmail) {
//        this.userEmail = userEmail;
//    }
//
//    public String getUserPassword() {
//        return userPassword;
//    }
//
//    public void setUserPassword(String userPassword) {
//        this.userPassword = userPassword;
//    }
//
//    public String getUserFone() {
//        return userFone;
//    }
//
//    public void setUserFone(String userFone) {
//        this.userFone = userFone;
//    }
//
//    public String getUserStatus() {
//        return userStatus;
//    }
//
//    public void setUserStatus(String userStatus) {
//        this.userStatus = userStatus;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UsersModel that = (UsersModel) o;
//        return Objects.equals(userId, that.userId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(userId);
//    }
}
