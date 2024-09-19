package pe.edu.upc.dermacheck.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Anuncio")
public class Anuncio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAnuncio;

    @Column(name = "url", nullable = false, length = 50)
    private String url;

    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

    @Column(name = "creditos", nullable = false)
    private int creditos;

    @Column(name = "IngresosPorAnuncioSoles", nullable = false)
    private double IngresosPorAnuncioSoles;

    @Column(name = "duracionMinutos", nullable = false)
    private int duracionMinutos;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario user;

    public Anuncio() {
    }

    public Anuncio(int idAnuncio, String url, String descripcion, int creditos, double ingresosPorAnuncioSoles, int duracionMinutos, Usuario user) {
        this.idAnuncio = idAnuncio;
        this.url = url;
        this.descripcion = descripcion;
        this.creditos = creditos;
        IngresosPorAnuncioSoles = ingresosPorAnuncioSoles;
        this.duracionMinutos = duracionMinutos;
        this.user = user;
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

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

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
}
