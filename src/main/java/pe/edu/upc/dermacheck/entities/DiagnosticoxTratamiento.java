package pe.edu.upc.dermacheck.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "diagnosticox_tratamiento")
public class DiagnosticoxTratamiento {

    @EmbeddedId
    private
    DiagnosticoxTratamientoId id;

    @JsonIgnore
    @ManyToOne
    @MapsId("idDiagnostico")
    @JoinColumn(name = "id_diagnostico", nullable = false, insertable = false, updatable = false)
    private Diagnostico diagnostico;

    @JsonIgnore
    @ManyToOne
    @MapsId("idTratamiento")
    @JoinColumn(name = "id_tratamiento", nullable = false, insertable = false, updatable = false)
    private Tratamiento tratamiento;

    public DiagnosticoxTratamiento() {
    }

    public DiagnosticoxTratamiento(DiagnosticoxTratamientoId id, Diagnostico diagnostico, Tratamiento tratamiento) {
        this.id = id;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public DiagnosticoxTratamientoId getId() {
        return id;
    }

    public void setId(DiagnosticoxTratamientoId id) {
        this.id = id;
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

