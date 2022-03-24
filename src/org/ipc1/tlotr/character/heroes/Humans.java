package org.ipc1.tlotr.character.heroes;

import org.ipc1.tlotr.character.Characters;
import org.ipc1.tlotr.util.Util;

public class Humans extends Heroes {
    public Humans(int life, int shield, String name) {
        super(life, shield, name);
    }

    @Override
    public int getModAttack(Characters defense){
        return 0;
    };


    private static String[] nombres = {"Aragon", "Baramir"};
    public static String getRandomName(){
        return Humans.nombres[Util.generateRandomNumber(0, (nombres.length-1))];
    }
  
}
