package pe.edu.upc.dermacheck.dtos;

import pe.edu.upc.dermacheck.entities.Diagnostico;
import pe.edu.upc.dermacheck.entities.Tratamiento;

public class DiagnosticoxTratamientoDTO {
    private int idDiagnostico;
    private int idTratamiento;
    private Diagnostico diagnostico;
    private Tratamiento tratamiento;

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
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
