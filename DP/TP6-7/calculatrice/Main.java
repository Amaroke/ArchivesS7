package calculatrice;

import calculatrice.controller.CalculatriceController;
import calculatrice.model.Calculatrice;
import calculatrice.view.CalculatriceVertical;
import calculatrice.view.CalculatriceHorizontal;
import calculatrice.view.CalculatriceView;

public class Main {
    public static void main(String[] args) {
        Calculatrice calculatrice = new Calculatrice();
        CalculatriceController calculatriceController = new CalculatriceController(calculatrice);
        CalculatriceView v1 = new CalculatriceView(calculatrice, calculatriceController);
        CalculatriceVertical v2 = new CalculatriceVertical(calculatrice);
        CalculatriceHorizontal v3 = new CalculatriceHorizontal(calculatrice);
    }
}
