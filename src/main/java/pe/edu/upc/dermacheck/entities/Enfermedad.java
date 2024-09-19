package pe.edu.upc.dermacheck.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Enfermedad")
public class Enfermedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnfermedad;

    @Column(name = "nombreEnfermedad", nullable = false, length = 20)
    private String nombreEnfermedad;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @Column(name = "sintomas", nullable = false, length = 100)
    private String sintomas;

    public Enfermedad() {
    }

    public Enfermedad(String sintomas, String descripcion, String nombreEnfermedad, int idEnfermedad) {
        this.sintomas = sintomas;
        this.descripcion = descripcion;
        this.nombreEnfermedad = nombreEnfermedad;
        this.idEnfermedad = idEnfermedad;
    }

    public int getIdEnfermedad() {
        return idEnfermedad;
    }

    public void setIdEnfermedad(int idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    public String getNombreEnfermedad() {
        return nombreEnfermedad;
    }

    public void setNombreEnfermedad(String nombreEnfermedad) {
        this.nombreEnfermedad = nombreEnfermedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }
}
