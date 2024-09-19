package pe.edu.upc.dermacheck.dtos;

import pe.edu.upc.dermacheck.entities.Diagnostico;

public class DiagnosticoUsuarioxFechaDTO {
    private Diagnostico diagnostico;
    private String nombresUsuario;

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getNombresUsuario() {
        return nombresUsuario;
    }

    public void setNombresUsuario(String nombresUsuario) {
        this.nombresUsuario = nombresUsuario;
    }
}
