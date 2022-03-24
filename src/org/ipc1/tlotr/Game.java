package org.ipc1.tlotr;

import org.ipc1.tlotr.character.Characters;
import org.ipc1.tlotr.character.beasts.*;
import org.ipc1.tlotr.character.heroes.*;
import org.ipc1.tlotr.util.Util;

public class Game {
    private final int NUMBER_CHARACTERRS = 5;

    public void play() {

        System.out.println("Welcome to the Lord of the Rings console game");
        System.out.println("You are going to see a battle between heroes and beasts\n");
        Util.requestEnter("Press enter to init the battle");
        
        //Characters.fight(Heroes.newInstanceRandom(280, 30, 5), Beasts.newInstanceRandom(250, 40, 5));
        Characters[] heroes = new Characters[NUMBER_CHARACTERRS];
        Characters[] beasts = new Characters[NUMBER_CHARACTERRS];
        System.out.println("Initiating the characters");
        initCharacters(heroes, 100, 40, false);
        initCharacters(beasts, 120, 50, true);
        printCharacters(heroes, "List of Heroes");
        printCharacters(beasts, "List of Beasts");
        Util.requestEnter("Press enter to continue");
        battle(heroes, beasts);
        System.out.println("Battle result");
        printCharacters(heroes, "List of Heroes");
        printCharacters(beasts, "List of Beasts");
        Characters.printTwoCharactersTeam(heroes, beasts, (getPosAlive(heroes, 0)>=0));
        Util.requestEnter("Press enter to continue");
    }

    public void battle(Characters[] heroes, Characters[] beasts){
        System.out.println("\n\nRolling the dice to select which team to attack first");
        boolean beastFirst = Util.generateRandomNumber(0, 1)==0;
        System.out.println("The "+(beastFirst?"BEASTS":"HERORES")+" team attack first.\n");
        Util.requestEnter("Press enter to continue.");

        int posH = 0;
        int posB = 0;
        while (true) {
            posH = getPosAlive(heroes, posH);
            posB = getPosAlive(beasts, posB);

            if ((posH>=0)&&(posB>=0)){
                if (beastFirst){
                    fightRound(beasts[posB], heroes[posH]);
                }
                else{
                    fightRound(heroes[posH], beasts[posB]);
                }
                posB++;
                posH++;
            }
            else{
                System.out.println("\n********* The battle is over");
                break;
            }
            
        }

    }

    private void fightRound(Characters ch1, Characters ch2){
        System.out.println("\n********************** ROUND **********************\n");
        Characters.fight(ch1, ch2);
        if (ch2.isAlive()){
            Characters.fight(ch2, ch1);
        }
        else{
            System.out.println("          "+ch2.getName() + " can not attack, because is dead. ");
        }
        System.out.println("\n********************** END OF ROUND **********************\n");
    }

    public int getPosAlive(Characters[] group, int initPos) {
        int tmpPos = initPos;
        do {
            if ((tmpPos >= group.length)){
                if (initPos>0){
                    tmpPos = 0;
                }
                else{
                    break;
                }
            }
            

            if (group[tmpPos].isAlive()) {
                return tmpPos;
            } else {
                tmpPos++;
            }

            
        } while (tmpPos != initPos);
        return -1;
    }

    public void printCharacters(Characters[] group, String title){
        System.out.println("\n"+title+"\n");
        for (int i = 0; i < group.length; i++) {
            System.out.println(group[i].toString());
        }
    }

    public void initCharacters(Characters[] init, int life, int shield, boolean isBeast) {
        for (int i = 0; i < init.length; i++) {
            init[i] = (isBeast) ? Beasts.newInstanceRandom(life, shield, i)
                    : Heroes.newInstanceRandom(life, shield, i); 
        }
    }

}
