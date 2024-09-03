package pe.edu.upc.dermacheck.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nombres", nullable = false, length = 20)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 20)
    private String apellidos;

    @Column(name = "nombreUsuario", nullable = false, length = 20)
    private String nombreUsuario;

    @Column(name = "contrasenha", nullable = false, length = 15)
    private String contrasenha;

    @Column(name = "correo", nullable = false, length = 20)
    private String correo;

    @Column(name = "sitioWeb", length = 30)
    private String sitioWeb;

    @Column(name = "telefono", nullable = false)
    private int telefono;

    @Column(name = "nombreEmpresa", length = 20)
    private String nombreEmpresa;

    @Column(name = "esPremium")
    private boolean esPremium;


    @ManyToOne
    @JoinColumn(name = "idRol", nullable = false)
    private Rol rol;

    public Usuario() {
        this.esPremium = false;
    }

    public Usuario(int idUsuario, String nombres, String apellidos, String nombreUsuario, String contrasenha, String correo, String sitioWeb, int telefono, String nombreEmpresa, Rol rol) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nombreUsuario = nombreUsuario;
        this.contrasenha = contrasenha;
        this.correo = correo;
        this.sitioWeb = sitioWeb;
        this.telefono = telefono;
        this.nombreEmpresa = nombreEmpresa;
        this.esPremium = false;
        this.rol = rol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public boolean isEsPremium() {
        return esPremium;
    }

    public void setEsPremium(boolean esPremium) {
        this.esPremium = esPremium;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
