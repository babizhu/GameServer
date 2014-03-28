package org.bbz.util.identity;

import org.junit.Test;

/**
 * user         LIUKUN
 * time         2014-3-28 18:00
 */

public class IdentityGenTest{
    @Test
    public void test() throws Exception{
        for( int i = 0; i < 100; i++ ) {

            System.out.println( IdentityGen.INSTANCE.incrementAndGet() );
        }
    }
}
