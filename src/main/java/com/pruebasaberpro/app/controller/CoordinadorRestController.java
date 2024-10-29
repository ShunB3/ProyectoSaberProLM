package com.pruebasaberpro.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebasaberpro.app.models.Coordinador;
import com.pruebasaberpro.app.repository.CoordinadorRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/coordinador")
public class CoordinadorRestController {
	
	@Autowired
	private CoordinadorRepository coordinadorRepo;
	
	@PostMapping
	public ResponseEntity<?> createCoordinador(@RequestBody Coordinador coordinador) {
			try {
				Coordinador newCoordinador =coordinadorRepo.save(coordinador);
				return new ResponseEntity<Coordinador>(newCoordinador,HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
	@GetMapping
	public ResponseEntity<?> showAllCoordinadores(@RequestBody Coordinador coordinador) {
			try {
				List<Coordinador> listCoordinador =coordinadorRepo.findAll();
				return new ResponseEntity<List<Coordinador>>(listCoordinador,HttpStatus.OK);
			} catch (Exception e) {
				return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
	@PutMapping
	public ResponseEntity<?> updateCoordinador(@RequestBody Coordinador Coordinador) {
	    try {
	        Optional<Coordinador> CoordinadorOptional = coordinadorRepo.findById(Coordinador.getId());
	        if (CoordinadorOptional.isPresent()) {
	            Coordinador exitsCoordinador = coordinadorRepo.save(Coordinador);
	            return ResponseEntity.ok(exitsCoordinador);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se hallo el coordinador");
	        }
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause().toString());
	    }
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteCoordinador(@PathVariable("id") String id){
		try {
			coordinadorRepo.deleteById(id);
			return new ResponseEntity<String>("Coordinador eliminado",HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getCause().toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Coordinador coordinador) {
        Coordinador existeCoordinador = coordinadorRepo.findCoordinadorByCedula(coordinador.getCedula());
        if (existeCoordinador != null && existeCoordinador.getContraseña().equals(coordinador.getContraseña())) {
            return ResponseEntity.ok("Inicio de sesión exitoso");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Cedula de coordinador o contraseña incorrectos");
        }
    }
	
}
