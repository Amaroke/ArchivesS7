package auction;

import articles.HardwareComponent;
import journal.Journalisation;
import strategies.PriceStrategy;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.Date;

public class Auction {

    private final HardwareComponent hardwareComponent;
    private final PropertyChangeSupport property;
    private Bid bid;
    public PriceStrategy strategy;
    public final int auctionNumber = 11;

    private boolean open = true;

    public Auction(HardwareComponent hardwareComponent) {
        bid = new Bid("", 0);
        property = new PropertyChangeSupport(this);
        this.hardwareComponent = hardwareComponent;
    }

    public int getNumberComponents() {
        return hardwareComponent.getNbComponents();
    }

    public String getArticleDescription() {
        return hardwareComponent.getDescription();
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        this.property.addPropertyChangeListener(propertyName, listener);
    }

    public double getPrice() {
        return strategy.calculatePrice(hardwareComponent.getPrice(), hardwareComponent.getNbComponents());
    }

    public double getLastBid() {
        return bid.getLastBid();
    }

    public String getLastBidder() {
        return bid.getLastBidder();
    }

    public void close() throws IOException {
        this.open = false;
        property.firePropertyChange("close", null, null);
        Journalisation.getInstance().writeJournal("CLOSED for auction " + auctionNumber + " " + new Date());
        Journalisation.getInstance().closeJournal();
    }

    public void setStrategy(PriceStrategy strategy) throws IOException {
        this.strategy = strategy;
        property.firePropertyChange("strategy", null, null);
        Journalisation.getInstance().writeJournal("STRATEGY : " + strategy.toString() + " for auction " + auctionNumber + " " + new Date());
    }

    public boolean isOpen() {
        return open;
    }

    public void bid(float price, String bidder) throws IOException {
        if (this.bid.getLastBid() < price) {
            bid = new Bid(bidder, price);
            property.firePropertyChange("bid", null, bid);
            Journalisation.getInstance().writeJournal("BID by " + bidder + " : " + price + " for auction " + auctionNumber + " at " + new Date());
        } else {
            Journalisation.getInstance().writeJournal("INCORRECT BID !!! for auction " + auctionNumber + " at " + new Date());
        }
    }
}
