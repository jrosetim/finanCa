package br.com.financa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    private String street;

    private String number;

    private String neighborhood;

    private String city;

    private String state;

    private Integer zipcode;

    private String ownresidence;
}
