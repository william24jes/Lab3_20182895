package com.example.lab3.repository;

import com.example.lab3.entity.Doctor;
import com.example.lab3.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
    @Query(value = "Select * FROM paciente WHERE hospital_id = ?1",
          nativeQuery = true) //TENER CUIDADO CON El PUNTO Y COMA AL FINAL DEL QUERY PQ SINO, NO FUNCIONA
    List<Paciente> BuscarPorHospital(Integer id);

    @Query(value = "Select * FROM paciente WHERE doctor_id = ?1",
            nativeQuery = true) //TENER CUIDADO CON El PUNTO Y COMA AL FINAL DEL QUERY PQ SINO, NO FUNCIONA
    List<Paciente> BuscarPorDoctor(Integer id);

    @Query(value = "Select * FROM paciente WHERE doctor_id = ?1 and fecha_cita>str_to_date('11,04,2023','%d,%m,%Y')",
            nativeQuery = true) //TENER CUIDADO CON El PUNTO Y COMA AL FINAL DEL QUERY PQ SINO, NO FUNCIONA
    List<Paciente> proximasCitas(Integer id);
}
