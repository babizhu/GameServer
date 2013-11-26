package org.bbz.game.base;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-26
 * Time: 下午2:10
 * To change this template use File | Settings | File Templates.
 */
public interface IGameObject {
    void saveToDB();

    IGameObject loadFromDB();
}
