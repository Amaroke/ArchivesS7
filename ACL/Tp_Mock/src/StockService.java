/**
 *
 * @author cirstea
 */
public interface StockService {

    /**
     * Trouve le prix de l'article passe en parametre. Une exception est 
     * levee si l'article n'est pas repertorie dans la BDD.
     * 
     * @param articleName nom de l'article
     * @return prix de l'article
     * @throws IllegalArgumentException
     */
    Currency getPrix(String articleName) throws IllegalArgumentException;;



    /**
     * Retourne la quantite d'items disponibles pour l'articles
     * 
     * @param articleName nom de l'article
     * @return quantite disponible; -1 si l'article n'est pas repertorie dans la BDD
     * 
     * @deprecated 
     */
    int available(String articleName);

    
    
    /**
     * Decremente le nombre d'items disponibles pour l'article. Une exception est 
     * levee si l'article n'est pas repertorie dans la BDD.
     * 
     * @param nomArticle nom de l'article
     * @throws IllegalArgumentException
     */
    void buy(String nomArticle) throws IllegalArgumentException;;



    /**
     * Retourner l'article. Incremente le nombre d'items disponibles pour l'article.
     * 
     * @param nomArticle nom de l'article
     */
    void sendBack(String nomArticle);
    
    
    
    /**
     * Taux d'echange entre 2 devises 
     * @param fromCurrency
     * @param toCurrency
     * @return taux; -1 si une des deux devises n'existe pas
     */
    double getRate(String fromCurrency, String toCurrency);

}
