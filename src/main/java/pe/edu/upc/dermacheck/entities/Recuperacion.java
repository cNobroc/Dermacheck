package pe.edu.upc.dermacheck.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Recuperacion")
public class Recuperacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecuperacion;

    @Column(name = "fechaSolicitud", nullable = false)
    private LocalDate fechaSolicitud;

    @Column(name = "codigoRecuperacion", nullable = false, length = 6)
    private int codigoRecuperacion;

    @Column(name = "estadoRecuperacion", nullable = false)
    private boolean estadoRecuperacion;

    @Column(name = "fechaExpiracion", nullable = false)
    private LocalDate fechaExpiracion;


    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    public Recuperacion() {
    }

    public Recuperacion(int idRecuperacion, LocalDate fechaSolicitud, int codigoRecuperacion, boolean estadoRecuperacion, LocalDate fechaExpiracion, Usuario usuario) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
