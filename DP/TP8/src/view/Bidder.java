/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import auction.Auction;
import auction.Bid;

/**
 *
 * @author cirstea
 */
public class Bidder {
	/*

	private JFrame frame = new JFrame("Bidder");
	private JTextField textField = new JTextField();
	private JButton bidButton = new JButton("Bid");
	private JTextArea articleName = new JTextArea("Article: ");
	private JLabel articlePrice = new JLabel("Price: ");
	private JLabel lastBid = new JLabel("Last bid: ");
	private JLabel bidderLabel = new JLabel("Bidder: ");

	private Auction auction;
	private String bidder;

	public Bidder(Auction auction, String bidder) {
		if (auction.getNumberComponents() > 0) {

			this.auction = auction;
			this.bidder = bidder;
			this.auction.addPropertyChangeListener("close", e -> {
				bidButton.setEnabled(false);
				articleName.setText(" Article: " + auction.getArticleDescription());
				frame.getContentPane().repaint();
			});
			this.auction.addPropertyChangeListener("bid", e -> {
				Bid newBid = (Bid) e.getNewValue();
				lastBid.setText("  Last bid: " + newBid.getLastBid());
				lastBid.setVisible(true);
				textField.setText(Math.max(newBid.getLastBid(), auction.getPrice()) + 1 + "");
				bidButton.setEnabled(true);
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
		bidderLabel.setText("  Bidder: " + bidder);
		contentPane.add(bidderLabel);
		articleName.setText(
				"  Article: " + auction.getArticleDescription() + " \n " + auction.getNumberComponents() + " pieces");
		contentPane.add(articleName);
		articlePrice.setText("  Price: " + auction.getPrice());
		contentPane.add(articlePrice);
		lastBid.setText("  Last bid: " + auction.getLastBid());
		lastBid.setVisible(false); // at the beginning, no bid
		contentPane.add(lastBid);
		textField.setColumns(5);
		textField.setText(Math.max(auction.getLastBid(), auction.getPrice()) + 1 + "");
		textField.setHorizontalAlignment(JTextField.RIGHT);
		contentPane.add(textField);
		if (!auction.isOpen()) {
			bidButton.setEnabled(false);
		}
		bidButton.addActionListener(new BidListener(bidder));
		contentPane.add(bidButton);
		contentPane.setLayout(new GridLayout(6, 1));

		frame.pack();
		frame.setVisible(true);
	}

	private class BidListener implements ActionListener {
		private String bidder;

		public BidListener(String bidder) {
			this.bidder = bidder;
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			auction.bid(Float.parseFloat(textField.getText()), this.bidder);
		}
	}
	 */
}
