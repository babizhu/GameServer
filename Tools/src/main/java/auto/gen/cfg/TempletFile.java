package auto.gen.cfg;

import auto.gen.util.D;
import auto.gen.util.Util;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-5
 * Time: 下午5:30
 */
class TempletFile {
    private final String templetPath;

    public TempletFile(String templetPath) {
        this.templetPath = D.JAVA_CLASS_TEMPLET_DIR + templetPath;
    }

    public String getTempletStr() {

        return Util.readFile(templetPath);
    }

    public static void main(String[] args) {
        String file = "xTemplet.txt";
        TempletFile t = new TempletFile(file);
        System.out.println(t.getTempletStr());

        String a = "fsafa#adfds";
        a = a.replace("#a", "xxxxx");
        System.out.println(a);
    }

}
