package org.bbz.game.module.fighters;

import lombok.Data;
import org.bbz.game.cfg.fighter.FighterTemplet;

/**
 * user         LIUKUN
 * time         14-3-25 下午1:34
 */

@Data
public class Fighter{
    private FighterTemplet      templet;
    private int                 hp;
    private int                 hpMax;
    private int                 phyAttack;
    private int                 phyDefender;
    private int                 magicAttack;
    private int                 magicDefender;
}
