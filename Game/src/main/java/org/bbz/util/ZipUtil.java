package org.bbz.util;

import org.apache.tools.bzip2.CBZip2InputStream;
import org.apache.tools.bzip2.CBZip2OutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.*;

/**
 * 压缩工具
 */
@SuppressWarnings("UnusedDeclaration")
public class ZipUtil{
    /**
     * 压缩GZip
     *
     * @param data 输入数据
     * @return 压缩后的数据
     */
    public static byte[] gZip( byte[] data ){
        byte[] b = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            GZIPOutputStream gzip = new GZIPOutputStream( bos );
            gzip.write( data );
            gzip.finish();
            gzip.close();
            b = bos.toByteArray();
            bos.close();
        } catch( Exception ex ) {
            ex.printStackTrace();
        }
        return b;
    }

    /**
     * 解压GZip
     *
     * @param data 输入数据
     * @return 压缩后的数据
     */
    public static byte[] unGZip( byte[] data ){
        byte[] b = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream( data );
            GZIPInputStream gzip = new GZIPInputStream( bis );
            byte[] buf = new byte[1024];
            int num;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while( (num = gzip.read( buf, 0, buf.length )) != -1 ) {
                baos.write( buf, 0, num );
            }
            b = baos.toByteArray();
            baos.flush();
            baos.close();
            gzip.close();
            bis.close();
        } catch( Exception ex ) {
            ex.printStackTrace();
        }
        return b;
    }


    /**
     * 压缩Zip
     *
     * @param data 输入数据
     * @return 压缩后的数据
     */
    public static byte[] zip( byte[] data ){
        byte[] b = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ZipOutputStream zip = new ZipOutputStream( bos );
            ZipEntry entry = new ZipEntry( "zip" );
            entry.setSize( data.length );
            zip.putNextEntry( entry );
            zip.write( data );
            zip.closeEntry();
            zip.close();
            b = bos.toByteArray();
            bos.close();
        } catch( Exception ex ) {
            ex.printStackTrace();
        }
        return b;
    }

    /**
     * 解压Zip
     *
     * @param data 输入数据
     * @return 压缩后的数据
     */
    public static byte[] unZip( byte[] data ){
        byte[] b = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream( data );
            ZipInputStream zip = new ZipInputStream( bis );
            while( zip.getNextEntry() != null ) {
                byte[] buf = new byte[1024];
                int num;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                while( (num = zip.read( buf, 0, buf.length )) != -1 ) {
                    baos.write( buf, 0, num );
                }
                b = baos.toByteArray();
                baos.flush();
                baos.close();
            }
            zip.close();
            bis.close();
        } catch( Exception ex ) {
            ex.printStackTrace();
        }
        return b;
    }


    /**
     * 压缩BZip2
     *
     * @param data 输入数据
     * @return 压缩后的数据
     */
    public static byte[] bZip2( byte[] data ){
        byte[] b = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            CBZip2OutputStream bzip2 = new CBZip2OutputStream( bos );
            bzip2.write( data );
            bzip2.flush();
            bzip2.close();
            b = bos.toByteArray();
            bos.close();
        } catch( Exception ex ) {
            ex.printStackTrace();
        }
        return b;
    }

    /**
     * 解压BZip2
     *
     * @param data 输入数据
     * @return 压缩后的数据
     */
    public static byte[] unBZip2( byte[] data ){
        byte[] b = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream( data );
            CBZip2InputStream bzip2 = new CBZip2InputStream( bis );
            byte[] buf = new byte[1024];
            int num;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while( (num = bzip2.read( buf, 0, buf.length )) != -1 ) {
                baos.write( buf, 0, num );
            }
            b = baos.toByteArray();
            baos.flush();
            baos.close();
            bzip2.close();
            bis.close();
        } catch( Exception ex ) {
            ex.printStackTrace();
        }
        return b;
    }


    /**
     * 把字节数组转换成16进制字符串
     *
     * @param data 输入数据
     * @return 压缩后的数据
     */
    public static String bytesToHexString( byte[] data ){
        StringBuilder sb = new StringBuilder( data.length );
        String sTemp;
        for( byte aData : data ) {
            sTemp = Integer.toHexString( 0xFF & aData );
            if( sTemp.length() < 2 ) {
                sb.append( 0 );
            }
            sb.append( sTemp.toUpperCase() );
        }
        return sb.toString();
    }


//    /**
//     *jzlib 压缩数据
//     *
//     * @param object
//     * @return
//     */
//    public static byte[] jzlib(byte[] object) {
//
//        byte[] data = null;
//        try {
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            ZOutputStream zOut = new ZOutputStream(out,
//                    JZlib.Z_DEFAULT_COMPRESSION);
//            DataOutputStream objOut = new DataOutputStream(zOut);
//            objOut.write(object);
//            objOut.flush();
//            zOut.close();
//            data = out.toByteArray();
//            out.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return data;
//    }
//
//    /**
//     *jzLib压缩的数据
//     *
//     * @param object
//     * @return
//     * @throws IOException
//     */
//    public static byte[] unjzlib(byte[] object) {
//
//        byte[] data = null;
//        try {
//            ByteArrayInputStream in = new ByteArrayInputStream(object);
//            ZInputStream zIn = new ZInputStream(in);
//            byte[] buf = new byte[1024];
//            int num = -1;
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            while ((num = zIn.read(buf, 0, buf.length)) != -1) {
//                baos.write(buf, 0, num);
//            }
//            data = baos.toByteArray();
//            baos.flush();
//            baos.close();
//            zIn.close();
//            in.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return data;
//    }
}
