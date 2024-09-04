package pe.edu.upc.dermacheck.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Tratamiento")
public class Tratamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTratamiento;

    @Column(name = "nombreTratamiento", nullable = false, length = 100)
    private String nombreTratamiento;

    @Column(name = "descripcionTratamiento", nullable = false, length = 150)
    private String descripcionTratamiento;

    @Column(name = "materialMedicinal", nullable = false, length = 300)
    private String materialMedicinal;

    @JsonIgnore
    @OneToMany(mappedBy = "tratamiento")
    private List<DiagnosticoxTratamiento> tratamientos;


    public Tratamiento() {
    }

    public Tratamiento(int idTratamiento, String nombreTratamiento, String descripcionTratamiento, String materialMedicinal, List<DiagnosticoxTratamiento> tratamientos) {
        this.idTratamiento = idTratamiento;
        this.nombreTratamiento = nombreTratamiento;
        this.descripcionTratamiento = descripcionTratamiento;
        this.materialMedicinal = materialMedicinal;
        this.tratamientos = tratamientos;
    }

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getNombreTratamiento() {
        return nombreTratamiento;
    }

    public void setNombreTratamiento(String nombreTratamiento) {
        this.nombreTratamiento = nombreTratamiento;
    }

    public String getDescripcionTratamiento() {
        return descripcionTratamiento;
    }

    public void setDescripcionTratamiento(String descripcionTratamiento) {
        this.descripcionTratamiento = descripcionTratamiento;
    }

    public String getMaterialMedicinal() {
        return materialMedicinal;
    }

    public void setMaterialMedicinal(String materialMedicinal) {
        this.materialMedicinal = materialMedicinal;
    }

    public List<DiagnosticoxTratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<DiagnosticoxTratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }
}
