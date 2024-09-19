package pe.edu.upc.dermacheck.dtos;

import pe.edu.upc.dermacheck.entities.Usuario;

public class ArticulosDermatologicosDTO {
    private int idArticulosDermatologico;
    private String nombreRevista;
    private String tipoRevista;
    private String descripcion;
    private String url;
    private Usuario usuario;

    public int getIdArticulosDermatologico() {
        return idArticulosDermatologico;
    }

    public void setIdArticulosDermatologico(int idArticulosDermatologico) {
        this.idArticulosDermatologico = idArticulosDermatologico;
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
