package org.bbz.util.time;

/**
 * 冷却时间管理类
 */
public interface IColdDown{
    /**
     * 获取冷却时间剩余的秒数，如果小于0，则返回0
     *
     * @return 剩余的时间，单位：秒
     */
    int getRemainSec();

    /**
     * 冷却时间是否到期
     *
     * @return true        到期
     * false       未到期
     */
    boolean expire();

    /**
     * 获取结束的时间
     *
     * @return 结束的时间，单位：秒
     */
    int getEndTime();
}

