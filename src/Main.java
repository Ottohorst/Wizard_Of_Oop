package src;


public class Main {

    static boolean gameActive = true;

    static Hero hero1;
    static Hero hero2;

    static Weapon weapon1 = new Weapon ("Krummstab", S.STICK, "Besser als nichts", 1, 0);
    static Weapon weapon2 = new Weapon ("Knüppel", S.STICK, "Besser als nichts", 1, 0);

    static Area area1 = new Area("Der Wald", "Im dichten Wald beginnt euer Abenteuer.");
    static Area area2 = new Area("Der Friedhof", "Der Weg nach Hause führt über den Friedhof.");
    static Area area3 = new Area("Das Dorf", "In eurem Heimatdorf könnt ihr euch erholen.");
    static Area area4 = new Area("Das alte Schlachtfeld", "Hier formiert sich die Armee der Finsternis");
    static Area area5 = new Area("In der Schlucht", "Der Weg zu Fürst Rachnow führt durch die Schlucht");
    static Area area6 = new Area("Die Höhlen", "Der Pass ist verschüttet - durch die Höhlen führt der Weg");
    static Area area7 = new Area("Der Turm", "Durch die Höhlen erreicht ihr das Drachenschloss - im Turm wartet der Drachenkönig");
    static Area area8 = new Area("Die Schlafgemächer", "Viele Teufel warten im Inneren der Schlossruine");
    static Area area9 = new Area("Vampirgruft", " - die Höhle des Löwen - die Gemächer des ");




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

        defineGame();

    }

    public static void defineGame() {
        Print.out(S.WIZARD + " - Wie soll dein Zauberer heißen? ");
        String nameHero1 = Input.str();
        Print.out(S.PRINCE + " - Wie soll dein Edelmann heißen? ");
        String nameHero2 = Input.str();

        hero1 = new Hero("Zorak", S.WIZARD, weapon1);
        hero2 = new Hero("Borhan", S.PRINCE, weapon2);

        Monster skeleton11 = new Monster(0);
        Monster skeleton12 = new Monster(0);
        Monster skeleton13 = new Monster(0);

        Monster zombie21 = new Monster(1);
        Monster skeleton21 = new Monster(0);
        Monster zombie22 = new Monster(1);

        Monster skeletonWarrior31 = new Monster(2);

        Monster skeletonKnight41 = new Monster(3);
        Monster zombieKnight41 = new Monster(4);
        Monster skeleton41 = new Monster(0);
        Monster skeletonWarrior41 = new Monster(2);

        Monster zombieKnight51 = new Monster(4);
        Monster skeleton51 = new Monster(0);
        Monster skeleton52 = new Monster(0);
        Monster skeleton53 = new Monster(0);
        Monster skeleton54 = new Monster(0);

        Monster skorpion61 = new Monster(5);

        Monster dragonSmall71 = new Monster(6);
        Monster dragonSmall72 = new Monster(6);
        Monster dragonKing = new Monster(12);

        Monster devil81 = new Monster(7);
        Monster shedevil81 = new Monster(8);

        Monster rachnow = new Monster(20);
        Monster dragonBig = new Monster(9);
        Monster dragonBig2 = new Monster(9);



        area1.addHero(hero1);
        area1.addHero(hero2);

        area1.addMonster(skeleton11);
        area1.addMonster(skeletonWarrior31);

        area1.startBattle();


    }



    public static void game() {






    }


}