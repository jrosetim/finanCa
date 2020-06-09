package br.com.financa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="address")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    private Long idaddress;

    private String street;

    private String number;

    private String neighborhood;

    private String city;

    private String state;

    private Integer zipcode;

    private String ownresidence;

    public Long getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(Long idaddress) {
        this.idaddress = idaddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public String getOwnresidence() {
        return ownresidence;
    }

    public void setOwnresidence(String ownresidence) {
        this.ownresidence = ownresidence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressModel that = (AddressModel) o;
        return idaddress.equals(that.idaddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idaddress);
    }
}
