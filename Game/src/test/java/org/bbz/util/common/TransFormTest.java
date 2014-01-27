package org.bbz.util.common;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Transform测试类
 * Created by Administrator on 14-1-20.
 */
public class TransFormTest{
    /**
     * 测试 结果为数组的相关方法
     *
     * @throws Exception
     */
    @Test
    public void testArray() throws Exception{
        //1     toInt
        String s = "1,2,3,4,5,6,7,8,9";
        int[] ret = TransForm.ArrayType.toInt(s);

        assertEquals(9, ret.length);
        for( int i = 0; i < ret.length; i++ ) {
            assertEquals(i + 1, ret[i]);
        }
    }

    /**
     * 测试 结果为List的相关方法
     *
     * @throws Exception
     */
    @Test
    public void testList() throws Exception{
        String s = "1,2,3,4,5,6,7,8,9";
        List<Integer> list = TransForm.ListType.toList(s);

        assertEquals(9, list.size());
        for( int i = 0; i < list.size(); i++ ) {
            int num = list.get(i);
            assertEquals(i + 1, num);
        }
    }

    /**
     * 测试打乱List列表
     *
     * @throws Exception
     */
    @Test
    public void testMix() throws Exception{
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        TransForm.ListType.mix(list);
        System.out.println("testMix() " + list);

        list = Lists.newArrayList(1, 2, 3);
        TransForm.ListType.mix(list);
        System.out.println("testMix() " + list);
    }

    /**
     * 测试 结果为字符串的相关方法
     *
     * @throws Exception
     */
    @Test
    public void testString() throws Exception{
        String expResult = "1,2,3,4,5,6,7,8,9";

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        String ret = TransForm.StringType.toStr(arr);
        assertEquals(expResult, ret);

        ret = TransForm.StringType.toStr(list);
        assertEquals(expResult, ret);

        expResult = "";
        arr = new int[0];
        ret = TransForm.StringType.toStr(arr);
        assertEquals(expResult, ret);

        list.clear();
        ret = TransForm.StringType.toStr(list);
        assertEquals(expResult, ret);

    }
}
