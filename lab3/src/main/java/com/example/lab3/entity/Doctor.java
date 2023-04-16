package com.example.lab3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="doctor")

public class Doctor {
    @Id
    private int id;
    private String nombre;
    private String especialidad;

    @ManyToOne
    @JoinColumn(name="hospital_id")
    private Hospital hospital;

}
