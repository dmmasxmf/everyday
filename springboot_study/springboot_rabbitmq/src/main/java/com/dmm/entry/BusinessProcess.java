package com.dmm.entry;

import lombok.Data;

/**
 * @author Mr. Du
 * @explain 业务处理参数
 * @createTime 2020/4/17 17:30
 * @motto The more learn, the more found his ignorance.
 */
@Data
public class BusinessProcess {

    /**
     * 业务参数  例如订单号 ，子订单号
     * 暂存于redis 唯一标识
     */
    private String uuid;

    /**
     * 暂定于
     * 0 虚机指令下发
     * 1 水晶购买虚机
     * 2 金钱购买虚机
     * 3 激活购买虚机
     * 4 后台购买虚机
     * 5 虚机库存查询
     * 6 虚机状态更新
     */
    private Integer businessId;

}

