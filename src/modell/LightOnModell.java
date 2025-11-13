package modell;

import java.util.Random;

public class LightOnModell {

    private boolean[] lampak; // 3x3 rács => 9 elem
    private final int MERET = 3; // a tábla mérete (3x3)
    private Random rnd = new Random();

    public LightOnModell() {
        ujJatek();
    }

    public void ujJatek() {
        lampak = new boolean[MERET * MERET];
        for (int i = 0; i < lampak.length; i++) {
            lampak[i] = false;
        }

        // véletlenül egy lámpa felkapcsolva
        int index = rnd.nextInt(lampak.length);
        lampak[index] = true;
    }

    public boolean getLampaAllapot(int index) {
        return lampak[index];
    }

    public boolean[] getLampak() {
        return lampak;
    }

    public void kapcsol(int index) {
        int sor = index / MERET;
        int oszlop = index % MERET;

        // az adott lámpa váltása
        valt(index);

        // bal oldali
        if (oszlop > 0) {
            valt(index - 1);
        }

        // jobb oldali
        if (oszlop < MERET - 1) {
            valt(index + 1);
        }

        // fölötte
        if (sor > 0) {
            valt(index - MERET);
        }

        // alatta
        if (sor < MERET - 1) {
            valt(index + MERET);
        }
    }

    private void valt(int index) {
        lampak[index] = !lampak[index];
    }
}
