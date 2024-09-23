package pe.edu.upc.dermacheck.dtos;

public class UsuarioDiagnosticoDTO {
    private UsuarioDTO usuario;
    private Long cantidadDiagnosticos;


    public UsuarioDiagnosticoDTO(UsuarioDTO usuario, Long cantidadDiagnosticos) {
        this.usuario = usuario;
        this.cantidadDiagnosticos = cantidadDiagnosticos;
    }


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
