package org.ipc1.tlotr.character.beasts;

import org.ipc1.tlotr.character.Characters;

public class Orco extends Beasts {
    public Orco(int life, int shield, String name) {
        super(life, shield, name);
    }

    @Override
    public int getModAttack(Characters defense){
        return 0;
    };
    
    @Override
    public int getModDefense(Characters attack){
        return 0;
    };
}
