package start;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import articles.*;
import auction.Auction;
import strategies.BatchPrice;
import view.Auctioneer;
import view.Bidder;

/**
 * @author cirstea
 */
public class AuctionOffice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        HardwareComponent hdd = new HDD(10, 50, "2.5i", null);
        HardwareComponent hddext = new HDD(20, 50, "M.2", "Seagate");
        HardwareComponent processor = new Processor(600, 3, "core I5", "Intel");
        HardwareAssembly mb = new MotherBoard(200, "3XD", null);
        HardwareAssembly computer = new Computer(300, "XPS", "DELL");
        mb.addComponent(processor);
        mb.addComponent(hdd);
        computer.addComponent(mb);
        computer.addComponent(hddext);

        computer.assignId(1);

        System.out.println("\n" + computer.toString(0) + "\n");

        mb.sell();

        System.out.println(computer.toString(0));

        Auction auction = new Auction(computer);
        auction.setStrategy(new BatchPrice());

        List<String> bidders = Arrays.asList("James", "Vincent");
        launchBidders(auction, bidders);
    }

    private static void launchBidders(Auction auction, List<String> bidders) {
        for (String bidder : bidders) {
            new Bidder(auction, bidder);
        }
        new Auctioneer(auction);
    }
}
