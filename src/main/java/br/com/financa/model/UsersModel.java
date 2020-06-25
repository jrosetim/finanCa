package br.com.financa.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class UsersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "user_sequence")
    private Long userid;

    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String useremail;

    @NotBlank
    private String userpassword;

    @Size(max = 1)
    private String userstatus;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime datecreation;
}
