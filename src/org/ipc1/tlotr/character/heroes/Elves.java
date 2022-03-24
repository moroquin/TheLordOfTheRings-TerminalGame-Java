package org.ipc1.tlotr.character.heroes;

import org.ipc1.tlotr.character.Characters;
import org.ipc1.tlotr.character.beasts.Orcs;
import org.ipc1.tlotr.util.Util;

public class Elves extends Heroes {
    public Elves(int life, int shield, String name) {
        super(life, shield, name);
    }

    @Override
    public int getModAttack(Characters defense) {
        if (defense instanceof Orcs) {
            System.out.println("      Elves hate orcs so their attack power increases. +10");
            return 10;
        }
        return 0;
    };

    private static String[] nombres = { "Legolas", "Bladimir" };

    public static String getRandomName() {
        return Elves.nombres[Util.generateRandomNumber(0, (nombres.length - 1))];
    }
}
