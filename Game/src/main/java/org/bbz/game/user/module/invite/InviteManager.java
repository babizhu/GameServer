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
 */
public class InviteManager {
    private final User user;
    private List<Invite> invites;
    private final InviteDataProvider db = InviteDataProvider.INSTANCE;

    public InviteManager(User user) {
        this.user = user;
        this.invites = db.findBy("userName", user.getName());
    }

    //    public Invite add(int templetId) {
    //        Invite invites = new Invite();
    //        invites.setLevels(1);
    //        db.add(invites);
    //        return invites;
    //    }

    public void update(Invite invites) {
        db.update(invites, user.getName());
    }

    public void delete(Invite invites) {
        db.delete(invites, user.getName());
    }

    public Invite add(Invite invites) {
        db.add(invites, user.getName());
        return invites;
    }

    public void addAll(List<Invite> list) {
        db.addAll(list, user.getName());
    }

    private List<Invite> getAll() {
        return invites;
    }
}
