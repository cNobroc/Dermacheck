package pe.edu.upc.dermacheck.dtos;

import pe.edu.upc.dermacheck.entities.CentrosMedicos;
import pe.edu.upc.dermacheck.entities.Enfermedad;
import pe.edu.upc.dermacheck.entities.Usuario;

import java.time.LocalDate;
import java.time.LocalTime;

public class DiagnosticoDTO {
    private int idDiagnostico;
    private LocalDate fechaDiagnostico;
    private int puntuacion;
    private Enfermedad enfermedad;
    private Usuario usuario;
    private CentrosMedicos centrosMedicos;

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
