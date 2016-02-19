package fi.ewi.eetrix.main;

import fi.ewi.eetrix.core.*;
import fi.ewi.eetrix.ui.*;
import fi.ewi.eetrix.mvccontroller.*;

/**
 * Main class for Eetrix.
 *
 * @author ewi
 */
public class Eetrix {

    public static void main(String[] args) {
        EetrixUI ui = new EetrixUI();
        GameControl gc = new GameControl();

        Controller eetrixController = new Controller(ui, gc);
        ui.setTitle("Eetrix");
        ui.setSize(300, 300);
        ui.setVisible(true);
    }
}
