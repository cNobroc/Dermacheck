package pe.edu.upc.dermacheck.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "comentario", length = 100)
    private String comentario;

    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "fechaFinal", nullable = false)
    private LocalDate fechaFinal;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    public Tratamiento() {
    }

    public Tratamiento(int idTratamiento, String nombreTratamiento, String descripcionTratamiento, String materialMedicinal, String comentario, LocalDate fechaInicio, LocalDate fechaFinal, boolean estado) {
        this.idTratamiento = idTratamiento;
        this.nombreTratamiento = nombreTratamiento;
        this.descripcionTratamiento = descripcionTratamiento;
        this.materialMedicinal = materialMedicinal;
        this.comentario = comentario;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
