package com.dmm.entry;

import lombok.Data;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/4/20 9:20
 * @motto The more learn, the more found his ignorance.
 */
@Data
public class ReturnVmEntry extends VmEntry{

    private Integer balance;

    /**
     * vm状态码
     * 0：未定义
     * 5：关机
     * 3：运行中
     * 2：暂停
     * 9：保存
     * 6：开机中
     * 7：关机中
     * 8：恢复中（从暂停中恢复）
     * 4：暂停中
     */
    private Integer state;

    /**
     * 连接状态码
     * 0：不可用 1：可连接
     */
    private Integer agentState;

    /**
     * 0：维护模式关闭状态
     * 1：维护模式开启状态
     */
    private Integer maintenance;
}

