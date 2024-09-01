package pe.edu.upc.dermacheck.entities;

import jakarta.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "Diagnostico")
public class Diagnostico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDiagnostico;

    @Column(name = "fechaDiagnostico", nullable = false)
    private Date fechaDiagnostico;

    @Column(name = "horaDiagnostico", nullable = false)
    private Time horaDiagnostico;

    @Column(name = "imagenDiagnostico", nullable = false)
    private byte[] imagenDiagnostico;

    @Column(name = "historial", nullable = false)
    private byte[] historial;

    @ManyToOne
    @JoinColumn(name = "idEnfermedad", nullable = false)
    private Enfermedad enfermedad;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    public Diagnostico() {
    }

    public Diagnostico(int idDiagnostico, Date fechaDiagnostico, Time horaDiagnostico, byte[] imagenDiagnostico, byte[] historial, Enfermedad enfermedad, Usuario usuario) {
        this.idDiagnostico = idDiagnostico;
        this.fechaDiagnostico = fechaDiagnostico;
        this.horaDiagnostico = horaDiagnostico;
        this.imagenDiagnostico = imagenDiagnostico;
        this.historial = historial;
        this.enfermedad = enfermedad;
        this.usuario = usuario;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public Date getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(Date fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public Time getHoraDiagnostico() {
        return horaDiagnostico;
    }

    public void setHoraDiagnostico(Time horaDiagnostico) {
        this.horaDiagnostico = horaDiagnostico;
    }

    public byte[] getImagenDiagnostico() {
        return imagenDiagnostico;
    }

    public void setImagenDiagnostico(byte[] imagenDiagnostico) {
        this.imagenDiagnostico = imagenDiagnostico;
    }

    public byte[] getHistorial() {
        return historial;
    }

    public void setHistorial(byte[] historial) {
        this.historial = historial;
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
