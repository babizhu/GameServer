package gen.db;

import gen.db.dto.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-22
 * Time: 下午6:00
 * 启动类
 */
public class Launch {
    public static void main(String[] args) {
        for (Table table : MetaData.INSTANCE.getTables()) {
            new GenJavaBeanDTO(table).gen();
            //new GenJavaBean(table).gen();
            new GenProvider(table).gen();
        }
    }
}
