package org.bbz.util.common;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * user         LIUKUN
 * time         2014-3-28 15:44
 */

public class MiscUtilTest{
    @Test
    public void testGetLevel() throws Exception{
        int[] data = new int[]{0,1,10,20,50,100,150};
//        int[] data = new int[]{0,1,3,6,10};
        int level = MiscUtil.getLevel( data, 0, true );
        assertEquals( 1, level );

        level = MiscUtil.getLevel( data, 0, false );
        assertEquals( 0, level );

        level = MiscUtil.getLevel( data, 45, false );
        assertEquals( 3, level );

        level = MiscUtil.getLevel( data, 450, false );
        assertEquals( 7, level );

        level = MiscUtil.getLevel( data, 450, true );
        assertEquals( 8, level );


        data = new int[]{1,2,5};//测试不从0开始的数组
        level = MiscUtil.getLevel( data, 450, true );
        assertEquals( 4, level );

    }
}
