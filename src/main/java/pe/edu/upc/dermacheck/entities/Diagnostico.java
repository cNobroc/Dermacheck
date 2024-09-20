package pe.edu.upc.dermacheck.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Diagnostico")
public class Diagnostico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDiagnostico;

    @Column(name = "fechaDiagnostico", nullable = false)
    private LocalDate fechaDiagnostico;

    @Column(name = "horaDiagnostico", nullable = false)
    private LocalTime horaDiagnostico;

    @Column(name = "imagenDiagnostico", nullable = false)
    private byte[] imagenDiagnostico;

    @Column(name = "puntuacion", nullable = false)
    private int puntuacion;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idEnfermedad", nullable = false)
    private Enfermedad enfermedad;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "idCentroMedico", nullable = false)
    private CentrosMedicos centrosMedicos;

    public Diagnostico() {
    }

    public Diagnostico(int idDiagnostico, LocalTime horaDiagnostico, LocalDate fechaDiagnostico, byte[] imagenDiagnostico, int puntuacion, Usuario usuario, CentrosMedicos centrosMedicos, Enfermedad enfermedad) {
        this.idDiagnostico = idDiagnostico;
        this.horaDiagnostico = horaDiagnostico;
        this.fechaDiagnostico = fechaDiagnostico;
        this.imagenDiagnostico = imagenDiagnostico;
        this.puntuacion = puntuacion;
        this.usuario = usuario;
        this.centrosMedicos = centrosMedicos;
        this.enfermedad = enfermedad;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public LocalDate getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(LocalDate fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public LocalTime getHoraDiagnostico() {
        return horaDiagnostico;
    }

    public void setHoraDiagnostico(LocalTime horaDiagnostico) {
        this.horaDiagnostico = horaDiagnostico;
    }

    public byte[] getImagenDiagnostico() {
        return imagenDiagnostico;
    }

    public void setImagenDiagnostico(byte[] imagenDiagnostico) {
        this.imagenDiagnostico = imagenDiagnostico;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public CentrosMedicos getCentrosMedicos() {return centrosMedicos;}

    public void setCentrosMedicos(CentrosMedicos centrosMedicos) {this.centrosMedicos = centrosMedicos;}
}