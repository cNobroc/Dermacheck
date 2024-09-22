package pe.edu.upc.dermacheck.dtos;

public class RevistasxUsuarioDTO {
    private String nombre;
    private int cuenta;

    public RevistasxUsuarioDTO() {}

    public RevistasxUsuarioDTO(String nombre, int cuenta) {
        this.nombre = nombre;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCount() {
        return cuenta;
    }

    public void setCount(int cuenta) {
        this.cuenta = cuenta;
    }
}
