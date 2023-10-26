package com.agenda.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity 
public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "Debe ingresar su nombre")
	private String nombre;
	
	@NotBlank(message = "Debe ingresar su telefono")
	private String movil;
	
	@NotEmpty(message = "Debe ingresar su email")
	@Email
	private String email;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Past
	@NotNull(message = "Debe ingresar su fecha de nacimiento")
	private LocalDate fechaNacimiento;
	
	private LocalDateTime fechaRegistro;
	
	
	public Contacto() {
		super();
	}
	
	@PrePersist
	public void asignarFechaRegistro() {
		fechaRegistro = LocalDateTime.now();
	}
	
	public Contacto(int id, String nombre, String movil, String email, LocalDate fechaNacimiento,
			LocalDateTime fechaRegistro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.movil = movil;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaRegistro = fechaRegistro;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMovil() {
		return movil;
	}
	public void setMovil(String movil) {
		this.movil = movil;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	
}
