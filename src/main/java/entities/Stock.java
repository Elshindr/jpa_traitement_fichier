package entities;


import java.util.List;

/**
 * The type Stock.
**/

public class Stock {

    private Integer id;


    private static List<Produit> lstProduit;

    public Stock() {
    }

    public Stock(List<Produit> lstProduit) {
        this.lstProduit = lstProduit;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static List<Produit> getLstProduit() {
        return lstProduit;
    }

}