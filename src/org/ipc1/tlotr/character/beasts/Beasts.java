package org.ipc1.tlotr.character.beasts;

import org.ipc1.tlotr.character.Characters;
import org.ipc1.tlotr.util.Util;

/**
 * Clase principal de las bestias 
 */
public abstract class Beasts extends Characters {

    public Beasts(int life, int shield, String name) {
        super(life, shield, name);
    }

    @Override
    public int getNumberDice(){
        return 1;
    }

    public static Characters newHeroeInstanceRandom(int life, int shield, int number){
        Characters res = null;
        int tipoHeroe = Util.generarNumeroRandom(1, 2);
        // System.out.println(" vamos a una instancia de "+tipoHeroe);

        switch (tipoHeroe) {
            case 1:
                //Orco
                return (Characters) (new Orco(life, shield, "Orco "+number ));
            case 2:
                //hobbit
                return (Characters) (new Trasgo(life, shield, "Trasgo "+number ));
        }
        return res;
    }

}
