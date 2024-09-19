package pe.edu.upc.dermacheck.dtos;


import pe.edu.upc.dermacheck.entities.Usuario;

public class RolDTO {
    private int idRol;
    private String nombreRol;
    private Usuario user;

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
