package org.bbz.util.time;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 时间相关工具
 * Created by Administrator on 14-1-21.
 */
public class TimeUtil{

    /**
     * 判断输入的时间点是否今天
     *
     * @param time 用秒为单位表述的一个时间点
     * @return true     是今天
     */
    public static boolean isToday(int time){
        LocalDate localDate = new LocalDate();
        LocalDate compare = new LocalDate(time * 1000L);
        return localDate.equals(compare);
    }

    /**
     * 通过秒创建出一个 DateTime 对象
     *
     * @param second 传入的秒数
     * @return
     */
    public static DateTime createBySecond(int second){
        AtomicInteger a = new AtomicInteger();
        return new DateTime(second * 1000L);
    }
}
