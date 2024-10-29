package com.pruebasaberpro.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pruebasaberpro.app.models.Estudiante;
import com.pruebasaberpro.app.repository.EstudianteRepository;

@Controller
@RequestMapping("estudiante")
public class EstudianteWebController {
	@Autowired
	private EstudianteRepository estudianteRepo;

	//VISTA PRINCIPAL

	@GetMapping("/")
	public String mostrarLogin() {
		return "login-estudiante";
	}
	

	// METODOS DE LOGEARSE

	@PostMapping("/login")
	public String loginFormulario(@ModelAttribute Estudiante estudiante, Model model) {
		Estudiante existsEstudiante = estudianteRepo.findByCedula(estudiante.getCedula());
		if (existsEstudiante != null && existsEstudiante.getContrasena().equals(estudiante.getContrasena())) {
			model.addAttribute("estudiante", existsEstudiante); 
			return "inicio-estudiante"; 
		} else {
			model.addAttribute("mensaje", "Nombre de usuario o contraseña incorrectos");
			return "login-estudiante";
		}
	}
	
	// METODO PARA PROMEDIAR 
	
	@GetMapping("/promedio-asignaturas")
	public String mostrarPromedioAsignaturas(Model model) {
	    List<Estudiante> estudiantes = estudianteRepo.findAll(); 
	    int totalEstudiantes = estudiantes.size();

	    int sumaCE = 0, sumaRC = 0, sumaLC = 0, sumaCC = 0, sumaEN = 0, sumaFPI = 0, sumaPCME = 0, sumaDS = 0;

	    for (Estudiante estudiante : estudiantes) {
	        sumaCE += estudiante.getCE();
	        sumaRC += estudiante.getRC();
	        sumaLC += estudiante.getLC();
	        sumaCC += estudiante.getCC();
	        sumaEN += estudiante.getEN();
	        sumaFPI += estudiante.getFPI();
	        sumaPCME += estudiante.getPCME();
	        sumaDS += estudiante.getDS();
	    }

	    double promedioCE = (double) sumaCE / totalEstudiantes;
	    double promedioRC = (double) sumaRC / totalEstudiantes;
	    double promedioLC = (double) sumaLC / totalEstudiantes;
	    double promedioCC = (double) sumaCC / totalEstudiantes;
	    double promedioEN = (double) sumaEN / totalEstudiantes;
	    double promedioFPI = (double) sumaFPI / totalEstudiantes;
	    double promedioPCME = (double) sumaPCME / totalEstudiantes;
	    double promedioDS = (double) sumaDS / totalEstudiantes;

	    model.addAttribute("promedioCE", promedioCE);
	    model.addAttribute("promedioRC", promedioRC);
	    model.addAttribute("promedioLC", promedioLC);
	    model.addAttribute("promedioCC", promedioCC);
	    model.addAttribute("promedioEN", promedioEN);
	    model.addAttribute("promedioFPI", promedioFPI);
	    model.addAttribute("promedioPCME", promedioPCME);
	    model.addAttribute("promedioDS", promedioDS);

	    return "promedio-asignaturas";
	}
	
	@GetMapping("/ranking")
	public String verRanking(Model model) {
	    List<Estudiante> estudiantes = estudianteRepo.findAll();

	    estudiantes.forEach(estudiante -> {
	        double promedio = (estudiante.getCE() + estudiante.getRC() + estudiante.getLC() + 
	                           estudiante.getCC() + estudiante.getEN() + estudiante.getFPI() + 
	                           estudiante.getPCME() + estudiante.getDS()) / 8.0;
	        estudiante.setPromedio(promedio);
	    });

	    estudiantes.sort((e1, e2) -> Double.compare(e2.getPromedio(), e1.getPromedio()));

	    model.addAttribute("estudiantes", estudiantes);
	    return "ranking";
	}
	
}
