package pe.edu.upc.dermacheck.dtos;

import pe.edu.upc.dermacheck.entities.Tratamiento;

import java.util.List;

public class EspecialistaDTO {
    private int idEspecialista;
    private String certificadoTratamiento;
    private List<Tratamiento> tratamientos;

    public int getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(int idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    public String getCertificadoTratamiento() {
        return certificadoTratamiento;
    }

    public void setCertificadoTratamiento(String certificadoTratamiento) {
        this.certificadoTratamiento = certificadoTratamiento;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }
}
