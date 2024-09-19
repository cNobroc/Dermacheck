package pe.edu.upc.dermacheck.dtos;

public class TratamientoDTO {
    private int idTratamiento;
    private String nombreTratamiento;
    private String descripcionTratamiento;
    private String materialMedicinal;

    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getNombreTratamiento() {
        return nombreTratamiento;
    }

    public void setNombreTratamiento(String nombreTratamiento) {
        this.nombreTratamiento = nombreTratamiento;
    }

    public String getDescripcionTratamiento() {
        return descripcionTratamiento;
    }

    public void setDescripcionTratamiento(String descripcionTratamiento) {
        this.descripcionTratamiento = descripcionTratamiento;
    }

    public String getMaterialMedicinal() {
        return materialMedicinal;
    }

    public void setMaterialMedicinal(String materialMedicinal) {
        this.materialMedicinal = materialMedicinal;
    }
}
