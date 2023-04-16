package com.example.lab3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="hospital")

public class Hospital {
    @Id
    private Integer id;
    private String nombre;
    private String direccion;
    private String telefono;
}
