package entities;

import javax.persistence.*;

/**
 * The type Categorie.
 */
@Entity
@Table(name="categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String libelle;

    public Categorie() {
    }

    public Categorie(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets libelle.
     *
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Sets libelle.
     *
     * @param libelle the libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
