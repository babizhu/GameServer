package auto.gen.db;

import auto.gen.db.dto.Table;
import auto.gen.util.D;
import auto.gen.util.TempletFile;
import auto.gen.util.TempletType;
import auto.gen.util.Util;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-21
 * Time: 下午2:54
 */
public class GenJavaBean implements IGen {

    //    String path = D.SRC_DIR + "gen/db/";
    private final Table table;
    private String javaSource;

    public GenJavaBean(Table table) {
        this.table = table;
        javaSource = new TempletFile(TempletType.DB, "bean.t").getTempletStr();
    }


    @Override
    public void gen() {

        javaSource = javaSource.
                replace(D.PACAKAGE_NAME_TAG, D.OUTPUT_DB_DIR.replace("/", ".")).
                replace(D.CLASS_NAME_TAG, getClassName()).
                replace(D.DTO_CLASS_NAME_TAG, getDTOClassName()).
                replace(D.DATE_TAG, DateFormat.getDateTimeInstance().format(new Date()));

        System.out.println(javaSource);
        Util.writeFile(D.SRC_DIR + D.OUTPUT_DB_DIR + getClassName() + D.JAVA_FILE_SUFFIXES, javaSource);

    }

    private String getClassName() {
        return Util.firstToUpperCase(table.getName());
    }

    private String getDTOClassName() {
        return getClassName() + "DTO";
    }


    public static void main(String[] args) {

        Table table = MetaData.INSTANCE.getTableByName("invite");
        new GenJavaBeanDTO(table).gen();
        new GenJavaBean(table).gen();
    }

}




