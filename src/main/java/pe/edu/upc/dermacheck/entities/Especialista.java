package pe.edu.upc.dermacheck.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Especialista")
public class Especialista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEspecialista;

    @Column(name = "certificadoTratamiento", nullable = false, length = 20)
    private String certificadoTratamiento;

    @OneToMany(mappedBy = "especialista")
    private List<Tratamiento> tratamientos;

    public Especialista() {
    }

    public Especialista(int idEspecialista, String certificadoTratamiento, List<Tratamiento> tratamientos) {
        this.idEspecialista = idEspecialista;
        this.certificadoTratamiento = certificadoTratamiento;
        this.tratamientos = tratamientos;
    }

    public int getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(int idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    public String getCertificadoTratamiento() {
        return certificadoTratamiento;
    }

    public void setCertificadoTratamiento(String certificadoTratamiento) {
        this.certificadoTratamiento = certificadoTratamiento;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }
}
