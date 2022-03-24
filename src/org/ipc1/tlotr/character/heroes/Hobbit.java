package org.ipc1.tlotr.character.heroes;

import org.ipc1.tlotr.character.Characters;
import org.ipc1.tlotr.character.beasts.Goblins;
import org.ipc1.tlotr.util.Util;

public class Hobbit extends Heroes {
    public Hobbit(int life, int shield, String name) {
        super(life, shield, name);
    }

    @Override
    public int getModAttack(Characters defense) {
        if (defense instanceof Goblins){
            System.out.println("       The hobbits were frightened of the goblins and attacked more softly. -5");
            return -5;
        }
        return 0;
    };


    private static String[] nombres = {"Froddo", "Bilbo","Sam"};
    public static String getRandomName(){
        return Hobbit.nombres[Util.generateRandomNumber(0, (nombres.length-1))];
    }

    

}
