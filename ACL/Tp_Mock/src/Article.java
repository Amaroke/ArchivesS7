/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cirstea
 */
public class Article {
    private String nom;
    private Currency prix;
    private int quantity;

    public Article(String nom) {
        this.nom = nom;
    }

    public Article(String nom, Currency prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Currency getPrix() {
        return prix;
    }

    public void setPrix(Currency prix) {
        this.prix = prix;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Article{" + "nom=" + nom + ", prix=" + prix + ", quantity=" + quantity + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.nom != null ? this.nom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        if ((this.nom == null) ? (other.nom != null) : !this.nom.equals(other.nom)) {
            return false;
        }
        return true;
    }

    
}
