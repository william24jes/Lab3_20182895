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
public class DoctorController {

    final DoctorRepository doctorRepository;
    final PacienteRepository pacienteRepository;


    public DoctorController(DoctorRepository doctorRepository, PacienteRepository pacienteRepository) {
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping("/listarDoctor")
    public String listarDoctor(Model model){

        model.addAttribute("listaDoctor",doctorRepository.findAll());
        return "doctor";
    }

    @GetMapping("/crearDoctor")
    public String crearDoctor(){
        System.out.println("aaa");
        return "crearDoctor";

    }

    @PostMapping("/guardarDoctor")
    public String guardarDoctor(Doctor doctor){
        System.out.println(doctor.getId());
        doctorRepository.save(doctor);

        return "redirect:/listarDoctor";
    }

    @GetMapping("/editarDoctor")
    public String editarDoctor(Model model, @RequestParam("id") int id){
        Optional<Doctor> optionalDoctor=doctorRepository.findById(id);

        if (optionalDoctor.isPresent()){
            Doctor doctor=optionalDoctor.get();
            model.addAttribute("doctor",doctor);
            return "editarDoctor";
        }else {
            return "redirect:/listarDoctor";
        }


    }

    @GetMapping("/borrarDoctor")
    public String borrarDoctor(Model model,@RequestParam("id") int id){
        Optional<Doctor> optionalDoctor=doctorRepository.findById(id);
        if (optionalDoctor.isPresent()){
            doctorRepository.deleteById(id);
        }

        return "redirect:/listarDoctor";
    }

    @GetMapping("/pacientePorDoctor")
    public String getPacienteNamesByDoctorId(@RequestParam("id") int id, Model model) {
        List<Paciente> paciente=pacienteRepository.BuscarPorDoctor(id);

        model.addAttribute("listaDoctorxPaciente",paciente);
        return "mostrarPacientesxDoctor";

    }

    @GetMapping("/proximasCitas")
    public String proximasCitas(@RequestParam("id") int id, Model model) {
        List<Paciente> paciente=pacienteRepository.proximasCitas(id);

        model.addAttribute("listaDoctorxPacienteProximasCitas",paciente);
        return "ProximasCitas";

    }

}
