package calculatrice.view;

import calculatrice.model.Calculatrice;

import javax.swing.*;

public class CalculatriceVertical implements View {

    private final JTextArea textArea = new JTextArea();
    private final Calculatrice calculatrice;

    public CalculatriceVertical(Calculatrice calculatrice) {
        this.calculatrice = calculatrice;
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = (JPanel) frame.getContentPane();

        textArea.setRows(20);
        textArea.setColumns(5);
        textArea.setText("0");
        JPanel panel = new JPanel();
        panel.add(textArea);

        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void refresh() {
        textArea.setText(calculatrice.getScreenOperationVertical());
    }
}
