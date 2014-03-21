package command.dto.recharge;

import lombok.Data;

/**
 * 网络层的交互数据
 */
@Data
public class RechargeData{
    private int amount;
    private String name;
}
