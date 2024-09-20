package pe.edu.upc.dermacheck.dtos;

public class MaterialesMedicinalesxUsuarioDTO {

    private String nombres;

    private int idDiagnostico;

    private String materialMedicinal;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getMaterialMedicinal() {
        return materialMedicinal;
    }

    public void setMaterialMedicinal(String materialMedicinal) {
        this.materialMedicinal = materialMedicinal;
    }

    public int getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(int idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }
}
