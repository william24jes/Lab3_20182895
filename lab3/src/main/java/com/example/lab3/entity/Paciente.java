package com.example.lab3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="paciente")

public class Paciente {
    @Id
    private int id;

    private String nombre;
    private int edad;
    private String genero;
    private String diagnostico;
    private String fecha_cita;
    private int numero_habitacion;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
