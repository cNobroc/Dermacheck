package pe.edu.upc.dermacheck.entities;

import jakarta.persistence.*;

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


    public Tratamiento() {
    }

    public Tratamiento(int idTratamiento, String nombreTratamiento, String descripcionTratamiento, String materialMedicinal) {
        this.idTratamiento = idTratamiento;
        this.nombreTratamiento = nombreTratamiento;
        this.descripcionTratamiento = descripcionTratamiento;
        this.materialMedicinal = materialMedicinal;
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
}
