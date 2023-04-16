package com.example.lab3.controladores;

import com.example.lab3.entity.Doctor;
import com.example.lab3.entity.Paciente;
import com.example.lab3.repository.DoctorRepository;
import com.example.lab3.repository.PacienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class PacienteController {
    final PacienteRepository pacienteRepository;
    final DoctorRepository doctorRepository;

    public PacienteController(PacienteRepository pacienteRepository, DoctorRepository doctorRepository) {
        this.pacienteRepository = pacienteRepository;
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/listarPaciente")
    public String listarPaciente(Model model){

        model.addAttribute("listaPaciente",pacienteRepository.findAll());
        return "paciente";
    }

    @GetMapping("/crearPaciente")
    public String crearPaciente(){
        return "crearPaciente";

    }

    @PostMapping("/guardarPaciente")
    public String guardarPaciente(Paciente paciente){
        pacienteRepository.save(paciente);

        return "redirect:/listarPaciente";
    }

    @GetMapping("/editarPaciente")
    public String editarPaciente(Model model, @RequestParam("id") int id){
        Optional<Paciente> optionalPaciente=pacienteRepository.findById(id);

        if (optionalPaciente.isPresent()){
            Paciente paciente=optionalPaciente.get();
            model.addAttribute("paciente",paciente);
            return "editarPaciente";
        }else {
            return "redirect:/listarPaciente";
        }


    }

    @GetMapping("/borrarPaciente")
    public String borrarPaciente(Model model,@RequestParam("id") int id){
        Optional<Paciente> optionalPaciente=pacienteRepository.findById(id);
        if (optionalPaciente.isPresent()){
            pacienteRepository.deleteById(id);
        }

        return "redirect:/listarDPaciente";
    }

    @GetMapping("/derivarPaciente")
    public String derivarPaciente(Model model, @RequestParam("id") int id){
        Optional<Paciente> optionalPaciente=pacienteRepository.findById(id);
        List<Doctor> doctorList=doctorRepository.findAll();
        if (optionalPaciente.isPresent()){
            Paciente paciente=optionalPaciente.get();
            model.addAttribute("paciente",paciente);
            model.addAttribute("listaDoctor",doctorList);
            return "derivarPaciente";
        }else {
            return "redirect:/listarPaciente";
        }


    }

}
