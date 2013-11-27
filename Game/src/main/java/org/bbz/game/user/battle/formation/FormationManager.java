package org.bbz.game.user.battle.formation;

import org.bbz.game.db.gen.Formation;
import org.bbz.game.db.gen.FormationDataProvider;
import org.bbz.game.user.User;

import java.util.ArrayList;
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
        formations = getAllByUser();
    }

    public Formation add(int templetId) {
        Formation formation = new Formation();
        formation.setLevels(1);
        formation.setTempletId(templetId);
        formation.setUserName(user.getName());
        db.add(formation);
        return formation;
    }

    public void delete(Formation formation) {
        db.delete(formation);
    }

    public Formation add(Formation formation) {
        db.add(formation);
        return formation;
    }

    public void addAll(List<Formation> list) {
        db.addAll(list);
    }

    private List<Formation> getAllByUser() {
        return db.findBy("userName", user.getName());
    }

    public static void main(String[] args) {

        User user1 = new User();
        user1.setName("lk");
        List<Formation> list = new ArrayList<Formation>();

        FormationManager fm = new FormationManager(user1);

        Formation formation = new Formation();
        formation.setLevels(1);
        formation.setUserName(user1.getName());
        long begin = System.nanoTime();
        for (int i = 0; i < 50; i++) {
            formation.setTempletId(i);

            fm.add(formation);
            System.out.println(i);

        }
        System.out.println((System.nanoTime() - begin) / 1000000000f);

        begin = System.nanoTime();
        for (int i = 5000; i < 55000; i++) {
            Formation f = new Formation();
            f.setUserName(user1.getName());
            f.setTempletId(i);
            f.setLevels(i);
            list.add(f);
        }

        fm.addAll(list);
        System.out.println((System.nanoTime() - begin) / 1000000000f);

        fm.delete(formation);

        begin = System.nanoTime();
        List<Formation> list1 = fm.getAllByUser();
        System.out.println((System.nanoTime() - begin) / 1000000000f);
        System.out.println(list1.size());

    }


}
