package org.bbz.game.user.battle.formation;

import org.bbz.game.db.gen.Formation;
import org.bbz.game.db.gen.FormationDataProvider;
import org.bbz.game.user.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-26
 * Time: 下午2:18
 */
public class FormationManager {

    private final User user;
    private List<Formation> formations;
    private final FormationDataProvider db = FormationDataProvider.INSTANCE;

    public FormationManager(User user) {
        this.user = user;
        init();
    }

    /**
     * 从数据库初始化阵容信息
     */
    private void init() {
        formations = db.findBy("userName", user.getName());
    }


}
