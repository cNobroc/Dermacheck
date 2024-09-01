package pe.edu.upc.dermacheck.dtos;

import java.sql.Time;
import java.util.Date;

public class DiagnosticoDTO {
    private int idDiagnostico;
    private Date fechaDiagnostico;
    private Time horaDiagnostico;
    private byte[] imagenDiagnostico;
    private byte[] historial;
    private int idEnfermedad;
    private int idUsuario;

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

    public int getIdEnfermedad() {
        return idEnfermedad;
    }

    public void setIdEnfermedad(int idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
