package auto.gen.db;

import auto.gen.db.dto.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-22
 * Time: 下午6:00
 * 启动类
 */
public class Launch {
    public static void main(String[] args) {
        Table table = MetaData.INSTANCE.getTableByName("invite");
        new GenJavaBeanDTO(table).gen();
        new GenJavaBean(table).gen();
        new GenProvider(table).gen();
    }
}
