package org.bbz.util.time;

/**
 * 标准的冷却时间类，外层计算好结束时间，通过构造函数传入即可
 */
public final class ColdDown implements IColdDown{
    /**
     * 结束时间，单位：秒
     */
    private final int endSec;

    /**
     * @param endSec 结束时间，单位：秒
     */
    public ColdDown(int endSec){
        this.endSec = endSec;
    }

    @Override
    public int getRemainSec(){
        int sec = endSec - SystemTimer.currentTimeSecond();
        sec = sec < 0 ? 0 : sec;
        return sec;
    }

    @Override
    public boolean expire(){
        return getRemainSec() == 0;
    }

    @Override
    public int getEndTime(){
        return endSec;
    }


    public static void main(String[] args){
        IColdDown coldDown = new ColdDown(23);
        coldDown.getEndTime();
    }
}
