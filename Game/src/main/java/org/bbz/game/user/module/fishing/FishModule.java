package org.bbz.game.user.module.fishing;

import org.bbz.game.user.User;
import org.bbz.game.user.module.IModule;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-26
 * Time: 上午10:00
 */
public class FishModule implements IModule {

    private User user;

    public FishModule(User user) {
        this.user = user;
        System.out.println("构造FishModule");
    }
}
