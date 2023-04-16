package com.example.lab3.controladores;

import com.example.lab3.entity.Doctor;
import com.example.lab3.entity.Paciente;
import com.example.lab3.repository.DoctorRepository;
import com.example.lab3.repository.HospitalRepository;
import com.example.lab3.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HospitalController {

    final HospitalRepository hospitalRepository;
    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;


    public HospitalController(HospitalRepository hospitalRepository, DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        this.hospitalRepository = hospitalRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }


    @GetMapping(value= {"/listarHospital", "/"})
    public String listarHospital(Model model){
        model.addAttribute("listaHospital",hospitalRepository.findAll());
        return "hospital";
    }

    @GetMapping("/doctorPorHospital")
    public String getDoctorNamesByHospitalId(@RequestParam("id") int id, Model model) {
        List<Doctor> doctor=doctorRepository.BuscarPorHospital(id);

        model.addAttribute("listaHospitalxDoctor",doctor);
        return "mostrarDoctoresxHospital";

    }

    @GetMapping("/pacientePorHospital")
    public String getPacienteNamesByHospitalId(@RequestParam("id") int id, Model model) {
        List<Paciente> paciente=pacienteRepository.BuscarPorHospital(id);

        model.addAttribute("listaHospitalxPaciente",paciente);
        return "mostrarPacientesxHospital";

    }


}
