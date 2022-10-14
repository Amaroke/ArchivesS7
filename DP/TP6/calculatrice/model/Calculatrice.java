package calculatrice.model;

import calculatrice.view.View;

import java.util.ArrayList;

public class Calculatrice {

    private int acc;
    private int lastOperation;
    private int digitEnCours;
    private String screenOperation;
    private String screenOperationVertical;
    private final ArrayList<View> views = new ArrayList<>(3);

    public Calculatrice() {
        acc = 0;
        digitEnCours = 0;
        lastOperation = 0;
    }

    public int getAcc() {
        return acc;
    }

    public int getLastOperation() {
        return lastOperation;
    }

    public void setAcc(int acc) {
        this.acc = acc;
        refreshViews();
    }

    public void setLastOperation(int lastOperation) {
        this.lastOperation = lastOperation;
        refreshViews();
    }

    public int getDigitEnCours() {
        return digitEnCours;
    }

    public void setDigitEnCours(int digitEnCours) {
        this.digitEnCours = digitEnCours;
        refreshViews();
    }

    public void addView(View view) {
        this.views.add(view);
    }

    public void refreshViews() {
        for(View v : this.views) {
            v.refresh();
        }
    }

    public String getScreenOperation() {
        return screenOperation;
    }

    public void setScreenOperation(String screenOperation) {
        this.screenOperation = screenOperation;
    }

    public String getScreenOperationVertical() {
        return screenOperationVertical;
    }

    public void setScreenOperationVertical(String screenOperationVertical) {
        this.screenOperationVertical = screenOperationVertical;
    }
}
