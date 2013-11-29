package org.bbz.game.user.module.invite;

import org.bbz.game.db.gen.Invite;
import org.bbz.game.db.gen.InviteDataProvider;
import org.bbz.game.user.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-28
 * Time: 上午11:35
 * To change this template use File | Settings | File Templates.
 */
public class InviteManager {
    private List<Invite> invites;
    private final InviteDataProvider db = InviteDataProvider.INSTANCE;

    public InviteManager(User user) {
        //        this.user = user;
        this.invites = db.findBy("userName", user.getName());
    }

    //    public Invite add(int templetId) {
    //        Invite invites = new Invite();
    //        invites.setLevels(1);
    //        db.add(invites);
    //        return invites;
    //    }

    public void update(Invite invites) {
        db.update(invites);
    }

    public void delete(Invite invites) {
        db.delete(invites);
    }

    public Invite add(Invite invites) {
        db.add(invites);
        return invites;
    }

    public void addAll(List<Invite> list) {
        db.addAll(list);
    }

    private List<Invite> getAll() {
        return invites;
    }
}
