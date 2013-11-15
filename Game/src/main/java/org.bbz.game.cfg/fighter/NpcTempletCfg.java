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
 *
 * @author liukun
 *         2013-11-15 15:37:14
 */
public class NpcTempletCfg {
    private static final Map<Integer, NpcTemplet> npcTemplets = new HashMap<Integer, NpcTemplet>();


    static {
        init();

    }

    private static final String FILE = "./Game/src/main/resources/xml/fighter/npc.xml";


    private static void init() {

        SAXBuilder builder = new SAXBuilder();
        Document document;
        try {
            document = builder.build(FILE);
            Element root = document.getRootElement();
            List<?> list = root.getChildren("npc");

            for (Object o : list) {
                NpcTemplet templet = new NpcTemplet((Element) o);
                NpcTemplet temp = npcTemplets.put(templet.getId(), templet);
                if (temp != null) {
                    throw new RuntimeException("NpcTemplet id [" + temp.getId() + "] 重复了");
                }

            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("NpcTemplet xml配置文件解析完毕");
    }


    /**
     * 通过id获取NpcTemplet的引用
     *
     * @param templetId id
     * @return 返回一个引用
     */
    public static NpcTemplet getNpcTempletById(int templetId) {
        return npcTemplets.get(templetId);
    }

	/*自定义代码开始*//*自定义代码结束*/

    public static void main(String[] args) {

        int id = 1;
        System.out.println(getNpcTempletById(id));
    }
}
