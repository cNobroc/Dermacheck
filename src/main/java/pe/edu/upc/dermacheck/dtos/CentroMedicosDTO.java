package pe.edu.upc.dermacheck.dtos;


public class CentroMedicosDTO {
    private int idCentroMedico;
    private int nombre;
    private int telefono;
    private String especialidades;

    public int getIdCentroMedico() {
        return idCentroMedico;
    }

    public void setIdCentroMedico(int idCentroMedico) {
        this.idCentroMedico = idCentroMedico;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(String especialidades) {
        this.especialidades = especialidades;
    }
}
