package org.bbz.game.user.module;

import org.bbz.game.user.module.fishing.FishModule;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-26
 * Time: 上午9:59
 */
public class Modules{
    private FishModule fishModule = null;

    public FishModule getFishModule(){
        if( fishModule == null ) {
            fishModule = new FishModule( null );
        }
        return fishModule;
    }


    public static void main( String[] args ){
        // new Modules().getFishModule().getClass();
        //FishModule fm = Modules.getInstance(FISH);
    }

}
