package src;

import java.util.Random;

class SpellFireBall implements MagicStrategy{
    @Override
    public void spell(MagicKontext magicKontext) {

        Random rand = new Random();

        int randomExtraDamage = rand.nextInt(0, 4);

        int primaryDamage = 8 + (magicKontext.spellCaster.getLevel() * 3) + randomExtraDamage;
        int secondaryDamage = 2 + (magicKontext.spellCaster.getLevel() * 2) + randomExtraDamage;
        int collateralDamage = 5 + randomExtraDamage - magicKontext.spellCaster.getLevel();
        if (collateralDamage < 0) collateralDamage = 0;

        for (Monster m : magicKontext.possibleEnemyTargets) {
            if (m != magicKontext.monsterTarget) m.takeDamage(secondaryDamage);
            }

        magicKontext.monsterTarget.takeDamage(primaryDamage);

        Print.out(S.SPARKS + S.FIRE + " Der Feuerball von " + magicKontext.spellCaster.getName() + " fügt " + magicKontext.monsterTarget.getName() + " " + primaryDamage + ", den anderne Monstern jeweils " + secondaryDamage + " Schaden zu.");
        if (collateralDamage > 0) {
            magicKontext.spellCaster.takeDamage(collateralDamage);
            magicKontext.friendlyTarget.takeDamage(collateralDamage);
            Print.out("Die Helden bekommen allerdings ebenfalls " + collateralDamage + " Schaden ab.");
        }

    }

    @Override
    public String getIcon() {
        return S.FIRE;
    }

    @Override
    public String getName() {
        return "Feuerball";
    }

    @Override
    public String getDescription() {
        return "Ein Feuerball trifft das Ziel und fügt auch den anderen Monstern Schaden zu - je nach Level des Zauberers aber auch den Helden.";
    }

    @Override
    public int getManaCost() {
        return 10;
    }
}
