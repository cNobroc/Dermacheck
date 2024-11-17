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
    private double ingresosPorAnuncioSoles;

    @Column(name = "duracionMinutos", nullable = false)
    private int duracionMinutos;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;

    public Anuncio() {
    }

    public Anuncio(int idAnuncio, String url, String descripcion, int creditos, double ingresosPorAnuncioSoles, int duracionMinutos, Usuario usuario) {
        this.idAnuncio = idAnuncio;
        this.url = url;
        this.descripcion = descripcion;
        this.creditos = creditos;
        this.ingresosPorAnuncioSoles = ingresosPorAnuncioSoles;
        this.duracionMinutos = duracionMinutos;
        this.usuario = usuario;
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
        return ingresosPorAnuncioSoles;
    }

    public void setIngresosPorAnuncioSoles(double ingresosPorAnuncioSoles) {
        this.ingresosPorAnuncioSoles = ingresosPorAnuncioSoles;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
