package experiment.serialize.entity;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.ToString;
import org.bbz.util.serialize.Serialize;
import org.msgpack.annotation.Message;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 14-3-21.
 */

@Message
@ToString
@Data
public class BossBattleHistory{
    private static final String KEY = "BossBattleActivity";

    Map<Integer, SimpleChallenger> map;
    private RankInfoWithKiller history;
    private final int bossHpMax;


    BossBattleHistory(int bossHpMax){
        map = Maps.newHashMap();
        for( int i = 0; i < 10; i++ ) {
            SimpleChallenger sc = new SimpleChallenger("liukun", "刘老爷", i * 10, i * 100, i);
            map.put(i, sc);
        }
        List<IChallenger> list = Lists.newArrayList();
        history = new RankInfoWithKiller();
        history.setData();
        this.bossHpMax = bossHpMax;
    }

    public BossBattleHistory(){
        bossHpMax = 99999;
    }

    /**
     * 先保存到档期表，完成之后再换
     */
    void saveHistory(List<IChallenger> topTen, IChallenger killer){


    }

    /**
     * 如果数据库不存在，则返回空
     */
    void loadHistory(){

    }

    public RankInfoWithKiller get(){
        return history;
    }

    public static void main(String[] args){
        BossBattleHistory bh = new BossBattleHistory(9999);

        byte[] encode = Serialize.getInstance().encode(bh);
        BossBattleHistory bh1 = Serialize.getInstance().decode(encode, BossBattleHistory.class);
        System.out.println(bh1);
        System.out.println(bh1.getMap().size());
        System.out.println(bh1.getMap().get(2));


//        bh1.get


    }

    /**
     * @return bossHpMax
     */
    public int getBossHpMax(){
        return bossHpMax;
    }


}
