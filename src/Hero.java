package src;

import java.util.Random;

public class Hero {

    private String name;

    private String icon;
    private int health = 40;
    private int attack = 1;

    private int xppoints = 0;

    private int level = 0;

    private int mana = 10;
    private int maxMana = 20;

    private boolean magicOn = false;

    Weapon weapon;

    Hero(String name, String icon, Weapon weapon) {
        this.name = name;
        this.icon = icon;
        this.weapon = weapon;
    }

    // Die Angriffsmethode addiert Attack-Wert des Helden, Bonus durch die Waffe und bis zu 2 zufallsgenerierte Punkte.

    public int attack(Monster monster) {

        Random rand = new Random();
        int randomExtraDamage = rand.nextInt(0, 3);
        int damage = (attack + weapon.getDamagePlus() + randomExtraDamage);
        // Print.out("\uD83D\uDDE1\uFE0F - Der Angriff von " + name + " mit " + weapon.getName() + " macht" + damage + " Schaden");

        return damage;
    }

    public int calculatemagicAttack(Monster monster) {

        int manaCost = 10 - (level / 2);
        if (manaCost < 2) manaCost = 2;

        if (mana < manaCost) {
            Print.out("Nicht genug Mana für einen Zauberangriff!");
            return 0;
        }

        else {

        }

        Random rand = new Random();
        int randomMagicPower = rand.nextInt(0, level*2);
        int damage = (randomMagicPower + level);

        mana = mana - manaCost;
        Print.out("✨ - Der Zauberangriff von " + name + " kostet " + manaCost + " und macht " + damage + " Schaden");
        return damage;

    }


    public void takeDamage(int damage) {
        this.health = this.health - damage;

        if (this.health < 1) {
            Print.out("☠\uFE0F Unser Held ist tot - Spiel verloren!");
            Main.gameActive = false;
        }
    }





























    // Getter und Setter

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getXppoints() {
        return xppoints;
    }

    public void setXppoints(int xppoints) {
        this.xppoints = xppoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public boolean isMagicOn() {
        return magicOn;
    }

    public String isMagicOnAsAString() {
        if (magicOn) return "Zauberangriff";
        else return "Nahakampfangriff";
    }

    public void setMagicOn(boolean magicOn) {
        this.magicOn = magicOn;
    }
}

