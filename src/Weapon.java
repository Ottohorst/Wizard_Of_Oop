package src;

public class Weapon {

    String name;
    String description;


    String icon;
    int damagePlus;
    int levelNeeded;

    Weapon(String name, String icon, String description, int damagePlus, int levelNeeded) {

        this.name = name;
        this.icon = icon;
        this.description = description;
        this.damagePlus = damagePlus;
        this.levelNeeded = levelNeeded;

    }








    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

