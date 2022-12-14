package calculatrice.view;

import calculatrice.model.Calculatrice;

import javax.swing.*;

public class CalculatriceHorizontal{

    private final JTextField textField = new JTextField();
    private final Calculatrice calculatrice;

    public CalculatriceHorizontal(Calculatrice calculatrice) {
        this.calculatrice = calculatrice;
        this.calculatrice.addPropertyChangeListener("screenOperation", event -> textField.setText(calculatrice.getScreenOperation()));

        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = (JPanel) frame.getContentPane();

        textField.setColumns(20);
        textField.setText("0");
        textField.setHorizontalAlignment(JTextField.RIGHT);
        JPanel panel = new JPanel();
        panel.add(textField);

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(panel);

        frame.pack();
        frame.setVisible(true);
    }

}
