package modell;

import java.util.Random;

public class LightOnModell {

    private boolean[] lampak;
    private final int MERET = 3;
    private Random rnd = new Random();

    public LightOnModell() {
        ujJatek();
    }

    public void ujJatek() {
        lampak = new boolean[MERET * MERET];
        for (int i = 0; i < lampak.length; i++) {
            lampak[i] = false;
        }

        int index = rnd.nextInt(lampak.length);
        lampak[index] = true;
    }

    public boolean getLampaAllapot(int index) {
        return lampak[index];
    }

    public boolean[] getLampak() {
        return lampak;
    }

    public void setLampak(boolean[] ujLampak) {
        this.lampak = ujLampak;
    }

    public void kapcsol(int index) {
        int sor = index / MERET;
        int oszlop = index % MERET;

        valt(index);

        if (oszlop > 0) {
            valt(index - 1);
        }

        if (oszlop < MERET - 1) {
            valt(index + 1);
        }

        if (sor > 0) {
            valt(index - MERET);
        }

        if (sor < MERET - 1) {
            valt(index + MERET);
        }
    }

    private void valt(int index) {
        lampak[index] = !lampak[index];
    }
}
