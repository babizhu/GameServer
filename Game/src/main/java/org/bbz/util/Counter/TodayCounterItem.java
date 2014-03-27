package org.bbz.util.Counter;

import lombok.Data;
import lombok.ToString;
import org.bbz.util.time.SystemTimer;
import org.bbz.util.time.TimeUtil;
import util.serialize.Serialize;

/**
 * user         LIUKUN
 * time         14-3-24 下午7:31
 * 当日有效的计数器，到12点就应该要清空
 */

@ToString
@Data
public class TodayCounterItem{


    /**
     * 设置数量时候的时间
     */
    private int time;

    /**
     * 数量
     */
    private int count;

    public int getCount(){
        if( TimeUtil.isToday( time ) ) {
            return count;
        }
        return 0;
    }

    public void setCount( int count ){
        time = SystemTimer.currentTimeSecond();
        this.count = count;

    }

    void setData(){
        time = 39;
    }

    public static void main( String[] args ) throws IllegalAccessException, InstantiationException{
        TodayCounterItem item = new TodayCounterItem();
        //item.setData();
        item.setCount( 20 );
        byte[] data = Serialize.INSTANCE.encode( item );
        System.out.println( new String( data ) );
        TodayCounterItem item1 = Serialize.INSTANCE.decode( data, TodayCounterItem.class );
        System.out.println( item1.time );

        int i = 10;
        data = Serialize.INSTANCE.encode( i );
        System.out.println( new String( data ) );
        Integer n = Serialize.INSTANCE.decode( data, int.class );
        System.out.println( n );


    }
}
