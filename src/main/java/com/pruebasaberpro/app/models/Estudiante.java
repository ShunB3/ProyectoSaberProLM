package com.pruebasaberpro.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "estudiante")
public class Estudiante {

	@Id
	String id;
	String cedula;
	String contrasena;
	String apellidos;
	String primer_nombre;
	String segundo_nombre;
	String email;
	int telefono;
	String registro;
	String institución;
	private double promedio;
	
	String puntaje, nivel_puntaje;
	int CE , RC, LC, CC,  EN, FPI, PCME, DS;
	String lvlCE ,lvlRC, lvlLC, lvlCC,  lvlEN, lvlFPI, lvlPCME, lvlDS, categoryEN;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getPrimer_nombre() {
		return primer_nombre;
	}
	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}
	public String getSegundo_nombre() {
		return segundo_nombre;
	}
	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getInstitución() {
		return institución;
	}
	public void setInstitución(String institución) {
		this.institución = institución;
	}
	public String getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(String puntaje) {
		this.puntaje = puntaje;
	}
	public String getNivel_puntaje() {
		return nivel_puntaje;
	}
	public void setNivel_puntaje(String nivel_puntaje) {
		this.nivel_puntaje = nivel_puntaje;
	}
	public int getCE() {
		return CE;
	}
	public void setCE(int cE) {
		CE = cE;
	}
	public int getRC() {
		return RC;
	}
	public void setRC(int rC) {
		RC = rC;
	}
	public int getLC() {
		return LC;
	}
	public void setLC(int lC) {
		LC = lC;
	}
	public int getCC() {
		return CC;
	}
	public void setCC(int cC) {
		CC = cC;
	}
	public int getEN() {
		return EN;
	}
	public void setEN(int eN) {
		EN = eN;
	}
	public int getFPI() {
		return FPI;
	}
	public void setFPI(int fPI) {
		FPI = fPI;
	}
	public int getPCME() {
		return PCME;
	}
	public void setPCME(int pCME) {
		PCME = pCME;
	}
	public int getDS() {
		return DS;
	}
	public void setDS(int dS) {
		DS = dS;
	}
	public String getLvlCE() {
		return lvlCE;
	}
	public void setLvlCE(String lvlCE) {
		this.lvlCE = lvlCE;
	}
	public String getLvlRC() {
		return lvlRC;
	}
	public void setLvlRC(String lvlRC) {
		this.lvlRC = lvlRC;
	}
	public String getLvlLC() {
		return lvlLC;
	}
	public void setLvlLC(String lvlLC) {
		this.lvlLC = lvlLC;
	}
	public String getLvlCC() {
		return lvlCC;
	}
	public void setLvlCC(String lvlCC) {
		this.lvlCC = lvlCC;
	}
	public String getLvlEN() {
		return lvlEN;
	}
	public void setLvlEN(String lvlEN) {
		this.lvlEN = lvlEN;
	}
	public String getLvlFPI() {
		return lvlFPI;
	}
	public void setLvlFPI(String lvlFPI) {
		this.lvlFPI = lvlFPI;
	}
	public String getLvlPCME() {
		return lvlPCME;
	}
	public void setLvlPCME(String lvlPCME) {
		this.lvlPCME = lvlPCME;
	}
	public String getLvlDS() {
		return lvlDS;
	}
	public void setLvlDS(String lvlDS) {
		this.lvlDS = lvlDS;
	}
	public String getCategoryEN() {
		return categoryEN;
	}
	public void setCategoryEN(String categoryEN) {
		this.categoryEN = categoryEN;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
	
		
}
