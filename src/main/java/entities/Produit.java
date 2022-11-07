package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The type Produit.
 */
@Entity
@Table(name="produit")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String libelle;
    private String grade;
    @OneToOne
    private Categorie categorie;
    @OneToOne
    private Marque marque;

    @ManyToMany(mappedBy = "lstProduit")
    private List<Ingredient> lstIngredient =new ArrayList<>();

    @ManyToMany(mappedBy = "lstProduit")
    private List<Additif> lstAdditif = new ArrayList<>();

    @ManyToMany(mappedBy = "lstProduit")
    private List<Allergene> lstAllergene=new ArrayList<>();

   // private Map<String, Integer> mapAttribut;

    public Produit() {
    }


    public Produit(String libelle, Categorie categorie, Marque marque, String grade, List<Ingredient> lstIngredient, List<Additif> lstAdditif, List<Allergene> lstAllergene) {
        this.libelle = libelle;
        this.categorie = categorie;
        this.marque = marque;
        this.grade = grade;
        this.lstIngredient = lstIngredient;
        this.lstAdditif = lstAdditif;
        this.lstAllergene = lstAllergene;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Gets categorie.
     *
     * @return the categorie
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * Sets categorie.
     *
     * @param categorie the categorie
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    /**
     * Gets marque.
     *
     * @return the marque
     */
    public Marque getMarque() {
        return marque;
    }

    /**
     * Sets marque.
     *
     * @param marque the marque
     */
    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    /**
     * Gets score nutritionnel.
     *
     * @return the score nutritionnel
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Sets score nutritionnel.
     *
     * @param grade the score nutritionnel
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }



    /**
     * Gets lst ingredient.
     *
     * @return the lst ingredient
     */
    public List<Ingredient> getLstIngredient() {
        return lstIngredient;
    }

    /**
     * Sets lst ingredient.
     *
     * @param lstIngredient the lst ingredient
     */
    public void setLstIngredient(List<Ingredient> lstIngredient) {
        this.lstIngredient = lstIngredient;
    }

    /**
     * Gets lst additif.
     *
     * @return the lst additif
     */
    public List<Additif> getLstAdditif() {
        return lstAdditif;
    }

    /**
     * Sets lst additif.
     *
     * @param lstAdditif the lst additif
     */
    public void setLstAdditif(List<Additif> lstAdditif) {
        this.lstAdditif = lstAdditif;
    }

    /**
     * Gets lst allegerne.
     *
     * @return the lst allegerne
     */
    public List<Allergene> getLstAllergene() {
        return lstAllergene;
    }

    /**
     * Sets lst allegerne.
     *
     * @param lstAllergene the lst allergene
     */
    public void setLstAllergene(List<Allergene> lstAllergene) {
        this.lstAllergene = lstAllergene;
    }
}
