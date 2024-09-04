package pe.edu.upc.dermacheck.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import pe.edu.upc.dermacheck.entities.Usuario;


import java.time.LocalDate;

public class RecuperacionDTO {

    private int idRecuperacion;

    private LocalDate fechaSolicitud;

    private int codigoRecuperacion;

    private boolean estadoRecuperacion;

    private LocalDate fechaExpiracion;
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getIdRecuperacion() {
        return idRecuperacion;
    }

    public void setIdRecuperacion(int idRecuperacion) {
        this.idRecuperacion = idRecuperacion;
    }

    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public int getCodigoRecuperacion() {
        return codigoRecuperacion;
    }

    public void setCodigoRecuperacion(int codigoRecuperacion) {
        this.codigoRecuperacion = codigoRecuperacion;
    }

    public boolean isEstadoRecuperacion() {
        return estadoRecuperacion;
    }

    public void setEstadoRecuperacion(boolean estadoRecuperacion) {
        this.estadoRecuperacion = estadoRecuperacion;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
}
