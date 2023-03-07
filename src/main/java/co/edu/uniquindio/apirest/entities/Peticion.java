package co.edu.uniquindio.apirest.entities;

public class Peticion {

    private Long id;

    private String cuerpo;

    public Peticion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
}
