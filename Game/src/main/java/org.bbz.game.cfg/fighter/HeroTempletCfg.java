package org.bbz.game.cfg.fighter;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模版配置
 * @author liukun
 * 2013-11-16 0:06:02
 */
public class HeroTempletCfg {
	private static final Map<Integer,HeroTemplet> heroTemplets = new HashMap<Integer, HeroTemplet>();


	static{
		init();

	}
	private static final String FILE = "./Game/src/main/resources/xml/fighter/hero.xml";



	private static void init(){

		SAXBuilder builder = new SAXBuilder();
		Document document;
		try {
			document = builder.build( FILE );
			Element root = document.getRootElement();
			List<?> list = root.getChildren( "hero" );

			for (Object o : list) {
				HeroTemplet templet = new HeroTemplet( (Element) o );
				HeroTemplet temp = heroTemplets.put( templet.getId(), templet );
				if( temp != null ){
					throw new RuntimeException( "HeroTemplet id [" + temp.getId() + "] 重复了" );
				}

			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println( "HeroTemplet xml配置文件解析完毕" );
	}


	/**
	 * 通过id获取HeroTemplet的引用
	 * @param   templetId   id
	 * @return  返回一个引用
	 */
	public static HeroTemplet getHeroTempletById( int templetId ){
		return heroTemplets.get( templetId );
	}

	/*自定义代码开始*//*自定义代码结束*/

	public static void main(String[] args) {

		int id = 1;
		System.out.println( getHeroTempletById( id ) );
	}
}
