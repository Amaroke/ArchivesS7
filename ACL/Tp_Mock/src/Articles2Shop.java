/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cirstea
 */
public class Articles2Shop {

    private List<Article> panier;
    private StockService stocks;

    public Articles2Shop(StockService stocks) {
        this.stocks = stocks;
        this.panier = new ArrayList<Article>();
    }

    public List<Article> getPanier() {
        return panier;
    }

    public void setStocks(StockService stocks) {
        this.stocks = stocks;
    }

    /**
     * Ajouter un article dans le panier (et mettre a jour les stocks). Le prix
     * de l'article est enregistre au moment de l'ajout. L'ajout est realise
     * seulement si suffisament d'exemplaires sont disponibles dans le stock.
     *
     * @param nomArticle nom de l'article
     * @param quantity nombre d'exemplaires de cet articles a acheter
     * @return nombre items ajoutes au panier; 0 si pas suffisament d'articles disponibles
     */
    public int addArticleStrictQuantity(String nomArticle, int quantity) {
        Article article = new Article(nomArticle);

        int available = stocks.available(nomArticle);
        if (quantity <= available) {
            for (int i = 0; i < quantity; i++) {
                stocks.buy(nomArticle);
            }
            Currency prix = stocks.getPrix(nomArticle);
            article.setPrix(prix);
            article.setQuantity(quantity);
            panier.add(article);
        }
        return article.getQuantity();
    }

    
    /**
     * Ajouter un article dans le panier (et mettre a jour les stocks). Le prix de l'article
     * est enregistre au moment de l'ajout. On ajoute dans le panier la quantity d'exemplaires 
     * seulement dans la limite des stocks disponibles. 
     *
     * @param nomArticle nom de l'article
     * @param quantity nombre d'exemplaires de cet articles a acheter
     * @return nombre items ajoutes au panier
     */
    public int addArticleMinQuantity(String nomArticle, int quantity) {
        Article article = new Article(nomArticle);
        int nbArticles = 0;
        for (int i = 0; i < quantity; i++) {
            try {
                stocks.buy(nomArticle);
                nbArticles++;
            } catch (IllegalArgumentException ex) {
                break;
            }
        }
        if (nbArticles > 0) {
            Currency prix = new Currency(0, "EUR");
            try {
                prix = stocks.getPrix(nomArticle);
            } catch (IllegalArgumentException ex) {}
            article.setPrix(prix);
            article.setQuantity(nbArticles);
            panier.add(article);
        }
        return nbArticles;
    }

    
    
    /**
     * Supprimer (tous les exemplaires d')un article du panier (et mettre a jour les stocks). 
     *
     * @param nomArticle nom de l'article
     * @return l'article
     */
    public Article removeArticle(String nomArticle) {
        Article removed = null;
        for (Article article : panier) {
            if (article.getNom().equals(nomArticle)) {
                panier.remove(article);
                // on devrait le faire nbExemplaire times
                stocks.sendBack(nomArticle);
                removed = article;
            }
        }
        return removed;
    }

    
    
    /**
     * Calculer le prix total dans une devise donnee
     *
     * @param currency devise
     * @return prix total du paier; -1 si la devise n'est pas valide
     */
    public int prix(String currency) {
        int price = 0;
        for (Article article : panier) {
            Currency prix = article.getPrix();
            if (prix.getCurrency().equals(currency)) {
                price += prix.getAmount();
            } else {
                double rate;
                rate = stocks.getRate(prix.getCurrency(), currency);
                if(rate == -1) {price=-1; break;}
                price += prix.getAmount() * rate;
            }
        }
        return price;
    }
}
