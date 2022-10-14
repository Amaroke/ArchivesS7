package calculatrice.controller;

import calculatrice.model.Calculatrice;

import static calculatrice.view.CalculatriceView.*;

public class CalculatriceController {

    final Calculatrice calculatrice;

    public CalculatriceController(Calculatrice calculatrice) {
        this.calculatrice = calculatrice;
    }

    public void plusClick() {
        calculatrice.setScreenOperation(calculatrice.getScreenOperation() == null ? "" : calculatrice.getScreenOperation() + "+");
        calculatrice.setScreenOperationVertical(calculatrice.getScreenOperationVertical() == null ? "" : calculatrice.getScreenOperationVertical() + "\n+\n");
        compute();
        calculatrice.setLastOperation(PLUS);
        calculatrice.setDigitEnCours(0);
    }

    public void minusClick() {
        calculatrice.setScreenOperation(calculatrice.getScreenOperation() == null ? "" : calculatrice.getScreenOperation() + "-");
        calculatrice.setScreenOperationVertical(calculatrice.getScreenOperationVertical() == null ? "" : calculatrice.getScreenOperationVertical() + "\n-\n");
        compute();
        calculatrice.setLastOperation(MINUS);
        calculatrice.setDigitEnCours(0);
    }

    public void equalClick() {
        calculatrice.setScreenOperation(calculatrice.getScreenOperation() == null ? "" : calculatrice.getScreenOperation() + "=");
        calculatrice.setScreenOperationVertical(calculatrice.getScreenOperationVertical() == null ? "" : calculatrice.getScreenOperationVertical() + "\n=\n");
        compute();
        calculatrice.setDigitEnCours(calculatrice.getAcc());
        calculatrice.setScreenOperation(calculatrice.getScreenOperation() == null ? "" : calculatrice.getScreenOperation() + calculatrice.getDigitEnCours());
        calculatrice.setScreenOperationVertical(calculatrice.getScreenOperationVertical() == null ? "" : calculatrice.getScreenOperationVertical() + calculatrice.getDigitEnCours() + "\n");
        calculatrice.setLastOperation(EQUAL);
    }

    public void digitClick(int digit) {
        calculatrice.setScreenOperation(calculatrice.getScreenOperation() == null ? "" + digit : calculatrice.getScreenOperation() + digit);
        calculatrice.setScreenOperationVertical(calculatrice.getScreenOperationVertical() == null ? "" + digit : calculatrice.getScreenOperationVertical() + digit);
        if (calculatrice.getLastOperation() == EQUAL) {
            calculatrice.setDigitEnCours(0);
            calculatrice.setLastOperation(0);
        }
        calculatrice.setDigitEnCours(calculatrice.getDigitEnCours() * 10 + digit);
    }

    public void compute() {
        if (calculatrice.getLastOperation() == MINUS) {
            int res = calculatrice.getAcc() - calculatrice.getDigitEnCours();
            calculatrice.setAcc(res);
        } else if (calculatrice.getLastOperation() == PLUS) {
            int res = calculatrice.getAcc() + calculatrice.getDigitEnCours();
            calculatrice.setAcc(res);
        } else {
            calculatrice.setAcc(calculatrice.getDigitEnCours());
        }
    }
}
