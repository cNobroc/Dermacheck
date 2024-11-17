package pe.edu.upc.dermacheck.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.dermacheck.entities.Diagnostico;

public class DiagnosticoImageDTO {

    private int idImagen;


    private String imagenRoute;

    private  int numProductImage;


    private Diagnostico diagnostico;

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getImagenRoute() {
        return imagenRoute;
    }

    public void setImagenRoute(String imagenRoute) {
        this.imagenRoute = imagenRoute;
    }

    public int getNumProductImage() {
        return numProductImage;
    }

    public void setNumProductImage(int numProductImage) {
        this.numProductImage = numProductImage;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
}
