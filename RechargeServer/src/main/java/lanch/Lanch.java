package lanch;

import org.xsocket.connection.IConnection;
import org.xsocket.connection.IServer;
import org.xsocket.connection.Server;
import server.ServerConfig;
import server.TestHandler;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;

/**
 * Created by Administrator on 14-3-6.
 */
public class Lanch{
    private static final int PORT = 8888;

    public static void main(String[] args) throws IOException{

        ServerConfig cfg = ServerConfig.INSTANCE;

//        HttpServer srv = new HttpServer(80, new MethodInfoHandler());

        //注意其构造方法有多个。一般是使用这种构造方法出来的！
        //不过要注意一下java.net.InetAddress这个类的使用在初始化的时候需要捕获异常
        //可能是这个绑定的主机可能不存在之类的异常即UnknowHostNameException
        InetAddress address = InetAddress.getByName(cfg.getIp());
        //创建一个服务端的对象
        IServer srv = new Server(address, cfg.getPort(), new TestHandler());
//        srv.setConnectionTimeoutMillis( 5000 );
        //srv.setIdleTimeoutMillis( 30000 );
        //设置当前的采用的异步模式
        srv.setFlushmode(IConnection.FlushMode.ASYNC);
        try {
            // srv.run();
            // the call will not return
            // ... or start it by using a dedicated thread
            srv.start(); // returns after the server has been started
            System.out.println("服务器" + srv.getLocalAddress() + ":" + PORT);
            Map<String, Class> maps = srv.getOptions();
            if( maps != null ) {

                for( Map.Entry<String, Class> entry : maps.entrySet() ) {
                    System.out.println("key= " + entry.getKey() + " value =" + entry.getValue().getName());
                }
            }
            System.out.println("日志: " + srv.getStartUpLogMessage());

        } catch( Exception e ) {
            System.out.println(e);
        }

    }
}
