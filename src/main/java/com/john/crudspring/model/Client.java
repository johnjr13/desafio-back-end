package com.john.crudspring.model;



import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
public class Client {
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("_id")
    private Long id;
    
    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 200, nullable = false)
    private String name;

    @NotBlank
    @NotNull
    @Length(min = 11, max = 11)
    @Column(length = 200, nullable = false)
    private String cpf;

    @NotBlank
    @NotNull
    @Length(min = 1, max = 2)
    @Column(length = 200, nullable = false)
    private String idade;

}
