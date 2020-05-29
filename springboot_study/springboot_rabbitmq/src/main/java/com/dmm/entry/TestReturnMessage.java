package com.dmm.entry;

import lombok.Data;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/4/20 9:44
 * @motto The more learn, the more found his ignorance.
 */
@Data
public class TestReturnMessage {

    /**
     * 指令编号
     * 0 分配虚机
     * 1 开启虚机
     * 2 关闭虚机
     * 3 重启虚机
     * 4 销毁虚机
     * 5 重新分配
     * 6 库存查询
     * 7 虚机状态
     * 8 虚机更换
     */
    private Integer command;
    /**
     * 指令说明
     */
    private String commandExplain;
    /**
     * 虚机参数
     */
    private ReturnVmEntry returnVmEntry;

    /**
     * 业务参数返回
     */
    private BusinessProcess businessProcess;
}

