package pe.edu.upc.dermacheck.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "DiagnosticoImagen")
public class DiagnostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idImagen;

    @Column(name="imagenRoute", nullable = false)
    private String imagenRoute;

    @Column(name = "numProductImage", nullable = false)
    private  int numProductImage;

    @ManyToOne
    @JoinColumn(name="idDiagnostico")
    private Diagnostico diagnostico;

    public DiagnostImage(int idImagen, String imagenRoute, int numProductImage, Diagnostico diagnostico) {
        this.idImagen = idImagen;
        this.imagenRoute = imagenRoute;
        this.numProductImage = numProductImage;
        this.diagnostico = diagnostico;
    }

    public DiagnostImage() {
    }

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
