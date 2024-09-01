package pe.edu.upc.dermacheck.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CentrosMedicos")
public class CentrosMedicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCentroMedico;

    @Column(name = "nombre", nullable = false, length = 20)
    private String nombre;

    @Column(name = "telefono", nullable = false)
    private int telefono;

    @Column(name = "direccion", nullable = false, length = 50)
    private String direccion;

    @Column(name = "especialidades", nullable = false, length = 30)
    private String especialidades;

    public CentrosMedicos() {
    }

    public CentrosMedicos(int idCentroMedico, String nombre, int telefono, String direccion, String especialidades) {
        this.idCentroMedico = idCentroMedico;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.especialidades = especialidades;
    }

    public int getIdCentroMedico() {
        return idCentroMedico;
    }

    public void setIdCentroMedico(int idCentroMedico) {
        this.idCentroMedico = idCentroMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }
}
