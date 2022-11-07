package entities;

import java.util.List;
import java.util.Map;

/**
 * The type Produit.
 */
public class Produit {
    private String nom;
    private Categorie categorie;
    private Marque marque;
    private String scoreNutritionnel;
    private Map<String, String> lstAttributs;
    private List<Ingredient> lstIngredient;
    private List<Additif> lstAdditif;
    private List<Allergene> lstAllergene;


    /**
     * Instantiates a new Produit.
     *
     * @param categorie         the categorie
     * @param marque            the marque
     * @param scoreNutritionnel the score nutritionnel
     * @param lstAttributs      the list attributs
     * @param lstIngredient     the list ingredient
     * @param lstAdditif        the list additif
     * @param lstAllergene      the list allergene
     */
    public Produit(String nom,Categorie categorie, Marque marque, String scoreNutritionnel, Map<String, String> lstAttributs, List<Ingredient> lstIngredient, List<Additif> lstAdditif, List<Allergene> lstAllergene) {
        this.nom = nom;
        this.categorie = categorie;
        this.marque = marque;
        this.scoreNutritionnel = scoreNutritionnel;
        this.lstAttributs = lstAttributs;
        this.lstIngredient = lstIngredient;
        this.lstAdditif = lstAdditif;
        this.lstAllergene = lstAllergene;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
    public String getScoreNutritionnel() {
        return scoreNutritionnel;
    }

    /**
     * Sets score nutritionnel.
     *
     * @param scoreNutritionnel the score nutritionnel
     */
    public void setScoreNutritionnel(String scoreNutritionnel) {
        this.scoreNutritionnel = scoreNutritionnel;
    }

    /**
     * Gets lst attributs.
     *
     * @return the lst attributs
     */
    public Map<String, String> getLstAttributs() {
        return lstAttributs;
    }

    /**
     * Sets lst attributs.
     *
     * @param lstAttributs the lst attributs
     */
    public void setLstAttributs(Map<String, String> lstAttributs) {
        this.lstAttributs = lstAttributs;
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
