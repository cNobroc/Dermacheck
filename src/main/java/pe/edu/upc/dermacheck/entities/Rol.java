package pe.edu.upc.dermacheck.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Rol", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "nombreRol"})})
public class Rol implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(name = "nombreRol", nullable = false)
    private String nombreRol;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario user;

    public Rol() {
    }

    public Rol(int idRol, Usuario user, String nombreRol) {
        this.idRol = idRol;
        this.user = user;
        this.nombreRol = nombreRol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}
