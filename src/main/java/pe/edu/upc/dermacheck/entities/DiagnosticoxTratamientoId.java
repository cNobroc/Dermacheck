package pe.edu.upc.dermacheck.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DiagnosticoxTratamientoId implements Serializable {

    @Column(name = "id_diagnostico")
    private int idDiagnostico;

    @Column(name = "id_tratamiento")
    private int idTratamiento;

    public DiagnosticoxTratamientoId() {
    }

    public DiagnosticoxTratamientoId(int idDiagnostico, int idTratamiento) {
        this.idDiagnostico = idDiagnostico;
        this.idTratamiento = idTratamiento;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiagnosticoxTratamientoId that = (DiagnosticoxTratamientoId) o;
        return idDiagnostico == that.idDiagnostico &&
                idTratamiento == that.idTratamiento;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDiagnostico, idTratamiento);
    }
}
