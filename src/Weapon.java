package src;

public class Weapon {

    String name;

    String description;
    int damagePlus;
    int levelNeeded;

    Weapon(String name, String description, int damagePlus, int levelNeeded) {

        this.name = name;
        this.description = description;
        this.damagePlus = damagePlus;
        this.levelNeeded = levelNeeded;

    }







    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDamagePlus() {
        return damagePlus;
    }

    public void setDamagePlus(int damagePlus) {
        this.damagePlus = damagePlus;
    }

    public int getLevelNeeded() {
        return levelNeeded;
    }

    public void setLevelNeeded(int levelNeeded) {
        this.levelNeeded = levelNeeded;
    }


}

