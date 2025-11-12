
package main;

import nezet.GUI_nezet;

public class LightOn {

  
    public static void main(String[] args) {
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_nezet().setVisible(true);
            }
        });
    }
    
}
