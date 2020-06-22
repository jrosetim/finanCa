package br.com.financa.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "gender")
@Getter
@Setter
@EqualsAndHashCode
public class GenderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long genderid;

    @NotBlank
    private String description;
}
