package org.bbz.game.db.gen;

/**
 * 模版
 *
 * @author GEN_ROBOT
 *         2013-11-26 18:05:50
 */
public class Formation {

    /**
     * 玩家ID
     */
    private String userName;

    /**
     * 玩家ID
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 玩家ID
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 模板ID
     */
    private int templetId;

    /**
     * 模板ID
     */
    public int getTempletId() {
        return templetId;
    }

    /**
     * 模板ID
     */
    public void setTempletId(int templetId) {
        this.templetId = templetId;
    }

    /**
     * 等级
     */
    private int levels;

    /**
     * 等级
     */
    public int getLevels() {
        return levels;
    }

    /**
     * 等级
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
