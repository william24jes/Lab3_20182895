package com.example.lab3.controladores;

import com.example.lab3.repository.DoctorRepository;
import com.example.lab3.repository.HospitalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    @GetMapping("/listarHospital")
    public String listarHospital(Model model){
        model.addAttribute("listaHospital", HospitalRepository);
        return "hospital";
    }
}
