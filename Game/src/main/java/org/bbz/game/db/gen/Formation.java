package org.bbz.game.db.gen;

/**
 * 模版
 *
 * @author GEN_ROBOT
 *         2013-11-28 14:51:56
 */
public class Formation {

    /**
     * 玩家姓名
     */
    private String userName;

    /**
     * 玩家姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 玩家姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 阵型模板id
     */
    private int templetId;

    /**
     * 阵型模板id
     */
    public int getTempletId() {
        return templetId;
    }

    /**
     * 阵型模板id
     */
    public void setTempletId(int templetId) {
        this.templetId = templetId;
    }

    /**
     * 阵型等级
     */
    private int levels;

    /**
     * 阵型等级
     */
    public int getLevels() {
        return levels;
    }

    /**
     * 阵型等级
     */
    public void setLevels(int levels) {
        this.levels = levels;
    }


    public Formation() {
    }

    @Override
    public String toString() {
        return "Formation [userName = " + userName + ",templetId = " + templetId + ",levels = " + levels + "]";
    }

}
