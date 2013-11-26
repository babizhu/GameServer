package auto.gen.db;

import auto.gen.db.dto.Table;
import auto.gen.util.TempletFile;
import auto.gen.util.TempletType;
import auto.gen.util.Util;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-21
 * Time: 下午2:54
 */
class GenJavaBean implements IGen {

    //    String path = D.SRC_DIR + "gen/db/";
    private final Table table;
    private String src;

    public GenJavaBean(Table table) {
        this.table = table;
        src = new TempletFile(TempletType.DB, "bean.t").getTempletStr();
    }


    @Override
    public void gen() {

//        src = src.
//                replace(D.PACAKAGE_NAME_TAG, D.OUTPUT_DB_DIR.replace("/", ".")).
//                replace(D.CLASS_NAME_TAG, genClassName()).
//                replace(D.DTO_CLASS_NAME_TAG, genDTOClassName()).
//                replace(D.DATE_TAG, DateFormat.getDateTimeInstance().format(new Date()));
//
//        System.out.println(src);
//        Util.writeFile(D.SRC_DIR + D.OUTPUT_DB_DIR + "/" + genClassName() + D.JAVA_FILE_SUFFIXES, src);

    }

    public String genClassName() {
        return Util.firstToUpperCase(table.getName());
    }

    private String genDTOClassName() {
        return genClassName() + "DTO";
    }


    public static void main(String[] args) {


    }

}




