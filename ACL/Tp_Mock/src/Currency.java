/**
 *
 * @author cirstea
 */
public class Currency {
    private int amount;
    private String currency;

    public Currency(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.amount;
        hash = 97 * hash + (this.currency != null ? this.currency.hashCode() : 0);
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
        final Currency other = (Currency) obj;
        if (this.amount != other.amount) {
            return false;
        }
        if ((this.currency == null) ? (other.currency != null) : !this.currency.equals(other.currency)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Currency{" + "amount=" + amount + ", currency=" + currency + '}';
    }
    
    
    
    
}
