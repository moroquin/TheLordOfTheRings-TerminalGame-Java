package org.ipc1.tlotr.character.heroes;

import org.ipc1.tlotr.character.Characters;
import org.ipc1.tlotr.character.beasts.Trasgo;
import org.ipc1.tlotr.util.Util;

public class Hobbit extends Heroes {
    public Hobbit(int life, int shield, String name) {
        super(life, shield, name);
    }

    @Override
    public int getModAttack(Characters defense) {
        if (defense instanceof Trasgo){
            System.out.println("       Los hobbits se asustaron y atacaran mas suave");
            return -5;
        }
        return 0;
    };


    private static String[] nombres = {"Froddo", "Bilbo","Sam"};
    public static String getRandomName(){
        return Hobbit.nombres[Util.generarNumeroRandom(0, (nombres.length-1))];
    }

    

}
