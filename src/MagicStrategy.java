package src;

import java.util.Random;

public interface MagicStrategy {

    void spell(MagicKontext magicKontext);
    String getIcon();
    String getName();
    String getDescription();
    int getManaCost();

}