package teszt;

import modell.LightOnModell;

public class LightOnTeszt {

    public static void main(String[] args) {
        LightOnModell modell = new LightOnModell();

        tesztMeret(modell);
        tesztUjJatekVanFelkapcsolt(modell);
        tesztSetLampakMukodik(modell);
        tesztMindenKikapcsolt(modell);

        System.out.println("Minden teszt sikeresen lefutott!");
    }

    private static void tesztMeret(LightOnModell modell) {
        assert modell.getLampak().length == 9 : "A pálya mérete hibás (nem 3x3).";
    }

    private static void tesztUjJatekVanFelkapcsolt(LightOnModell modell) {
        modell.ujJatek();
        boolean vanFelkapcsolt = false;
        for (boolean l : modell.getLampak()) {
            if (l) {
                vanFelkapcsolt = true;
                break;
            }
        }
        assert vanFelkapcsolt : "Új játék után legalább egy lámpának égve kell lennie.";
    }

    private static void tesztSetLampakMukodik(LightOnModell modell) {
        boolean[] ujLampak = {true, false, true, false, true, false, true, false, true};
        modell.setLampak(ujLampak);
        assert modell.getLampak()[0] && !modell.getLampak()[1] : "setLampak nem működik megfelelően.";
    }

    private static void tesztMindenKikapcsolt(LightOnModell modell) {
        boolean[] mindenKi = new boolean[9];
        modell.setLampak(mindenKi);
        boolean mindKi = true;
        for (boolean b : modell.getLampak()) {
            if (b) {
                mindKi = false;
            }
        }
        assert mindKi : "Nem minden lámpa kikapcsolt, pedig annak kellene.";
    }

}
