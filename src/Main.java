package src;


public class Main {

    static boolean gameActive = true;

    public static void main(String[] args) {

        Print.out(S.SETFGWHITE);
        Print.out("+++++++++++++++++++++++++++++++++");
        Print.out("+                               +");
        Print.out("+     DIE ZAUBERER VON OOP      +");
        Print.out("+                               +");
        Print.out("+          " + S.SPARKS + "    " + S.BAT + "    " + S.BAT + "      +");
        Print.out("+" + S.CASTLE + " " + S.PRINCE + S.WIZARD + S.WINDBLOW + "  " + S.SWORDS + "  " + S.SKELETON + S.ZOMBIE + S.VAMPIRE + "  " + S.SMALLDRAGON + S.BIGDRAGON + "  +");
        Print.out("+++++++++++++++++++++++++++++++++\n");
        Print.out("");
        Input.nextInt("Drücke eine beliebige Taste!");
        game();

    }

    public static void game() {

        Weapon weapon1 = new Weapon ("Krummstab", S.STICK, "Besser als nichts", 1, 0);
        Weapon weapon2 = new Weapon ("Knüppel", S.STICK, "Besser als nichts", 1, 0);

        Hero hero1 = new Hero("Zorak", S.WIZARD, weapon1);
        Hero hero2 = new Hero("Borhan", S.PRINCE, weapon2);

        Monster monster1 = new Monster(1);
        Monster monster2 = new Monster(0);
        Monster monster3 = new Monster(0);

        Area area1 = new Area("Friedhof", "Ein gruseliger Friedhof");

        area1.addHero(hero1);
        area1.addHero(hero2);

        area1.addMonster(monster1);
        area1.addMonster(monster2);

        area1.startBattle();
    }


}