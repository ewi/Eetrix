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

    /**
     * Main class for starting program.
     * @param args default variable.
     */
    public static void main(String[] args) {
        EetrixUI ui = new EetrixUI();
        
        GameArea ga = new GameArea(11, 21);

        Controller eetrixController = new Controller(ui, ga);
        ui.setTitle("Eetrix");
        ui.setSize(310, 310);
        ui.setVisible(true);
    }
}
