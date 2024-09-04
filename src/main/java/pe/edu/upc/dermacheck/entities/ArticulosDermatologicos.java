package pe.edu.upc.dermacheck.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "ArticulosDermatologicos")
public class ArticulosDermatologicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArticulosDermatologico;
    @Column(name = "nombreRevista", nullable = false, length = 60)
    private String nombreRevista;

    @Column(name = "tipoRevista", nullable = false, length = 60)
    private String tipoRevista;

    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;

    @Column(name = "url", nullable = false, length = 50)
    private String url;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    public int getIdArticulosDermatologico() {
        return idArticulosDermatologico;
    }

    public void setIdArticulosDermatologico(int idArticulosDermatologico) {
        this.idArticulosDermatologico = idArticulosDermatologico;
    }

    public ArticulosDermatologicos() {
    }

    public ArticulosDermatologicos(String nombreRevista, String tipoRevista, String descripcion, String url, Usuario usuario) {
        this.nombreRevista = nombreRevista;
        this.tipoRevista = tipoRevista;
        this.descripcion = descripcion;
        this.url = url;
        this.usuario = usuario;
    }

    public String getNombreRevista() {
        return nombreRevista;
    }

    public void setNombreRevista(String nombreRevista) {
        this.nombreRevista = nombreRevista;
    }

    public String getTipoRevista() {
        return tipoRevista;
    }

    public void setTipoRevista(String tipoRevista) {
        this.tipoRevista = tipoRevista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
