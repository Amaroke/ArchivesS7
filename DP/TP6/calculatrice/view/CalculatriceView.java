package calculatrice.view;

import calculatrice.controller.CalculatriceController;
import calculatrice.model.Calculatrice;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatriceView implements View {

    public static final int PLUS = -100;
    public static final int MINUS = -200;
    public static final int EQUAL = -400;
    private final JFrame frame = new JFrame("Calculator");
    private final JPanel[] panels = new JPanel[6];
    private final JTextField textField = new JTextField();
    private final JButton[] numberButtons = new JButton[10];
    private final JButton subtractButton = new JButton("-");
    private final JButton addButton = new JButton("+");
    private final JButton equateButton = new JButton(" = ");

    private final Calculatrice calculatrice;
    private final CalculatriceController calculatriceController;

    public CalculatriceView(Calculatrice calculatrice, CalculatriceController calculatriceController) {
        this.calculatrice = calculatrice;
        this.calculatriceController = calculatriceController;
        buildFrame();
    }

    public void buildFrame() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = (JPanel) frame.getContentPane();

        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
        }

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(" " + i + " ");
            numberButtons[i].addActionListener(new CalculatriceView.LocalListener(i));
        }

        textField.setColumns(20);
        textField.setText("0");
        textField.setHorizontalAlignment(JTextField.RIGHT);
        panels[0].add(textField);

        panels[1].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[1].add(numberButtons[7]);
        panels[1].add(numberButtons[8]);
        panels[1].add(numberButtons[9]);
        panels[1].add(addButton);
        addButton.addActionListener(new CalculatriceView.LocalListener(PLUS));

        panels[2].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[2].add(numberButtons[4]);
        panels[2].add(numberButtons[5]);
        panels[2].add(numberButtons[6]);
        panels[2].add(subtractButton);
        subtractButton.addActionListener(new CalculatriceView.LocalListener(MINUS));

        panels[3].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[3].add(numberButtons[1]);
        panels[3].add(numberButtons[2]);
        panels[3].add(numberButtons[3]);
        panels[3].add(equateButton);
        equateButton.addActionListener(new CalculatriceView.LocalListener(EQUAL));

        panels[4].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[4].add(numberButtons[0]);

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        for (JPanel jPanel : panels) {
            contentPane.add(jPanel);
        }

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void refresh() {
        textField.setText(calculatrice.getDigitEnCours() == 0 ? "" : String.valueOf(calculatrice.getDigitEnCours()));
    }

    class LocalListener implements ActionListener {

        private final int digit;

        public LocalListener(int digit) {
            this.digit = digit;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (digit) {
                case PLUS -> calculatriceController.plusClick();
                case MINUS -> calculatriceController.minusClick();
                case EQUAL -> calculatriceController.equalClick();
                default -> calculatriceController.digitClick(digit);
            }
        }
    }
}
