package com.pruebasaberpro.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebasaberpro.app.models.Estudiante;
import com.pruebasaberpro.app.repository.EstudianteRepository;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteRestController {

	@Autowired
	private  EstudianteRepository estudianteRepo;
	
	@PostMapping
	public ResponseEntity<?> createEstudiante (@RequestBody Estudiante estudiante){
		try {
			Estudiante newEstudiante = estudianteRepo.save(estudiante);
			return new ResponseEntity<Estudiante>(newEstudiante, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<?> showAllEstudiantes (@RequestBody Estudiante estudiante){
		try {
			List<Estudiante> listEstudiante = estudianteRepo.findAll();
			return new ResponseEntity<List<Estudiante>>(listEstudiante, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping
	public ResponseEntity<?> updateEstudiante (@RequestBody Estudiante estudiante){
		try {
			Estudiante newEstudiante = estudianteRepo.save(estudiante);
			return new ResponseEntity<Estudiante>(newEstudiante, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteEstudiante (@PathVariable("id") String id){
		try {
			estudianteRepo.deleteById(id);
			return new ResponseEntity<String>("Estudiante eliminado",HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Estudiante estudiante) {
		Estudiante existeEstudiante = estudianteRepo.findByCedula(estudiante.getCedula());
		if(existeEstudiante != null && existeEstudiante.getContrasena().equals(estudiante.getContrasena())) {
			return ResponseEntity.ok("inicio de sesion exitoso");
		}
		return ResponseEntity.ok("Cedula de estudiante o contraseña incorrectos");
		
	}
	
	
}
