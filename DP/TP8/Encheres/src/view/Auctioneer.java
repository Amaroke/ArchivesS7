/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import auction.Auction;
import auction.Bid;
import strategies.BatchPrice;
import strategies.FlatPrice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author cirstea
 */
public class Auctioneer {

    private final JFrame frame = new JFrame("Auctioneer");
    private final JButton stopButton = new JButton("Stop");
    private final JTextArea articleName = new JTextArea("Article: ");
    private final JLabel articlePrice = new JLabel("Price: ");
    private final JLabel lastBid = new JLabel("Last bid: ");
    private final JLabel lastBidder = new JLabel(" Winner: ");
    private final JButton flatButton = new JButton("Flat");
    private final JButton batchButton = new JButton("Batch");

    private Auction auction;


    public Auctioneer(Auction auction) {


        if (auction.getNumberComponents() > 0) {
            this.auction = auction;

            this.auction.addPropertyChangeListener("close", e -> {
                stopButton.setEnabled(false);
                articleName.setText("  Article: " + auction.getArticleDescription());
                lastBid.setVisible(true);
                lastBidder.setVisible(true);
                frame.getContentPane().repaint();
            });
            this.auction.addPropertyChangeListener("bid", e -> {
                Bid newBid = (Bid) e.getNewValue();
                lastBid.setText("  Last bid: " + Math.max(newBid.getLastBid(), auction.getPrice()) + "");
                lastBid.setVisible(true);
                lastBidder.setText("  Winner: " + newBid.getLastBidder());
                frame.getContentPane().repaint();
            });
            this.auction.addPropertyChangeListener("strategy", e -> {
                articlePrice.setText("  Price: " + this.auction.getPrice());
                frame.getContentPane().repaint();
            });
            buildFrame();
        }
    }

    public void buildFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = (JPanel) frame.getContentPane();

        articleName.setText("  Article: " + auction.getArticleDescription());
        contentPane.add(articleName);
        articlePrice.setText("  Price: " + auction.getPrice());
        contentPane.add(articlePrice);
        lastBid.setText("  Last bid: " + auction.getLastBid());
        lastBid.setVisible(false); // at the beginning, no bid
        contentPane.add(lastBid);
        lastBidder.setText("  Winner: " + auction.getLastBidder());
        lastBidder.setVisible(false);
        contentPane.add(lastBidder);
        stopButton.setEnabled(true);
        stopButton.addActionListener(new StopListener());
        contentPane.add(stopButton);

        JPanel strategyPane = new JPanel();
        flatButton.addActionListener(new FlatListener());
        batchButton.addActionListener(new BatchListener());
        strategyPane.add(batchButton);
        strategyPane.add(flatButton);
        contentPane.add(strategyPane);

        contentPane.setLayout(new GridLayout(6, 1));

        frame.pack();
        frame.setVisible(true);
    }

    private class StopListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                auction.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class FlatListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                auction.setStrategy(new FlatPrice());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class BatchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                auction.setStrategy(new BatchPrice());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
