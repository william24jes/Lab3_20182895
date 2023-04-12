package com.example.lab3.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Paciente {
    private int id;
    private String nombre;
    private int edad;
    private String genero;
    private String diagnostico;
    private String cita;
    private String especialidad;
}
