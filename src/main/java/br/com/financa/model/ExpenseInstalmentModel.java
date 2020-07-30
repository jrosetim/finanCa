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
import java.time.OffsetDateTime;
import java.util.Date;

@Entity
@Table(name = "expenseinstalment")
@Getter
@Setter
@EqualsAndHashCode
public class ExpenseInstalmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "expenseinstalment_sequence")
    private Long id;

    private Integer instalment;

    private Float value;

    private Date duedate;

    @OneToOne
    @JoinColumn(name="expenseid", referencedColumnName = "id")
    private ExpenseModel expense;
}
