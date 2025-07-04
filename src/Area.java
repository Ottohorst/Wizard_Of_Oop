package src;

import java.util.*;



public class Area {


    Random rand = new Random();
    List<Hero> listOfHeroes = new ArrayList<>();
    List<Monster> listOfMonster = new ArrayList<>();

    private String name;
    private String description;

    boolean battleActive = false;

    // Nachbarreiche

    Area(String name, String description) {

        this.name = name;
        this.description = description;

    }

    public void showStats() {

        Print.out("\uD83E\uDDD9 | \uD83E\uDD34 | Werte der Helden: ");
        for (Hero h : listOfHeroes) {
            Print.out("\n" + h.getName() +" Lebenspunkte: " + h.getHealth());
            Print.out(h.getName() +" Mana: " + h.getMana());
            Print.out(h.getName() +" Attacke: " + h.getAttack());
            Print.out(h.getName() +" Erfahrung und Level: " + h.getXppoints() + " / " + h.getLevel());
            Print.out(h.getName() +" Verwendete Waffe und Extraschaden: " + h.weapon.getName() + " / " + h.weapon.getDamagePlus());
        }

        Print.out("");
        Print.out("\uD83D\uDC80 | \uD83D\uDC80 | Werte der Monster: ");
        for (Monster m : listOfMonster) {
            Print.out("\n" + m.getName() +" Lebenspunkte: " + m.getHealth());
            Print.out(m.getName() +" Attacke: " + m.getAttack());
            Print.out(m.getName() +" Level: " + m.getLevel());
        }

    }

    public void startBattle() {

        battleActive = true;
        Print.out("⚔\uFE0F Ein Kampf beginnt im " + this.getName() + "\n");

        showStats();

        while (Main.gameActive && battleActive && !listOfMonster.isEmpty()) {
            battleRound();
        }

        Print.out("\uD83D\uDEE1\uFE0F Der Kampf im " + this.getName() + " ist zuende!");

        showStats();
    }

    public void battleRound() {

        for (Hero h : listOfHeroes) h.setMana(h.getMana() + 1); // Manni schmeißt ne Runde Mana

        MeleeAttack meleeAttack = new MeleeAttack();
        MagicAttack magicAttack = new MagicAttack();

        for (Hero h : listOfHeroes) {

            Print.out("\n\uD83E\uDDD9 | \uD83E\uDD34" + h.getName() + " ist am Zug. Was soll er tun?");

            int actionChoice = Input.nextInt("1. Nahkampfangriff | 2. Zauberangriff | 3. Fliehen mit dem Rest der Party");

            if (actionChoice == 3) {

                Print.out("Ihr tretet den Rückzug an!");
                battleActive = false;
                return;
            }

            else if (actionChoice == 1 || actionChoice == 2) {

                Print.out("Welches Monster soll " + h.getName() + " angreifen? \n");


                for (Monster m : listOfMonster) {
                    Print.out(listOfMonster.indexOf(m) + " für " + m.getName());
                }

                int monsterChoice;

                do {
                    monsterChoice = Input.nextInt("");
                } while ((monsterChoice < 0) || (monsterChoice > (listOfMonster.size() - 1)));

                int damage;

                if (actionChoice == 1) h.attack(listOfMonster.get(monsterChoice));
                else if (actionChoice == 2) h.magicAttack(listOfMonster.get(monsterChoice));

                h.attack(listOfMonster.get(monsterChoice));
                Print.out(h.getName() + " macht " + h.getAttack() + " Schaden. " + listOfMonster.get(monsterChoice).getName() + " hat noch " + listOfMonster.get(monsterChoice).getHealth() + " Lebenspunkte");
                if (!listOfMonster.get(monsterChoice).isAlive()) {
                    listOfMonster.remove(monsterChoice);
                    if (listOfMonster.isEmpty()) {
                        Print.out("☠\uFE0F Das letzte Monster wurde getötet!");
                        return;
                    }
                    else {
                        Print.out("☠\uFE0F Dieses Monster wurde getötet!");
                        break;
                    }
                }




            }









        }

        Print.out("\n\uD83D\uDC80 | \uD83D\uDC80 | Die Monster greifen an!\n");

        for (Monster m : listOfMonster) {

            int randomHeroChoice = rand.nextInt(0, listOfHeroes.size());
            m.attack(listOfHeroes.get(randomHeroChoice));
            Print.out(m.getName() + " greift " + listOfHeroes.get(randomHeroChoice).getName() + " an und verursacht " + m.getAttack() + " Schaden. " + listOfHeroes.get(randomHeroChoice).getName() + " hat noch " + listOfHeroes.get(randomHeroChoice).getHealth() + "Lebenspunkte");
        }


    }















    public void addHero(Hero hero) {

        listOfHeroes.add(hero);

    }

    public void addMonster(Monster monster) {

        listOfMonster.add(monster);
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}

