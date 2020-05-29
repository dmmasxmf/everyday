package com.dmm.entry;

import lombok.Getter;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/4/17 17:46
 * @motto The more learn, the more found his ignorance.
 */
@Getter
public enum BusinessEnum {

    //水晶购买虚机
    CRYSTAL_BY_VM(0, 1),
    //金钱购买
    MONEY_BY_VM(0, 2),
    //激活码购买
    ACTIVATE_BY_VM(0, 3),
    //后台订单购买
    ADMIN_BY_VM(0, 4),
    //开启虚机
    START_VM(1, 0),
    //停止虚机
    STOP_VM(2, 0),
    //重启虚机
    RESTART_VM(3, 0),
    //删除虚机
    DELETE_VM(4, 0),
    //重新分配
    REASSIGN_VM(5, 0),
    //虚机更换 进入自己延迟队列
    VM_NEW_VM(8, 0),
    //虚机库存
    VM_STOCK(6, 5),
    //虚机状态 自己轮询
    VM_STATE(7, 6);

    /**
     * 底层指令
     */
    private Integer command;

    /**
     * 业务类型
     */
    private Integer businessId;

    BusinessEnum(Integer command, Integer businessId) {
        this.command = command;
        this.businessId = businessId;
    }

    public static BusinessEnum getBusinessEnum(Integer command,Integer businessId) {

        for (BusinessEnum value : BusinessEnum.values()) {
            if(value.command.equals(command) && value.businessId.equals(businessId)){
                return value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getBusinessEnum(1,0));
        System.out.println(BusinessEnum.START_VM.name());
        System.out.println(BusinessEnum.START_VM.getCommand());
    }
}

