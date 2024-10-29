package com.pruebasaberpro.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pruebasaberpro.app.models.Coordinador;

public interface CoordinadorRepository extends MongoRepository<Coordinador, String>{
	Coordinador findCoordinadorByCedula(String cedula);
}
