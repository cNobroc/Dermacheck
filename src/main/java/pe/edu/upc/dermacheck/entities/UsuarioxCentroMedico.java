package pe.edu.upc.dermacheck.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UsuarioxCentroMedico")
public class UsuarioxCentroMedico {

    @EmbeddedId
    private UsuarioxCentroMedicoId id;

    @Column(name = "asunto", nullable = false, length = 50)
    private String asunto;

    @Column(name = "fechaTratamiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaTratamiento;

    public UsuarioxCentroMedico() {
    }

    public UsuarioxCentroMedico(UsuarioxCentroMedicoId id, String asunto, Date fechaTratamiento) {
        this.id = id;
        this.asunto = asunto;
        this.fechaTratamiento = fechaTratamiento;
    }

    public UsuarioxCentroMedicoId getId() {
        return id;
    }

    public void setId(UsuarioxCentroMedicoId id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Date getFechaTratamiento() {
        return fechaTratamiento;
    }

    public void setFechaTratamiento(Date fechaTratamiento) {
        this.fechaTratamiento = fechaTratamiento;
    }
}

@Embeddable
class UsuarioxCentroMedicoId implements java.io.Serializable {

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idCentroMedico", nullable = false)
    private CentrosMedicos centrosMedicos;

    public UsuarioxCentroMedicoId() {
    }

    public UsuarioxCentroMedicoId(Usuario usuario, CentrosMedicos centrosMedicos) {
        this.usuario = usuario;
        this.centrosMedicos = centrosMedicos;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public CentrosMedicos getCentrosMedicos() {
        return centrosMedicos;
    }

    public void setCentrosMedicos(CentrosMedicos centrosMedicos) {
        this.centrosMedicos = centrosMedicos;
    }
}
