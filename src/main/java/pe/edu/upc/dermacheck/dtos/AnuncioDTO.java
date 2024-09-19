package pe.edu.upc.dermacheck.dtos;

import pe.edu.upc.dermacheck.entities.Usuario;

public class AnuncioDTO {
    private int idAnuncio;
    private String url;
    private String descripcion;
    private int creditos;
    private double IngresosPorAnuncioSoles;
    private int duracionMinutos;
    private Usuario user;

    public double getIngresosPorAnuncioSoles() {
        return IngresosPorAnuncioSoles;
    }

    public void setIngresosPorAnuncioSoles(double ingresosPorAnuncioSoles) {
        IngresosPorAnuncioSoles = ingresosPorAnuncioSoles;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(int idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


}
