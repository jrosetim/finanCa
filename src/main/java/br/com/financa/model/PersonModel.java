package br.com.financa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="person")
public class PersonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence")
    private Long idperson;

    private String name;

    private String email;

    private String cpf;

    private String civilstatus;

    public Long getIdperson() {
        return idperson;
    }

    public void setIdperson(Long idperson) {
        this.idperson = idperson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCivilstatus() {
        return civilstatus;
    }

    public void setCivilstatus(String civilstatus) {
        this.civilstatus = civilstatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonModel that = (PersonModel) o;
        return idperson.equals(that.idperson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idperson);
    }
}
