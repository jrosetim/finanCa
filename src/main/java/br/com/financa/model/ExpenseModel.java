package br.com.financa.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="expense")
@Getter
@Setter
@EqualsAndHashCode
public class ExpenseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "expense_sequence")
    private Long id;

    private Date dateexpense;

    private String description;

    @OneToOne
    @JoinColumn(name = "paymentid", referencedColumnName = "id")
    private PaymentMethodModel paymentmethod;

    @OneToOne
    @JoinColumn(name="typeexpenseid", referencedColumnName = "id")
    private TypeExpenseModel typeexpense;

    @OneToOne
    @JoinColumn(name = "groupexpenseid", referencedColumnName = "id")
    private GroupExpenseModel groupexpense;

    private Float value;

    private Integer instalment; //parcelas

    @OneToOne
    @JoinColumn(name="userid", referencedColumnName = "userid")
    private UsersModel user;

    @OneToOne
    @JoinColumn(name = "situationexpenseid", referencedColumnName = "id")
    private SituationExpenseModel situationexpense;

    private String inout; //Entrada ou saida
}
