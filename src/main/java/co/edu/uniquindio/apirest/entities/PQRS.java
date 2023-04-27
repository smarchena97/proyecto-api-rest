package co.edu.uniquindio.apirest.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import co.edu.uniquindio.apirest.constants.EstadoEnum;
import co.edu.uniquindio.apirest.constants.TipoEnum;

@Entity 
@Table(name = "pqrs")
public class PQRS {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	private TipoEnum tipo;

	@Column(name = "tema")
	private String tema;

	@Column(name = "descripcion")
	private String descripcion;

	@Enumerated(EnumType.STRING)
	@Column(name = "estatus")
	private EstadoEnum estatus;

	@Column(name = "fecha_creacion")
	private LocalDateTime fechaCreacion;

	@Column(name = "fecha_actualizacion")
	private LocalDateTime fechaActualizacion;

	public PQRS() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public EstadoEnum getEstatus() {
		return estatus;
	}

	public void setEstatus(EstadoEnum estatus) {
		this.estatus = estatus;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}


	public PQRS(Long id, String nombre, TipoEnum tipo, String tema, String descripcion, EstadoEnum estatus,
			LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.tema = tema;
		this.descripcion = descripcion;
		this.estatus = estatus;
		this.fechaCreacion = fechaCreacion;
		this.fechaActualizacion = fechaActualizacion;
	}
	
	
}
