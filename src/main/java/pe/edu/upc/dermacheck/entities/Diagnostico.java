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

    public Diagnostico() {
    }

    public Diagnostico(int idDiagnostico, LocalDate fechaDiagnostico, LocalTime horaDiagnostico, byte[] imagenDiagnostico, int puntuacion, Enfermedad enfermedad, Usuario usuario) {
        this.idDiagnostico = idDiagnostico;
        this.fechaDiagnostico = fechaDiagnostico;
        this.horaDiagnostico = horaDiagnostico;
        this.imagenDiagnostico = imagenDiagnostico;
        this.puntuacion = puntuacion;
        this.enfermedad = enfermedad;
        this.usuario = usuario;
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



}