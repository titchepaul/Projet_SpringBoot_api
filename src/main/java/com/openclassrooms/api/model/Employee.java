package com.openclassrooms.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import  javax.persistence.Id;
import  javax.persistence.GeneratedValue;
import  javax.persistence.GenerationType;
import  javax.persistence.Entity;
import  javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data//lombok va generer les getteurs et setteurs pour nous
@AllArgsConstructor  //definis un constructeur avec tout les paramètres
@NoArgsConstructor   //contruit un constructeur par defaut
@Entity
@Table(name = "employees")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{first_name}")
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Email(message = "{email.nonValide}")
    @NotBlank
    private String mail;

    @NotNull
    private String password;

}
