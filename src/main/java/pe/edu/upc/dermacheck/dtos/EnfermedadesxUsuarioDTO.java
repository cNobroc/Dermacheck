package pe.edu.upc.dermacheck.dtos;

public class EnfermedadesxUsuarioDTO {
    private String nombreUsuario;
    private int CantidadEnfermedades;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getCantidadEnfermedades() {
        return CantidadEnfermedades;
    }

    public void setCantidadEnfermedades(int cantidadEnfermedades) {
        CantidadEnfermedades = cantidadEnfermedades;
    }
}
