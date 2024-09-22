package pe.edu.upc.dermacheck.dtos;

public class RecuperacionesxUsuarioDTO {

    private String nombre;
    private int count;

    public RecuperacionesxUsuarioDTO() {}

    public RecuperacionesxUsuarioDTO(String nombre, int count) {
        this.nombre = nombre;
        this.count = count;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
