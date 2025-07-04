package src;

public class Monster {

    private String name = "Monster";

    private int health = 10;

    private int attack = 1;

    private int xpvalue = 5;

    boolean alive = true;

    int level;

    Monster(int level) {
        this.level = level;

        health = health + level * 10;
        attack = attack + level;
        xpvalue = xpvalue + (xpvalue * level);

        switch (level) {
            case 0:
                name = "Skelett";
                break;
            case 1:
                name = "Skelettkrieger";
                break;
            case 2:
                name = "Zombie";
                break;
            case 3:
                name = "Zombiereiter";
                break;
            case 4:
                name = "Leichenfürst";
        }
    }

    public void attack(Hero hero) { hero.takeDamage(this.attack); }

    public void takeDamage(int damage) {
        this.health = this.health - damage;

        if (this.health < 1) {
            this.alive = false;
        }
    }





    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getXpvalue() {
        return xpvalue;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getLevel() {
        return level;
    }

}