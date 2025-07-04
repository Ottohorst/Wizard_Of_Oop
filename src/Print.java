package src;

abstract class Print {

    // Sinnvoller Adapter: Wenn irgendwann eine GUI mit Konsole kommt, dann schreiben wir nur eine Methode um!

    static void out(String string) {
        System.out.println(string);

    }

}

