package services;

import components.RecupFichier;
import entities.*;

import javax.persistence.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class IntegrationOpenFoodFacts {
    private static List<Produit> lstProduit ;

    public static void main(String[] args) throws IOException {
        RecupFichier.getInstance();
        lstProduit =  RecupFichier.leStock.getLstProduit();

        if(lstProduit==null || lstProduit.isEmpty()){
            System.err.println("Error :: lstProduit");
            return ;
        }

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("openfoodfacts");
        EntityManager em = factory.createEntityManager();
        EntityTransaction tr = em.getTransaction();

        for(Produit produit : lstProduit){
            tr.begin();
            System.out.println(produit.getLibelle());

            TypedQuery<Produit> query = em.createQuery("SELECT DISTINCT p FROM Produit p WHERE libelle = :produit", Produit.class);
            query.setParameter("produit", produit.getLibelle());
            List<Produit> lstProduit = query.getResultList();
            Produit objProduit = new Produit();
            if(lstProduit == null || lstProduit.isEmpty()){

                objProduit.setLibelle(produit.getLibelle());
                objProduit.setCategorie(checkCategorie(em, produit.getCategorie()));
                objProduit.setMarque(checkMarque(em, produit.getMarque()));
                objProduit.setGrade(produit.getGrade());
                em.persist(objProduit);

                checkIngredients(em, produit.getLstIngredient(), objProduit);
                checkAdditif(em, produit.getLstAdditif(), objProduit);
                checkAllergene(em, produit.getLstAllergene(), objProduit);
                //objProduit.getLstAllergene().addAll();

            }

            tr.commit();
        }
    }

    private static void checkAllergene( EntityManager em, List<Allergene> lstAllergene, Produit objProduit){
        for(Allergene allergene : lstAllergene){
            Allergene findAllergene = new Allergene();

            TypedQuery<Allergene> query = em.createQuery("SELECT DISTINCT a FROM Allergene a WHERE libelle = :allergene", Allergene.class);
            query.setParameter("allergene", allergene.getLibelle());
            List<Allergene> lstFindAllergene = query.getResultList();

            if((lstFindAllergene.isEmpty() || lstFindAllergene == null)){
                System.out.println(allergene.getLibelle());


                if(allergene.getLibelle().length()>255){
                    allergene.setLibelle(allergene.getLibelle().substring(0, 254));

                }
                findAllergene.setLibelle(allergene.getLibelle());
                em.persist(findAllergene);

            }
            else if(lstFindAllergene.size() == 1){
                findAllergene = lstFindAllergene.get(0);
            }else{
                System.out.println("Error :: checkAdditif");
            }
            findAllergene.getLstProduit().add(objProduit);
            objProduit.getLstAllergene().add(findAllergene);
        }

    }

    private static void checkAdditif( EntityManager em, List<Additif> lstAdditif, Produit objProduit){

        for(Additif additif : lstAdditif){
            Additif findAdditif = new Additif();

            TypedQuery<Additif> query = em.createQuery("SELECT DISTINCT a FROM Additif a WHERE libelle = :additif", Additif.class);
            query.setParameter("additif", additif.getLibelle());
            List<Additif> lstFindAdditif = query.getResultList();

            if((lstFindAdditif.isEmpty() || lstFindAdditif == null)){

                if(additif.getLibelle().length()>255){
                    additif.setLibelle(additif.getLibelle().substring(0, 254));
                }
                findAdditif.setLibelle(additif.getLibelle());

            }
            else if(lstFindAdditif.size() == 1){
                findAdditif = lstFindAdditif.get(0);
            }
            else{
                System.out.println("Error :: checkAdditif");
            }
            em.persist(findAdditif);
            objProduit.getLstAdditif().add(findAdditif);
            findAdditif.getLstProduit().add(objProduit);
        }

    }

    private static void checkIngredients(EntityManager em, List<Ingredient> lstIngredient, Produit objProduit){

        for(Ingredient ingredient : lstIngredient){
            Ingredient finalIngredient = new Ingredient();

            TypedQuery<Ingredient> query = em.createQuery("SELECT DISTINCT i FROM Ingredient i WHERE libelle = :ingredient", Ingredient.class);
            query.setParameter("ingredient", ingredient.getLibelle());
            List<Ingredient> lstFindIngredient = query.getResultList();

            if((lstFindIngredient.isEmpty() || lstFindIngredient == null)){

                if(ingredient.getLibelle().length()>255){
                    ingredient.setLibelle(ingredient.getLibelle().substring(0, 254));
                }
                finalIngredient.setLibelle(ingredient.getLibelle());

            }
            else if(lstFindIngredient.size() == 1){
                finalIngredient = lstFindIngredient.get(0);
            }
            else{
                System.out.println("Error :: checkIngredient");
            }
            em.persist(finalIngredient);
            objProduit.getLstIngredient().add(finalIngredient);
            finalIngredient.getLstProduit().add(objProduit);
        }
    }

    private static Categorie checkCategorie(EntityManager em, Categorie categorie){
        Categorie finalcategorie;

        TypedQuery<Categorie> query = em.createQuery("SELECT DISTINCT c FROM Categorie c WHERE libelle = :categorie", Categorie.class);
        query.setParameter("categorie", categorie.getLibelle());
        List<Categorie> lstCategorie = query.getResultList();

        if((lstCategorie.isEmpty() || lstCategorie == null)){
            Categorie objCategorie = new Categorie();
            objCategorie.setLibelle(categorie.getLibelle());
            em.persist(objCategorie);
            finalcategorie = objCategorie;
        }
        else if(lstCategorie.size() == 1){
            finalcategorie = lstCategorie.get(0);
        }else{
            System.out.println("Error :: checkCategorie");
            return null;
        }

        return finalcategorie;
    }

    private static Marque checkMarque(EntityManager em, Marque marque){
        Marque finalMarque = new Marque();
        TypedQuery<Marque> query = em.createQuery("SELECT DISTINCT c FROM Marque c WHERE libelle = :marque", Marque.class);
        query.setParameter("marque", marque.getLibelle());

        List<Marque> lstMarque = query.getResultList();

        if((lstMarque.isEmpty() || lstMarque == null)){
            System.out.println(marque.getLibelle());

            Marque objMarque = new Marque();
            objMarque.setLibelle(marque.getLibelle());
            em.persist(objMarque);
            finalMarque = objMarque;
        }
        else if(lstMarque.size() == 1){
            finalMarque = lstMarque.get(0);
        }else{
            System.out.println("Error :: checkCategorie");
            return null;
        }

        return finalMarque;
    }
}