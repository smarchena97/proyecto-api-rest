package co.edu.uniquindio.apirest.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity //aqui era el PQRSDTO 
@Table(name = "pqrs")
public class PQRS {

	/*
	 * citando a San GPT: En resumen, un DTO se utiliza para transferir datos entre
	 * capas de la aplicación, mientras que una entidad se utiliza para representar
	 * una tabla en una base de datos relacional.
	 * 
	 * Tiene invertido el DTO y la entity.
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha")
	private LocalDate fechaCreacion;

	@Column(name = "asunto")
	private String asunto;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "estado")
	private String estado;

	@Column(name = "tipo")
	private String tipo;

	public PQRS(Long id, LocalDate fechaCreacion, String asunto, String descripcion, String estado, String tipo) {
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tipo = tipo;
	}

	public PQRS() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
