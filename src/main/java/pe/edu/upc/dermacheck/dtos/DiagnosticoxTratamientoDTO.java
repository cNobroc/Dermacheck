package pe.edu.upc.dermacheck.dtos;

import pe.edu.upc.dermacheck.entities.Diagnostico;
import pe.edu.upc.dermacheck.entities.Tratamiento;

public class DiagnosticoxTratamientoDTO {
    private int idDiagnosticoxTratamiento;
    private Diagnostico diagnostico;
    private Tratamiento tratamiento;

    public int getIdDiagnosticoxTratamiento() {
        return idDiagnosticoxTratamiento;
    }

    public void setIdDiagnosticoxTratamiento(int idDiagnosticoxTratamiento) {
        this.idDiagnosticoxTratamiento = idDiagnosticoxTratamiento;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }
}
