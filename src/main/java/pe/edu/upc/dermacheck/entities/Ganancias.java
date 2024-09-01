package pe.edu.upc.dermacheck.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Ganancias")
public class Ganancias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGanancias;

    @Column(name = "monto")
    private double monto;

    @ManyToOne
    @JoinColumn(name = "idAnuncio", nullable = false)
    private Anuncio anuncio;

    public Ganancias() {
    }

    public Ganancias(int idGanancias, double monto, Anuncio anuncio) {
        this.idGanancias = idGanancias;
        this.monto = monto;
        this.anuncio = anuncio;
    }

    public int getIdGanancias() {
        return idGanancias;
    }

    public void setIdGanancias(int idGanancias) {
        this.idGanancias = idGanancias;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }
}
