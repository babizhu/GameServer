package server;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 14-3-6.
 * 配置表文件
 */
public enum ServerConfig{
    INSTANCE;

    private Properties p = new Properties();

    ServerConfig(){

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("ipConfig.properties");
        try {
            p.load(inputStream);
        } catch( IOException e1 ) {
            e1.printStackTrace();
        }
//        System.out.println("ip:"+p.getProperty("ip")+",port:"+p.getProperty("port"));
    }

    public String getIp(){
        return p.getProperty("ip");
    }

    public int getPort(){
        return Integer.parseInt(p.getProperty("port"));
    }

    public static void main(String[] args){
        System.out.println("test");
    }
}
