package pe.edu.upc.dermacheck.dtos;

public class UsuarioDiagnosticoDTO {
    private UsuarioDTO usuario;
    private Long cantidadDiagnosticos;

    // Constructor
    public UsuarioDiagnosticoDTO(UsuarioDTO usuario, Long cantidadDiagnosticos) {
        this.usuario = usuario;
        this.cantidadDiagnosticos = cantidadDiagnosticos;
    }

    // Getters y Setters
    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public Long getCantidadDiagnosticos() {
        return cantidadDiagnosticos;
    }

    public void setCantidadDiagnosticos(Long cantidadDiagnosticos) {
        this.cantidadDiagnosticos = cantidadDiagnosticos;
    }
}
