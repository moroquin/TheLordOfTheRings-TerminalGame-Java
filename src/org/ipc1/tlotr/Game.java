package org.ipc1.tlotr;

import org.ipc1.tlotr.character.Characters;
import org.ipc1.tlotr.character.beasts.*;
import org.ipc1.tlotr.character.heroes.*;

public class Game {
    private final int NUMBER_CHARACTERRS = 5;

    public void play() {
        Characters[] heroes = new Characters[NUMBER_CHARACTERRS];
        Characters[] beasts = new Characters[NUMBER_CHARACTERRS];
        initCharacters(heroes, 100, 40, false);
        initCharacters(beasts, 100, 40, true);
        printCharacters(heroes, "listado de heroes");
        printCharacters(beasts, "Listado de bestias");
        initBattle(heroes, beasts);
        printCharacters(heroes, "listado de heroes");
        printCharacters(beasts, "Listado de bestias");
        // Characters ch1 = new Elfo(100, 30, "Rene"); // espacio 100
    }

    public void initBattle(Characters[] heroes, Characters[] beasts) {
        System.out.println("INiciando batalla");
        // boolean nextRound = true;
        int posH = 0;
        int posB = 0;
        boolean isBeastAttacking = false;

        do {
            posH = getPosAlive(heroes, posH);
            posB = getPosAlive(beasts, posB);
            if ((posB >= 0) && (posH >= 0)) {
                // pelea
                if (isBeastAttacking) {
                    beasts[posB].attack(heroes[posH]);
                } else {
                    heroes[posH].attack(beasts[posB]);
                }
                
                if (heroes[posH].isAlive() && beasts[posB].isAlive()) {
                    isBeastAttacking = !isBeastAttacking;
                    if (isBeastAttacking) {
                        beasts[posB].attack(heroes[posH]);
                    } else {
                        heroes[posH].attack(beasts[posB]);
                    }
                }

            } else {
                break;
            }

            // terminar la pelea
            posB++;
            if (posB >= beasts.length) {
                posB = getPosAlive(beasts, 0);
                if (posB < 0)
                    break;
            }
            posH++;
            if (posH >= heroes.length) {
                posH = getPosAlive(heroes, 0);
                if (posH < 0)
                    break;
            }
        } while (true);

    }

    public int getPosAlive(Characters[] group, int initPos) {
        do {
            if (group[initPos].isAlive()) {
                return initPos;
            } else {
                initPos++;
            }
        } while (initPos < group.length);
        return -1;
    }

    public void printCharacters(Characters[] group, String title){
        System.out.println("\n\n"+title+"\n");
        for (int i = 0; i < group.length; i++) {
            System.out.println(group[i].toString());
        }
        System.out.println("\n");
    }

    public void initCharacters(Characters[] init, int life, int shield, boolean isBeast) {
        for (int i = 0; i < init.length; i++) {
            // if (isBeast){
            // init[i]=Beasts.newHeroeInstanceRandom(life, shield, i);
            // }
            // else{
            // init[i]=Heroes.newHeroeInstanceRandom(life, shield, i);
            // }
            init[i] = (isBeast) ? Beasts.newHeroeInstanceRandom(life, shield, i)
                    : Heroes.newHeroeInstanceRandom(life, shield, i); // new elfo, new humano, new hobbit
            // System.out.println(init[i].toString());
            // new orco, new trasgo
        }
    }

}
