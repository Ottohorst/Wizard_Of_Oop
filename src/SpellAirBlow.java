package src;


import java.util.Random;

class SpellAirBlow implements MagicStrategy {


    @Override
    public void spell(MagicKontext magicKontext) {

        Random rand = new Random();
        int randomExtraDamage = rand.nextInt(0, 3);
        int damage = 5 + randomExtraDamage + magicKontext.spellCaster.getLevel();
        magicKontext.monsterTarget.takeDamage(damage);
        Print.out(S.SPARKS + S.WINDBLOW + " Der Luftkuss von " + magicKontext.spellCaster.getName() + " macht " + damage + " Schaden. " + magicKontext.monsterTarget.getName() + " hat noch " + magicKontext.monsterTarget.getHealth() + " Lebenspunkte.");

    }

    @Override
    public String getIcon() {
        return S.WINDBLOW;
    }

    @Override
    public String getName() {
        return "Luftkuss";
    }

    @Override
    public String getDescription() {
        return "Wie der Kuss eines unsichtbaren Pferdes. Fügt einem einzelnen Ziel Schaden zu je nach Level des Zauberers.";
    }

    @Override
    public int getManaCost() {
        return 0;
    }
}


