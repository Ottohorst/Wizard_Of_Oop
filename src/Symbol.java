// Obsolte enum-File, lieber über Klasse geregelt mit static finals

package src;

public enum Symbol {

    WIZARD("\uD83E\uDDD9", 1),
    PRINCE("🤴", 2);

/*
🦇 = Fledermaus
🧛 =  Vampir
🧟 =  Zombie
🦂 =  Skorpion
🦎 =  Eidechse
🐉 =  Drache

🦅 =  Adler
🦆 =  Ente




🌲 = Baum1
🌳 = Baum2
🦴 = Knochen

🧱 = Backstein
🧹 = Besen
🧆 =


🧤 Handschuhe
🧩 Puzzlestück
🧭 Kompass
🧮 Abakus
🧿 Nazar-Amulett
⚔️ Gekreuzte Schwerter
🧠 Gehirn

 */


    private final String symbol;
    private final int id;

    Symbol(String symbol, int id) {
        this.symbol = symbol;
        this.id = id;
    }

    public String print() {
        return symbol;
    }

}
