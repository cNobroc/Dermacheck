package pe.edu.upc.dermacheck.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.dermacheck.entities.Enfermedad;
import pe.edu.upc.dermacheck.entities.Usuario;

import java.sql.Time;
import java.util.Date;

public class DiagnosticoDTO {
    private int idDiagnostico;

    private Date fechaDiagnostico;

    private Time horaDiagnostico;

    private byte[] imagenDiagnostico;

    private Enfermedad enfermedad;

    private Usuario usuario;

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
