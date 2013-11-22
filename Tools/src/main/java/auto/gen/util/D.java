package auto.gen.util;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-5
 * Time: 下午5:04
 */
public final class D {

    public static final String GAME_BASE_DIR = "./Game/src/main";
    public static final String TOOLS_BASE_DIR = "./Tools/src/main";
    public static final String TOOLS_BASE_RESOURCES_DIR = TOOLS_BASE_DIR + "/resources";

    public static final String OUTPUT_CFG_DIR = "org/bbz/game/cfg/";
    public static final String OUTPUT_DB_DIR = "org/bbz/game/db/";
    public static final String SRC_DIR = GAME_BASE_DIR + "/java/";
    public static final String XML_RESOURCE_DIR = GAME_BASE_DIR + "/resources/xml/";
    public static final String CFG_CLASS_TEMPLET_DIR = TOOLS_BASE_RESOURCES_DIR + "/templet/cfg/";
    public static final String DB_TEMPLET_DIR = TOOLS_BASE_RESOURCES_DIR + "/templet/db/";
    public static final String EXECEL_DIR = TOOLS_BASE_RESOURCES_DIR + "/excel";


    /**
     * *********************************TAG*****************************
     */
    public static final String PACAKAGE_NAME_TAG = "#packageName#";
    public static final String CLASS_NAME_TAG = "#className#";
    public static final String CONSTRUCT_TAG = "#construct#";
    public static final String TO_STRING_TAG = "#toString#";
    public static final String DATE_TAG = "#date";


    public static final String FIELD_AREA_TAG = "#fieldArea#";
    public static final String ANNOTATION_TAG = "#annotation#";
    public static final String FIELD_TAG = "#field#";
    public static final String FIELD_TYPE_TAG = "#fieldType#";
    public static final String TEPMLET_CLASS_NAME_TAG = "#templetClassName#";
    public static final String XML_PATH_TAG = "#xmlPath#";


    public static final String XMl_NODE_TAG = "#xmlNode#";


    public static final String MANUAL_WORK_TAG = "$manualWork$";
    public static final String MAP_NAME_TAG = "#mapName#";
    public static final String METHOD_NAME_TAG = "#methodName#";

    public static final String DTO_CLASS_NAME_TAG = "#DTOclassName#";

    /**
     * *********************************TAG*****************************
     */


    public static final String JAVA_TEMPLET_FILE = "xTemplet.txt";


    public static final String JAVA_TEMPLET_CFG_FILE = "TempletCfg.txt";
    public static final String FIELD_TEMPLET_FILE = "fieldTemplet.txt";

    public static final String MANUAL_WORK_BEGIN = "/*自定义代码开始*/";

    public static final String JAVA_FILE_SUFFIXES = ".java";
    /**
     * excel文件的head行数
     */
    public static final int EXCEL_HEAD_COUNT = 4;

    public static final String MANUAL_WORK_END = "/*自定义代码结束*/";

}
