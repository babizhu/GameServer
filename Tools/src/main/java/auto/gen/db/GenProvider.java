package auto.gen.db;

import auto.gen.db.dto.Column;
import auto.gen.db.dto.Table;
import auto.gen.db.util.DataTransUtil;
import auto.gen.util.D;
import auto.gen.util.TempletFile;
import auto.gen.util.TempletType;
import auto.gen.util.Util;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

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
    private final String className;
    private final String packageName;
    private final String DTOClassName;
    private final String DTOClassParam;
    private String src;

    public GenProvider(Table table) {
        this.table = table;
        packageName = table.getName();
        DTOClassName = Util.firstToUpperCase(table.getName());
        DTOClassParam = Util.firstToLowCase(DTOClassName);

        className = genClassName();
        src = new TempletFile(TempletType.DB, "provider.t").getTempletStr();
    }

    @Override
    public void gen() {
        genMisc();
        src = src.replace(D.TABLE_NAME_TAG, table.getName());
        genSQL();
        genPstAdd();
        System.out.println(src);
        Util.writeFile(D.SRC_DIR + D.OUTPUT_DB_PROVIDER_DIR + "/" + genClassName() + D.JAVA_FILE_SUFFIXES, src);
    }

    private void genPstAdd() {

        List<Column> columns = table.getColumns();
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Column c : columns) {
            sb.append("pst.set").append(DataTransUtil.getTypeFromDb1(c.getType())).// pst.setShort
                    append("( ").append(i++).append(", ").//pst.setShort( 1,
                    append(DTOClassParam).append(".").append(Util.genGet(c.getName())).//pst.setShort( 1, task.getNumber
                    append("() );\r\n"); //pst.setShort( 1, task.getNumber() );
        }
        src = src.replace(D.PST_ADD_TAG, sb);
    }

    /**
     * 生成sql语句
     * insert into task_base (uname, templet_id, accept_sec, parm) "  + "values (?, ?, ?, ?)";
     */
    private void genSQL() {
        List<Column> columns = table.getColumns();
        StringBuilder sb = new StringBuilder();
        for (Column c : columns) {
            sb.append(c.getName()).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);//去掉最后的逗号
        src = src.replace(D.COLUMN_NAME_TAG, sb);

        sb.setLength(0);
        for (int i = 0; i < columns.size(); i++) {
            sb.append("?,");
        }
        sb.deleteCharAt(sb.length() - 1);//去掉最后的逗号
        src = src.replace(D.COLUMN_QUESTION_MARK_TAG, sb);

    }

    private void genMisc() {
        src = src.
                replace(D.PACAKAGE_NAME_TAG, D.OUTPUT_DB_PROVIDER_DIR.replace("/", ".")).
                replace(D.DATE_TAG, DateFormat.getDateTimeInstance().format(new Date())).
                replace(D.CLASS_NAME_TAG, className).
                replace(D.DTO_CLASS_NAME_TAG, DTOClassName).
                replace(D.DTO_CLASS_PARAM_TAG, DTOClassParam);

    }

    private String genClassName() {
        return Util.firstToUpperCase(table.getName()) + "DataProvider";
    }

    public static void main(String[] args) {
        Table table = MetaData.INSTANCE.getTableByName("invite");
        new GenProvider(table).gen();

    }
}
