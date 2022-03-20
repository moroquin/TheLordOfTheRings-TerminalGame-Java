package org.ipc1.tlotr.character.heroes;

import org.ipc1.tlotr.character.Characters;
import org.ipc1.tlotr.character.beasts.Orco;
import org.ipc1.tlotr.util.Util;

abstract public class Heroes extends Characters {
  
    public Heroes(int life, int shield, String name) {
        super(life, shield, name);
    }

    @Override
    public int getNumberDice(){
        return 2;
    }

    @Override
    public int getModDefense(Characters attack) {
        if (attack instanceof Orco){
            System.out.println("         Se asusto el "+this.getClass().getSimpleName()+" y disminuyo su armadura");
            return -10;
        }
        return 0;
    };

    public static Characters newHeroeInstanceRandom(int life, int shield, int number){
        Characters res = null;
        int tipoHeroe = Util.generarNumeroRandom(1, 3);
        // System.out.println(" vamos a una instancia de "+tipoHeroe);

        switch (tipoHeroe) {
            case 1:
                //Elfo
                return (Characters) (new Elfo(life, shield, Elfo.getRandomName()+number));
            case 2:
                //hobbit
                return (Characters) (new Hobbit(life, shield, Hobbit.getRandomName()+number ));
            case 3:
                //Humanos
                return (Characters) (new Humanos(life, shield, Humanos.getRandomName()+number ));
        }

        return res;
    }
    
}
