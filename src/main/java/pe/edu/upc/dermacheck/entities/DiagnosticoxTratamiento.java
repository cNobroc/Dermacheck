package pe.edu.upc.dermacheck.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "diagnosticox_tratamiento")
public class DiagnosticoxTratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDiagnosticoxTratamiento;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_diagnostico", nullable = false)
    private Diagnostico diagnostico;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_tratamiento", nullable = false)
    private Tratamiento tratamiento;

    public DiagnosticoxTratamiento() {
    }

    public DiagnosticoxTratamiento(int idDiagnosticoxTratamiento, Diagnostico diagnostico, Tratamiento tratamiento) {
        this.idDiagnosticoxTratamiento = idDiagnosticoxTratamiento;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

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
