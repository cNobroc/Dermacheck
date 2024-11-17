package pe.edu.upc.dermacheck.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public class EstadoDiagnosticoFalseDTO {
    private int idDiagnostico;

    private LocalDate fechaDiagnostico;


    private int IdUsuario;

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



    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }
}
