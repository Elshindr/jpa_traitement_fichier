package entities;

import java.util.List;

/**
 * The type Stock.
 */
public class Stock {
    private static List<Produit> lstProduit;

    /**
     * Instantiates a new Stock.
     *
     * @param lstProduit the lst produit
     */
    public Stock(List<Produit> lstProduit) {
        this.lstProduit = lstProduit;
    }

    /**
     * Gets lst produit.
     *
     * @return the lst produit
     */
    public List<Produit> getLstProduit() {
        return lstProduit;
    }

    /**
     * Sets lst produit.
     *
     * @param lstProduit the lst produit
     */
    public void setLstProduit(List<Produit> lstProduit) {
        this.lstProduit = lstProduit;
    }
}
