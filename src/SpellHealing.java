package src;

public class SpellHealing implements MagicStrategy{
    @Override
    public void spell(MagicKontext magicKontext) {

        // TODO: Limitierung, dass HP nicht über Maximum hinaus "geheilt" werden können.
        int healingPoints = 5 + 3 * magicKontext.spellCaster.getLevel();
        magicKontext.friendlyTarget.setHealth(magicKontext.friendlyTarget.getHealth() + healingPoints);
        Print.out(magicKontext.spellCaster.getName() + " hat " + magicKontext.friendlyTarget.getName() + " " + healingPoints + " Lebenspunkte zurückgegeben.");

    }

    @Override
    public String getIcon() {
        return S.CROSS;
    }

    @Override
    public String getName() {
        return "Heilung";
    }

    @Override
    public String getDescription() {
        return "Ein klassischer Heilungszauber für den Gefährten des Zauberers. Sich selbst heilen kann er aber nicht.";
    }

    @Override
    public int getManaCost() {
        return 5;
    }
}
