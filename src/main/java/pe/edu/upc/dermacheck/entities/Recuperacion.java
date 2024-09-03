package pe.edu.upc.dermacheck.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Recuperacion")
public class Recuperacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecuperacion;

    @Column(name = "fechaSolicitud", nullable = false)
    private Date fechaSolicitud;

    @Column(name = "codigoRecuperacion", nullable = false, length = 6)
    private String codigoRecuperacion;

    @Column(name = "estadoRecuperacion", nullable = false)
    private boolean estadoRecuperacion;

    @Column(name = "fechaExpiracion", nullable = false)
    private Date fechaExpiracion;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    public Recuperacion() {
    }

    public Recuperacion(int idRecuperacion, Date fechaSolicitud, String codigoRecuperacion, boolean estadoRecuperacion, Date fechaExpiracion, Usuario usuario) {
        this.idRecuperacion = idRecuperacion;
        this.fechaSolicitud = fechaSolicitud;
        this.codigoRecuperacion = codigoRecuperacion;
        this.estadoRecuperacion = estadoRecuperacion;
        this.fechaExpiracion = fechaExpiracion;
        this.usuario = usuario;
    }

    public int getIdRecuperacion() {
        return idRecuperacion;
    }

    public void setIdRecuperacion(int idRecuperacion) {
        this.idRecuperacion = idRecuperacion;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getCodigoRecuperacion() {
        return codigoRecuperacion;
    }

    public void setCodigoRecuperacion(String codigoRecuperacion) {
        this.codigoRecuperacion = codigoRecuperacion;
    }

    public boolean isEstadoRecuperacion() {
        return estadoRecuperacion;
    }

    public void setEstadoRecuperacion(boolean estadoRecuperacion) {
        this.estadoRecuperacion = estadoRecuperacion;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
