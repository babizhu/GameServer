package org.bbz.util.common;

import org.joda.time.LocalDate;

/**
 * 时间相关工具
 * Created by Administrator on 14-1-21.
 */
public class TimeUtil {


    /**
     * 判断输入的时间点是否今天
     *
     * @param time 用秒表述的一个时间点
     * @return true    是今天
     */
    public static boolean isToday(int time) {
        LocalDate localDate = new LocalDate();
        LocalDate compare = new LocalDate(time * 1000L);
        return localDate.equals(compare);
    }
}
