package experiment.serialize.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.bbz.util.serialize.Serialize;
import org.msgpack.annotation.Message;

/**
 * Created by Administrator on 14-3-21.
 */

@Message
@AllArgsConstructor
@Data
@ToString
public class SimpleChallenger implements IChallenger{
    private String userId;
    private String nickName;
    private int reputation;
    private int allDamage;
    private int rank;

    public SimpleChallenger(){
    }

    public static void main(String[] args){
        IChallenger simpleChallenger = new SimpleChallenger("liukun", "刘老爷", 200, 1000, 1);
        byte[] encode = Serialize.getInstance().encode(simpleChallenger);
        SimpleChallenger simpleChallenger1 = Serialize.getInstance().decode(encode, SimpleChallenger.class);
        System.out.println(simpleChallenger1);
    }
}
