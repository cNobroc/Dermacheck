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

    @Column(name = "idUsuario", nullable = false)
    private int idUsuario;




    public Anuncio() {
    }

    public Anuncio(int idAnuncio, String url, String descripcion, int creditos, int idUsuario) {
        this.idAnuncio = idAnuncio;
        this.url = url;
        this.descripcion = descripcion;
        this.creditos = creditos;
        this.idUsuario = idUsuario;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
