package com.pruebasaberpro.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pruebasaberpro.app.models.Coordinador;
import com.pruebasaberpro.app.models.Estudiante;
import com.pruebasaberpro.app.repository.CoordinadorRepository;
import com.pruebasaberpro.app.repository.EstudianteRepository;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("coordinador")
public class CoordinadorWebController {
	@Autowired
	private CoordinadorRepository coordinadorRepo;
	@Autowired
	private EstudianteRepository estudianteRepo;

	// VISTA PRINCIPAL

	@GetMapping("/")
	public String mostrarLogin() {
		return "login-coordinador";
	}

	@GetMapping("/inicio")
	public String mostrarInicio(Model model) {
		model.addAttribute("estudiante", estudianteRepo.findAll());
		return "inicio-coordinador";
	}

	// METODOS DE LOGEARSE

	@PostMapping("/login")
	public String loginFormulario(@ModelAttribute Coordinador coordinador, Model model) {
		Coordinador existsCoordinador = coordinadorRepo.findCoordinadorByCedula(coordinador.getCedula());
		if (existsCoordinador != null && existsCoordinador.getContraseña().equals(coordinador.getContraseña())) {
			model.addAttribute("estudiante", estudianteRepo.findAll());
			return "inicio-coordinador";
		} else {
			model.addAttribute("mensaje", "Nombre de usuario o contraseña incorrectos");
			return "login-coordinador";
		}
	}

	// METODOS DEL CREAR EL COORDINADOR

	@GetMapping("/registro")
	public String registroFormulario(Model model) {
		model.addAttribute("coordinador", new Coordinador());
		return "registro-coordinador";
	}

	@PostMapping("/registro")
	public String registrarCoordinador(@ModelAttribute Coordinador coordinador) {
		coordinadorRepo.save(coordinador);
		return "redirect:/coordinador/";
	}

	// METODOS DE CREAR A UN ESTUDIANTE

	@GetMapping("/agregar")
	public String agregarEstudianteFormulario(Model model) {
		model.addAttribute("estudiante", new Estudiante());
		return "registro-estudiante";
	}

	@PostMapping("/guardar")
	public String guardarEstudiante(@ModelAttribute Estudiante estudiante) {
		estudianteRepo.save(estudiante);
		return "redirect:/coordinador/inicio";
	}

	@GetMapping("/editar/{cedula}")
	public String editarEstudianteFormulario(@PathVariable String cedula, Model model) {
		Estudiante estudiante = estudianteRepo.findByCedula(cedula);
		if (estudiante != null) {
			model.addAttribute("estudiante", estudiante);
			return "registro-estudiante";
		} else {
			return "redirect:/coordinador/inicio";
		}
	}

	@GetMapping("/borrar/{cedula}")
    public String borrarEstudianteFormulario(@PathVariable String cedula, Model model) {
         estudianteRepo.deleteByCedula(cedula);
            return "redirect:/coordinador/inicio";
    }
}
