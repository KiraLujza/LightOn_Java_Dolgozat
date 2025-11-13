package vezerlo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modell.LightOnModell;
import nezet.GUI_nezet;

public class LightOnVezerlo {

    private GUI_nezet nezet;
    private LightOnModell modell;

    public LightOnVezerlo(GUI_nezet nezet, LightOnModell modell) {
        this.nezet = nezet;
        this.modell = modell;
        init();
    }

    private void init() {
        JButton[] gombok = {
            nezet.getBtn1(), nezet.getBtn2(), nezet.getBtn3(),
            nezet.getBtn4(), nezet.getBtn5(), nezet.getBtn6(),
            nezet.getBtn7(), nezet.getBtn8(), nezet.getBtn9()
        };
        nezet.getMnuSzabalyok().addActionListener(e -> szabalyok());
        nezet.getMnuAllapotMent().addActionListener(e -> mentes());
        nezet.getMnuBetolt().addActionListener(e -> betoltes());

        for (int i = 0; i < gombok.length; i++) {
            final int index = i;
            gombok[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    modell.kapcsol(index);
                    frissitNezet();
                }
            });
        }

        nezet.getBtnUjJatek().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modell.ujJatek();
                frissitNezet();
            }
        });

        frissitNezet();
    }

    private void szabalyok() {
        String szabaly = "A játék célja, hogy minden lámpa kikapcsolt legyen.\n"
                + "A lámpa megnyomásakor az oldalait érintő lámpák is változnak (felkapcsoltból lekapcsolt, és fordítva).\n"
                + "A játék akkor ér véget, ha az összes lámpa kikapcsolt.\n"
                + "Jó játékot!!!";

        JOptionPane.showMessageDialog(nezet, szabaly);
    }

    private void mentes() {
        try (PrintWriter pw = new PrintWriter("allapot.txt")) {
            boolean[] lampak = modell.getLampak(); 
            for (boolean lampa : lampak) {
                pw.println(lampa);
            }
            JOptionPane.showMessageDialog(nezet, "Állapot elmentve!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(nezet, "Hiba a mentés során!");
        }
    }

    private void betoltes() {
        try (Scanner sc = new Scanner(new File("allapot.txt"))) {
            boolean[] ujLampak = new boolean[9];
            int i = 0;
            while (sc.hasNextBoolean() && i < ujLampak.length) {
                ujLampak[i] = sc.nextBoolean();
                i++;
            }
            modell.setLampak(ujLampak); 
            frissitNezet();
            JOptionPane.showMessageDialog(nezet, "Állapot betöltve!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(nezet, "Hiba a betöltés során!");
        }
    }

    private void frissitNezet() {
        JButton[] gombok = {
            nezet.getBtn1(), nezet.getBtn2(), nezet.getBtn3(),
            nezet.getBtn4(), nezet.getBtn5(), nezet.getBtn6(),
            nezet.getBtn7(), nezet.getBtn8(), nezet.getBtn9()
        };

        boolean[] lampak = modell.getLampak();

        for (int i = 0; i < gombok.length; i++) {
            if (lampak[i]) {
                gombok[i].setBackground(Color.YELLOW);
            } else {
                gombok[i].setBackground(new Color(204, 153, 255));
            }
        }
    }
}
