package pe.edu.upc.dermacheck.dtos;

public class IngresosxAnuncioDTO {
    private String nombres;
    private double ingresos;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public double getIngresos() {
        return ingresos;
    }

    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }
}
