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
    private List<Formation> formations;
    private final FormationDataProvider db = FormationDataProvider.INSTANCE;

    public FormationManager(User user) {
        //        this.user = user;
        this.formations = db.findBy("userName", user.getName());
    }

    //    public Formation add(int templetId) {
    //        Formation formations = new Formation();
    //        formations.setLevels(1);       
    //        db.add(formations);
    //        return formations;
    //    }

    public void update(Formation formations) {
        db.update(formations);
    }

    public void delete(Formation formations) {
        db.delete(formations);
    }

    public Formation add(Formation formations) {
        db.add(formations);
        return formations;
    }

    public void addAll(List<Formation> list) {
        db.addAll(list);
    }

    private List<Formation> getAll() {
        return formations;
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
        List<Formation> list1 = fm.getAll();
        System.out.println((System.nanoTime() - begin) / 1000000000f);
        System.out.println(list1.size());
    }
}
