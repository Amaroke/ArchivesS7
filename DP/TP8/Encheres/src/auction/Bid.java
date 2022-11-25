package auction;

public class Bid {

    private final String bidder;
    private final double bid;

    public Bid(String bidder, double bid) {
        this.bidder = bidder;
        this.bid = bid;
    }

    public double getLastBid() {
        return bid;
    }

    public String getLastBidder() {
        return bidder;
    }
}
