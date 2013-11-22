package org.bbz.util.db;

import org.bbz.util.serialize.Serialize;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: liukun
 * Date: 13-11-16
 * Time: 上午12:09
 */


public enum KeyValueDB {
    INSTANCE;

    <T> void save(String key, T v) {
        byte[] bytes = Serialize.getInstance().encode(v);
        //TODO 保存到数据库
    }

    <T> T load(String key, Class<T> clazz) {
        return null;
    }

    void remove(String key) {
    }

    public static void main(String[] args) throws IOException {
        // ISerialize
    }
}
