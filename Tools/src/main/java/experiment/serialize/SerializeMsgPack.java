package experiment.serialize;

import org.msgpack.MessagePack;
import org.msgpack.packer.Packer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liukun
 * Date: 13-11-17
 * Time: 上午12:07
 */


@SuppressWarnings("UnusedDeclaration")
public class SerializeMsgPack{
    public static void main(String[] args) throws IOException{


        List<NpcTemplet> list = new ArrayList<NpcTemplet>();
        for( int i = 0; i < Student.LIST_COUNT; i++ ) {

            NpcTemplet t = new NpcTemplet();
            list.add(t);
        }

//        test3 (list);
        test1();


        // Serialize
    }

    private static void test1() throws IOException{
        Student student = new Student();
        student.name = "msgpack";
        student.age = 100000000;

        MessagePack msgpack = new MessagePack();
        long begin = System.nanoTime();
        int maxLen = 0;
        for( int i = 0; i < Student.COUNT; i++ ) {
            student.age = i;
            byte[] bytes = msgpack.write(student);
            Student s1 = msgpack.read(bytes, Student.class);
            maxLen = Math.max(maxLen, bytes.length);
        }
        System.out.println("maxLen is " + maxLen);

        System.out.println((System.nanoTime() - begin) / 1000000000f);
    }

    private static void test2() throws IOException{
        Student student = new Student();
        student.name = "msgpack";
        student.age = 100000000;

        MessagePack msgpack = new MessagePack();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Packer packer = msgpack.createPacker(out);


        long begin = System.nanoTime();
        int maxLen = 0;
        for( int i = 0; i < Student.COUNT; i++ ) {
            student.age = i;
            packer.write(student);
            //byte[] bytes = msgpack.write (student);
            //msgpack.read (bytes, Student.class);
            //maxLen = Math.max (maxLen, bytes.length);
            //System.out.println ( bytes.length );

        }
        System.out.println("maxLen is " + maxLen);

        System.out.println((System.nanoTime() - begin) / 1000000000f);
    }


    private static void test3(List<NpcTemplet> list) throws IOException{
        int maxLen = 0;
        MessagePack msgpack = new MessagePack();

        long begin = System.nanoTime();
        byte[] bytes = msgpack.write(list);
        System.out.println((System.nanoTime() - begin) / 1000000000f);
        System.out.println("maxLen is " + bytes.length);
        //System.out.println ( jsonString );
    }
}
