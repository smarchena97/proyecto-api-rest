package co.edu.uniquindio.apirest.entities;

import java.time.LocalDate;

public class PQRSDTO { //Aqui era el PQRS

    private Long id;

    private LocalDate fechaCreacion;

    private String asunto;

    private String descripcion;

    private String estado;

    private String tipo;

    public PQRSDTO() {
    }

    public PQRSDTO(LocalDate fechaCreacion, String asunto, String descripcion, String estado, String tipo) {
        this.fechaCreacion = fechaCreacion;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.estado = estado;
        this.tipo = tipo;
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

    @Override
    public String toString() {
        return "PQRS{" +
                "id=" + id +
                ", fechaCreacion=" + fechaCreacion +
                ", asunto='" + asunto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
