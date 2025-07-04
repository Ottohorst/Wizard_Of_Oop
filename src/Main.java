package src;


public class Main {

    static boolean gameActive = true;

    public static void main(String[] args) {

        Print.out("\n\n\n");
        Print.out("+++++++++++++++++++++++++++++++++");
        Print.out("+                               +");
        Print.out("+     DIE ZAUBERER VON OOP      +");
        Print.out("+             \uD83E\uDDD9                +");
        Print.out("+++++++++++++++++++++++++++++++++\n");

        game();
    }

    public static void game() {

        Weapon weapon1 = new Weapon ("Knüppel", "Besser als nichts", 1, 0);
        Weapon weapon2 = new Weapon ("Stein", "Besser als nichts", 1, 0);

        Hero hero1 = new Hero("Abrakadabarney", weapon1);
        Hero hero2 = new Hero("Borhan", weapon2);

        Monster monster1 = new Monster(1);
        Monster monster2 = new Monster(2);

        Area area = new Area("Friedhof", "Ein gruseliger Friedhof");

        area.addHero(hero1);
        area.addHero(hero2);

        area.addMonster(monster1);
        area.addMonster(monster2);

        area.startBattle();
    }


}