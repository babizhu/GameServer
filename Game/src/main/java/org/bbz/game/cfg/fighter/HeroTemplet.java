package org.bbz.game.cfg.fighter;

import org.jdom2.Element;

/**
 * 模版
 *
 * @author liukun
 *         2013-11-25 15:09:23
 */
public class HeroTemplet{

    /**
     * id
     */
    private final int id;


    /**
     * id
     */
    public int getId(){
        return id;
    }

    /**
     * 名称
     */
    private final String name;


    /**
     * 名称
     */
    public String getName(){
        return name;
    }

    /**
     * 重量
     */
    private final int weight;


    /**
     * 重量
     */
    public int getWeight(){
        return weight;
    }


    public HeroTemplet( Element element ){
        id = Integer.parseInt( element.getChildText( "id" ).trim() );
        name = element.getChildText( "name" ).trim();
        weight = Integer.parseInt( element.getChildText( "weight" ).trim() );

    }

    @Override
    public String toString(){
        return "HeroTemplet [id = " + id + ",name = " + name + ",weight = " + weight + "]";
    }

	/*自定义代码开始*//*自定义代码结束*/
}
