package auto.gen.db;

import auto.gen.db.dto.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-22
 * Time: 下午5:07
 * <p/>
 * 生成数据库某张表的privider类
 */
class GenProvider implements IGen {
    Table table;

    public GenProvider(Table table) {
        this.table = table;
    }

    @Override
    public void gen() {

    }
}
