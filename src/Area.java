package src;

import java.util.*;



public class Area {


    Random rand = new Random();
    List<Hero> listOfHeroes = new ArrayList<>();
    List<Monster> listOfMonster = new ArrayList<>();

    private String name;
    private String description;

    boolean battleActive = false;

    // Später kann man überlegen, Nachbarn zu bauen und so eine Landschaft zu generieren.

    Area(String name, String description) {

        this.name = name;
        this.description = description;

    }

    public void showStats() {

        Print.out(S.ABAKUS + " Werte der Helden: ");
        for (Hero h : listOfHeroes) {
            Print.out(h.getIcon() + S.HEART + " " + h.getName() + " Lebenspunkte: " + h.getHealth());
            Print.out(h.getIcon() + S.MANA + " " + h.getName() + " Mana: " + h.getMana());
            Print.out(h.getIcon() + S.WINDBLOW + " " + h.getName() + " Attacke: " + h.getAttack());
            Print.out(h.getIcon() + S.BRAIN + " " + h.getName() + " Erfahrung und Level: " + h.getXppoints() + " / " + h.getLevel());
            Print.out(h.getIcon() + h.getWeapon().getIcon() + " " + h.getName() + " Verwendete Waffe und Extraschaden: " + h.weapon.getName() + " / " + h.weapon.getDamagePlus());
        }

        Print.out("");
        Print.out(S.ABAKUS + " Werte der Monster: ");
        for (Monster m : listOfMonster) {
            Print.out(m.getIcon() + S.HEART + " " + m.getName() + " Lebenspunkte: " + m.getHealth());
            Print.out(m.getIcon() + S.SWORDS + " " + m.getName() +" Attacke: " + m.getAttack());
            Print.out(m.getIcon() + S.STONE + " " + m.getName() +" Level: " + m.getLevel());
        }
        Print.out("");
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

        // Manni schmeißt ne Runde Mana zu Beginn jeder Runde

        for (Hero h : listOfHeroes) h.setMana(h.getMana() + 1);

        // Zuerst greifen die Helden an, die können auch wegrennen (klappt Stand jetzt immer) und ihre Attacken bestimmen.

        for (Hero h : listOfHeroes) {

            List<Hero> heroFriends = new ArrayList<>(listOfHeroes);
            // List<Hero> heroFriends = listOfHeroes; - Stehenlassen als abschreckendes Beispiel - falsch initialisiert entsteht hier eine Referenz auf die bestehende Liste, keine neue!
            heroFriends.remove(h);

            Print.out(h.getIcon() + " " + h.getName() + " ist am Zug. Was soll er tun?");

            int actionChoice = Input.nextInt("1. Angriff mit " + h.weapon.getName() + " | 2. Zaubern | 3. Fliehen mit dem Rest der Party");

            if (actionChoice == 3) {

                Print.out(S. RUNNING + " Ihr tretet den Rückzug an!\n");
                battleActive = false;
                return;
            }

            else if (actionChoice == 2) {

                // Der Einfachheit HardCode, wäre natürlich eigentlich besser dynamisch zu regeln.

                SpellAirBlow spellAirBlow = new SpellAirBlow();
                SpellFireBall spellFireBall = new SpellFireBall();
                SpellHealing spellHealing = new SpellHealing();

                Print.out("\n" + S.SPARKS + S.SPARKS + " Welcher Zauber soll ausgeführt werden?");
                Print.out("1. " + S.SPARKS + S.WINDBLOW + " Luftkuss - " + spellAirBlow.getDescription());
                Print.out("2. " + S.SPARKS + S.FIRE + " Feuerball - " + spellFireBall.getDescription());
                Print.out("3. " + S.SPARKS + S.CROSS + " Heilung - " + spellHealing.getDescription());

                int spellChoice = Input.nextInt(""); // Todo: Sicherheitsabfrage!


                if (spellChoice == 1) {

                    int monsterChoice;

                    if(listOfMonster.size() == 1) monsterChoice = 0;

                    else {

                        Print.out(S.SPARKS + S.WINDBLOW + " Auf welches Monster soll dieser Luftkuss gerichtet werden?");

                        for (Monster m : listOfMonster) {
                            Print.out(listOfMonster.indexOf(m) + " für " + m.getIcon() + " " + m.getName());
                        }

                        do {
                            monsterChoice = Input.nextInt("");
                        } while ((monsterChoice < 0) || (monsterChoice > (listOfMonster.size() - 1)));
                    }

                    MagicKontext magicKontext = new MagicKontext(h, null, listOfMonster.get(monsterChoice), listOfMonster);
                    spellAirBlow.spell(magicKontext);
                    return;
                }

                if (spellChoice == 2) {

                    int monsterChoice;

                    if (listOfMonster.size() == 1) monsterChoice = 0;

                    else {

                        Print.out(S.SPARKS + S.FIRE + " Auf welches Monster soll der Feuerball gerichtet werden?");

                        for (Monster m : listOfMonster) {
                            Print.out(listOfMonster.indexOf(m) + " für " + m.getIcon() + " " + m.getName());
                        }

                        do {
                            monsterChoice = Input.nextInt("");
                        } while ((monsterChoice < 0) || (monsterChoice > (listOfMonster.size() - 1)));
                    }

                    MagicKontext magicKontext = new MagicKontext(h, heroFriends.getFirst(), listOfMonster.get(monsterChoice), listOfMonster);
                    spellFireBall.spell(magicKontext);
                    return;

                }

                if (spellChoice == 3) {

                    MagicKontext magicKontext = new MagicKontext(h, heroFriends.getFirst(), null, listOfMonster);
                    spellHealing.spell(magicKontext);
                    return;
                }

            }

            else if (actionChoice == 1) {

                int monsterChoice;

                if(listOfMonster.size() == 1) monsterChoice = 0;

                else {

                    Print.out(S.SWORDS + " Welches Monster soll " + h.getName() + " angreifen? \n");

                    for (Monster m : listOfMonster) {
                        Print.out(listOfMonster.indexOf(m) + " für " + m.getIcon() + " " + m.getName());
                    }

                    do {
                        monsterChoice = Input.nextInt("");
                    } while ((monsterChoice < 0) || (monsterChoice > (listOfMonster.size() - 1)));
                }

                // Abfrage mit minimaler Sicherung, dass der User keinen Quatsch eingibt.
                // Hier könnte ein Strategy Pattern sinnvoll sein, um verschiedene Validierungen zu realisieren.

                int damage = h.attack(listOfMonster.get(monsterChoice));
                Print.out(S.SWORDS + " Der Angriff von " + h.getName() + " mit " + h.weapon.getName() + " macht " + damage + " Schaden");
                listOfMonster.get(monsterChoice).takeDamage(damage);
                if (!listOfMonster.get(monsterChoice).isAlive()) {
                    Print.out(listOfMonster.get(monsterChoice).getIcon() + " " + listOfMonster.get(monsterChoice).getName() + " ist besiegt!\n");
                    listOfMonster.remove(monsterChoice);
                }

                else {
                    Print.out(listOfMonster.get(monsterChoice).getIcon() + " " + listOfMonster.get(monsterChoice).getName() + " hat noch " + listOfMonster.get(monsterChoice).getHealth() + " Lebenspunkte\n");
                }

                if (listOfMonster.isEmpty()) {
                    Print.out("☠\uFE0F Das letzte Monster wurde getötet!\n");
                    return;
                }
            }

        }

        Print.out(listOfMonster.get(0).getIcon() + " Die Monster greifen an!\n");

        for (Monster m : listOfMonster) {

            int randomHeroChoice = rand.nextInt(0, listOfHeroes.size());
            m.attack(listOfHeroes.get(randomHeroChoice));
            Print.out(m.getIcon() + " " + m.getName() + " greift " + listOfHeroes.get(randomHeroChoice).getName() + " an und verursacht " + m.getAttack() + " Schaden. " + listOfHeroes.get(randomHeroChoice).getName() + " hat noch " + listOfHeroes.get(randomHeroChoice).getHealth() + " Lebenspunkte.");
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


