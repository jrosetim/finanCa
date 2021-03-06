package br.com.financa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paymentmethod")
@Getter
@Setter
@EqualsAndHashCode
public class PaymentMethodModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "paymentmethod_sequence")
    private Long id;

    private String description;

    private String state;
}
