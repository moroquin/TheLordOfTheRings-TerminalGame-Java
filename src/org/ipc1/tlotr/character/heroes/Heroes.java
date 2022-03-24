package org.ipc1.tlotr.character.heroes;

import org.ipc1.tlotr.character.Characters;
import org.ipc1.tlotr.character.beasts.Orcs;
import org.ipc1.tlotr.util.Util;

abstract public class Heroes extends Characters {

    

    public Heroes(int life, int shield, String name) {
        super(life, shield, name);
    }

    @Override
    public int getNumberDice() {
        return 2;
    }

    @Override
    public int getModDefense(Characters attack) {
        if (attack instanceof Orcs) {
            System.out.println("       Heroe was frightened by the orc and lowered his shield. -10");
            return -10;
        }
        return 0;
    };

    public static Characters newInstanceRandom(int life, int shield, int number) {
        Characters res = null;
        int tipoHeroe = Util.generateRandomNumber(1, 3);
        // System.out.println(" vamos a una instancia de "+tipoHeroe);

        switch (tipoHeroe) {
            case 1:
                // Elfo
                return (Characters) (new Elves(life, shield, Elves.getRandomName() +" "+ number));
            case 2:
                // hobbit
                return (Characters) (new Hobbit(life, shield, Hobbit.getRandomName() +" "+ number));
            case 3:
                // Humanos
                return (Characters) (new Humans(life, shield, Humans.getRandomName() +" "+ number));
        }

        return res;
    }

}
