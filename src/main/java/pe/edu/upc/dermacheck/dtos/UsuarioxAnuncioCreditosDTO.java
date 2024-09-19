package pe.edu.upc.dermacheck.dtos;

public class UsuarioxAnuncioCreditosDTO {
    private String NombreUsuario;
    private int CantidadCreditos;

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        NombreUsuario = nombreUsuario;
    }

    public int getCantidadCreditos() {
        return CantidadCreditos;
    }

    public void setCantidadCreditos(int cantidadCreditos) {
        CantidadCreditos = cantidadCreditos;
    }
}
