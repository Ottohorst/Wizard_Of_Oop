package src;
import java.util.List;

public class MagicKontext {

    public Hero spellCaster;
    public Hero friendlyTarget; // Aktuell nur für max. 2 Charaktere geeignet
    public Monster monsterTarget;
    public List<Monster> possibleEnemyTargets;

    public MagicKontext(Hero spellCaster, Hero friendlyTarget, Monster monsterTarget, List<Monster> possibleEnemyTargets) {
        this.spellCaster = spellCaster;
        this.friendlyTarget = friendlyTarget;
        this.monsterTarget = monsterTarget;
        this.possibleEnemyTargets = possibleEnemyTargets;
    }




}
