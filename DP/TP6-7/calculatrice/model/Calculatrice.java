package calculatrice.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Calculatrice {

    private int acc;
    private int lastOperation;
    private int digitEnCours;
    private String screenOperation;
    private String screenOperationVertical;
    private final PropertyChangeSupport property;


    public Calculatrice() {
        property = new PropertyChangeSupport(this);
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
        property.firePropertyChange("digitEnCours", null, this.digitEnCours);
        property.firePropertyChange("screenOperation", null, this.screenOperation);
        property.firePropertyChange("stringV", null, this.screenOperationVertical);
    }

    public void setLastOperation(int lastOperation) {
        this.lastOperation = lastOperation;
        property.firePropertyChange("digitEnCours", null, this.digitEnCours);
        property.firePropertyChange("screenOperation", null, this.screenOperation);
        property.firePropertyChange("screenOperationV", null, this.screenOperationVertical);
    }

    public int getDigitEnCours() {
        return digitEnCours;
    }

    public void setDigitEnCours(int digitEnCours) {
        this.digitEnCours = digitEnCours;
        property.firePropertyChange("digitEnCours", null, this.digitEnCours);
        property.firePropertyChange("screenOperation", null, this.screenOperation);
        property.firePropertyChange("screenOperationV", null, this.screenOperationVertical);
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

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        property.addPropertyChangeListener(propertyName, listener);
    }
}
