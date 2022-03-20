package org.ipc1.tlotr.character;

import org.ipc1.tlotr.util.Util;

/**
 * Clase abstracat que tiene la base de los personajes para que peleen
 * @author Oliver Sierra
 * @version 1.0
 * 
 */
public abstract class Characters extends Object {

    private int life;
    private int shield;
    private String name;

    /**
     * Único constructor de la clase personajes
     * @param life atributo que indica la totalidad de vida del personaje
     * @param shield atributo que indica la magnitud del escudo del personaje
     * @param name atributo que identifica el nombre del personaje
     */
    public Characters(int life, int shield, String name) {
        super();
        this.life = life;
        this.shield = shield;
        this.name = name;
    }

    abstract public int getNumberDice();

    abstract public int getModAttack(Characters defense);

    abstract public int getModDefense(Characters attack);

    /**
     * método que sirve para verificar si el personaje aún respira
     * @return retorna TRUE si esta vivo, FALSE si esta muerto
     */
    public boolean isAlive() {
        return life > 0;
    }

     
    
    @Override
    public String toString() {
        return "El personaje " + getName() + " tiene vida " +
                getLife() + " y un escudo de " + getShield() + ((this.isAlive()) ? " esta vivo " : " esta muerto");
    }

    // this = oliver
    public void attack(Characters p2) {
        // p2 = nicolas
        System.out.println("********Inicia la pelea");
        System.out.println("              " + this.getName() + " ataca a " + p2.getName());
        int amount = this.getModAttack(p2)
                + Util.tirarDadosNumeroMayor(this.getNumberDice(), 50, 100, "Ataque de " + this.getName());
        // random para el ataque de dos dados
        // verificar modificadores de ataque
        // nicolas.defend(oliver,5);
        p2.defend(this, amount);

        System.out.println("Termino el ataque");
        System.out.println("Atacante: " + this.toString());
        System.out.println("Defensor: " + p2.toString());

    }

    // this=nicolas p1=oliver
    public void defend(Characters p1, int attackAmount) {
        int modDefense = this.getModDefense(p1) + this.getShield();
        System.out.println("                      escudo " + modDefense);
        if (attackAmount > modDefense) {

            life -= (attackAmount - modDefense);
            if (life < 0) {
                life = 0;
            }
            System.out.println("El ataque de " + p1.getName() + " fue éxitoso y " + this.getName()
                    + " recibio daño y termino con " + this.getLife() + "de vida.");
        } else {
            System.out.println("El ataque fue bloqueado completamente.");
        }
        // modificador para la defensa
        System.out.println("              " + this.getName() + " se defiende de " + p1.getName());

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
}
