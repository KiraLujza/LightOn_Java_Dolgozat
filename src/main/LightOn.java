package main;

import modell.LightOnModell;
import nezet.GUI_nezet;
import vezerlo.LightOnVezerlo;

public class LightOn {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            GUI_nezet gui = new GUI_nezet();
            LightOnModell modell = new LightOnModell();
            new LightOnVezerlo(gui, modell);
            gui.setVisible(true);
        });
    }
}
