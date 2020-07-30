package br.com.financa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "person")
@Getter
@Setter
@EqualsAndHashCode
public class PersonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "person_sequence")
    private Long personid;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String cpf;

    @NotBlank
    private String rg;

    @OneToOne
    @JoinColumn(name = "genderid")
    private GenderModel gender;

    private String street;

    private String neighborhood;

    private String zipcode;

    private String city;

    private String state;

    private String addressnumber;

    private String personstate;
}
