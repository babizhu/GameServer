package command.service;

import command.dto.recharge.RechargeData;

/**
 * Created by Administrator on 14-3-11.
 */
public enum RechargeServiceImpl implements IService{
    INSTANCE;

    @Override
    public RechargeData getData(){
        RechargeData data = new RechargeData();
        data.setName( "abc" );
        data.setAmount( 300 );

        return data;
    }

    public String getName(){
        return "aa";
    }
}
