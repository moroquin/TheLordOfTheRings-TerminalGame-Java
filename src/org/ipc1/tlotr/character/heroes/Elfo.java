package org.ipc1.tlotr.character.heroes;

import org.ipc1.tlotr.character.Characters;
import org.ipc1.tlotr.character.beasts.Orco;
import org.ipc1.tlotr.util.Util;

public class Elfo extends Heroes {
    public Elfo(int life, int shield, String name) {
        super(life, shield, name);
    }

    @Override
    public int getModAttack(Characters defense) {
        if (defense instanceof Orco) {
            System.out.println("      Los elfos odian a los orcos por lo tanto aumenta su poder de ataque");
            return 10;
        }
        return 0;
    };

    private static String[] nombres = { "Legolas", "Bladimir" };

    public static String getRandomName() {
        return Elfo.nombres[Util.generarNumeroRandom(0, (nombres.length - 1))];
    }
}
