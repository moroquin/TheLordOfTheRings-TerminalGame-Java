package org.ipc1.tlotr.character;

import org.ipc1.tlotr.character.beasts.Beasts;
import org.ipc1.tlotr.character.heroes.Heroes;
import org.ipc1.tlotr.util.Util;

/**
 * Clase abstracat que tiene la base de los personajes para que peleen
 * 
 * @author Oliver Sierra
 * @version 1.0
 * 
 */
public abstract class Characters extends Object {

    // art by Shanaka Dias https://www.asciiart.eu/video-games/creatures
    private static String[][] characterString = { {
            "     _____       ",
            " .-,;='';_),-.   ",
            "  \\_\\(),()/_/    ",
            "    (,___,)      ",
            "   ,-/`~`\\-,___  ",
            "  / /).:.('--._) ",
            " {_[ (_,_)       ",
            "     | Y |       ",
            "    /  |  \\      ",
            "    |  |  |      ",
            "    \"\"\" \"\"\"      "
    }, {
            "       __ __     ",
            "    .-',,^,,'.   ",
            "   / \\(0)(0)/ \\  ",
            "   )/( ,_\"_,)\\(  ",
            "   `  >-`~(   '  ",
            " _N\\ |(`\\ |___   ",
            " \\' |/ \\ \\/_-,)  ",
            "  '.(  \\`\\_<     ",
            "     \\ _\\|       ",
            "      | |_\\_     ",
            "      \\_,_>-'    "
    } };

    private int life;
    private int shield;
    private String name;
    private int attack;
    private int defaultShield;

    /**
     * Único constructor de la clase personajes
     * 
     * @param life   atributo que indica la totalidad de vida del personaje
     * @param shield atributo que indica la magnitud del escudo del personaje
     * @param name   atributo que identifica el nombre del personaje
     */
    public Characters(int life, int shield, String name) {
        super();
        this.life = life;
        this.shield = shield;
        this.name = name;
        this.attack = 0;
        this.defaultShield = shield;
    }

    abstract public int getNumberDice();

    abstract public int getModAttack(Characters defense);

    abstract public int getModDefense(Characters attack);

    /**
     * método que sirve para verificar si el personaje aún respira
     * 
     * @return retorna TRUE si esta vivo, FALSE si esta muerto
     */
    public boolean isAlive() {
        return life > 0;
    }

    public int getAttack() {
        return this.attack;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }

    public void restoreShieldAttack(){
        this.attack = 0;
        this.shield = this.defaultShield;
    }

    public String getClassName(){
        return this.getClass().getSimpleName();
    }


    

    @Override
    public String toString() {
        return "- " + getName() + ": life: " +
                getLife() + ", shield: " + getShield() + ((this.isAlive()) ? ", is alive." : ", is dead.");
    }


    public void preparAttack(Characters p2) {
        int amount = Util.rollDiceNTimesGreaterNumber(this.getNumberDice(), 50, 100, "Preparing the attack of " + this.getName()) + this.getModAttack(p2);
        this.setAttack(amount);
    }

    // this=nicolas p1=oliver
    public void defend(Characters p1) {
        this.setShield(this.getModDefense(p1) + this.getShield());
        if (p1.getAttack() > this.getShield()) {
            int damage = p1.getAttack() - this.getShield();
            this.life -= damage;
            if (this.life < 0) {
                this.life = 0;
            }
            System.out.println("     " + p1.getName() + "'s attack was successful. " + this.getName()
                    + " recieve "+ damage +" damage, and ended up with " + this.getLife() + " life.");
        } else {
            System.out.println("     " + p1.getName()+"'s attack was completely block by "+this.getName());
        }
        
        

    }

    public int getLife() {
        return this.life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getShield() {
        return this.shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void fight(Characters attacker, Characters defender){
        System.out.println("\n\n*****    Initiating fight    *****\n");
        printTwoCharacters(attacker, defender);
        attacker.preparAttack(defender);
        defender.defend(attacker);
        System.out.println("\n");
        Util.requestEnter("Press to see results");
        printTwoCharacters(attacker, defender);
        attacker.restoreShieldAttack();
        defender.restoreShieldAttack();
        Util.requestEnter("\n*****    Fight Ended    *****\nPress enter to continiue\n");
        System.out.println();

    }

    public static void printTwoCharacters(Characters char1, Characters char2) {
        String spaceBetween =    "           ";
        String spaceBetweenVrs = "    VRS    ";
        int pos1 = (char1 instanceof Heroes)?1:0;
        int pos2 = (char1 instanceof Beasts)?1:0;
        for (int i = 0; i < characterString[0].length; i++) {
            System.out.println(Characters.characterString[pos1][i] + spaceBetween + Characters.characterString[pos2][i]);
        }
        System.out.println(Util.fixStringLength(17, "Attacker") + spaceBetween
                + Util.fixStringLength(17, "Defender"));
        System.out.println(
                Util.fixStringLength(17, char1.getName()) + spaceBetweenVrs + Util.fixStringLength(17, char2.getName()));
        System.out.println(Util.fixStringLength(17, char1.getClassName()) + spaceBetween
                + Util.fixStringLength(17, char2.getClassName()));
        System.out.println(Util.fixStringLength(17, "Life: " + char1.getLife()) + spaceBetween
                + Util.fixStringLength(17, "Life: " + char2.getLife()));
        System.out.println(Util.fixStringLength(17, "Shield: " + char1.getShield()) + spaceBetween
                + Util.fixStringLength(17, "Shield: " + char2.getShield()));
        System.out.println(Util.fixStringLength(17,
                "Attack: " + ((char1.getAttack() == 0) ? " not set" : char1.getAttack())) + spaceBetween
                + Util.fixStringLength(17, "Attack: " + ((char2.getAttack() == 0) ? " not set" : char2.getAttack())));
    }


    public static void printTwoCharactersTeam(Characters[] char1, Characters[] char2, boolean firstWon) {
        String spaceBetween =    "           ";
        String spaceBetweenVrs = "    VRS    ";
        int pos1 = (char1[0] instanceof Heroes)?1:0;
        int pos2 = (char1[0] instanceof Beasts)?1:0;
        for (int i = 0; i < characterString[0].length; i++) {
            System.out.println(Characters.characterString[pos1][i] + spaceBetween + Characters.characterString[pos2][i]);
        }
        System.out.println(Util.fixStringLength(17, (firstWon?"WINNERS":"LOSERS")) + spaceBetween
                + Util.fixStringLength(17, (firstWon?"LOSERS":"WINNERS")));
        for (int j = 0; j < char2.length; j++) {
            System.out.println(
                Util.fixStringLength(17, char1[j].getName()+((char1[j].isAlive()?"-alive":"-dead"))) 
                + spaceBetweenVrs + 
                Util.fixStringLength(17, char2[j].getName()+((char2[j].isAlive()?"-alive":"-dead"))));
        }
    }
}
