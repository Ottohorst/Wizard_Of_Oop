package src;

import java.util.Random;

public interface AttackStrategy {

    abstract int attack(Hero hero);

}

class MeleeAttack implements AttackStrategy {

    // Normale Attacke - Festgelegter Wert
    @Override
    public int attack(Hero hero) {
        Random rand = new Random();
        int randomExtraDamage = rand.nextInt(0, 2);
        int damage = (hero.getAttack() + hero.weapon.getDamagePlus() + randomExtraDamage);
        Print.out("\uD83D\uDDE1\uFE0F - Der Angriff von " + hero.getName() + " mit " + hero.weapon.getName() + " macht" + damage + " Schaden");
        return damage;
    }
}

class MagicAttack implements AttackStrategy {

    // Zauberattacke - stärker zufallsgeneriert, stärker abhängig von Erfahrung, kostet Mana
    @Override
    public int attack(Hero hero) {

        int manaCost = 10 - (hero.getLevel() / 2);
        if (manaCost < 2) manaCost = 2;

        if (hero.getMana() < manaCost) {
            Print.out("Nicht genug Mana für einen Zauberangriff!");
            return 0;
        }

        else {

        }

        Random rand = new Random();
        int randomMagicPower = rand.nextInt(0, hero.getLevel()*2);
        int damage = (randomMagicPower + hero.getLevel());
        hero.setMana(hero.getMana() - manaCost);
        Print.out("✨ - Der Zauberangriff von " + hero.getName() + " kostet " + manaCost + " und macht " + damage + " Schaden");
        return damage;
    }
}

