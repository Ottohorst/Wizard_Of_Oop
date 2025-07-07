package src;

public class Monster {

    private String name = "Monster";

    private String icon;

    private int health = 10;

    private int attack = 1;

    private int xpvalue = 5;

    boolean alive = true;

    int level;

    Monster(int level) {
        this.level = level;
        health = health + level * 5;
        attack = attack + level;
        xpvalue = xpvalue + (xpvalue * level);

        switch (level) {
            case 0:
                name = "Skelett";
                icon = S.SKELETON;
                break;
            case 1:
                name = "Zombie";
                icon = S.ZOMBIE;
                break;
            case 2:
                name = "Skelettkrieger";
                icon = S.SKELETON;
                break;
            case 3:
                name = "Skelettritter";
                icon = S.SKELETON;
                break;
            case 4:
                name = "Zombiereiter";
                icon = S.ZOMBIE;
            case 5:
                name = "Skorpion";
                icon = S.SKORPION;
                break;
            case 6:
                name = "Drachenjunges";
                icon = S.SMALLDRAGON;
            case 7:
                name = "Teufel";
                icon = S.DEVIL;
            case 8:
                name = "Teufelin";
                icon = S.DEVIL;
            case 9:
                name = "Drache";
                icon = S.BIGDRAGON;
            case 12:
                name = "Königsdrache";
                icon = S.BIGDRAGON;
                case 20:
                name = "Rachnow der Vampirfürst";
                icon = S.VAMPIRE;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}