package com.dmm.entry;

import lombok.Data;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/4/17 16:57
 * @motto The more learn, the more found his ignorance.
 */
@Data
public class VmEntry {

    // 虚机开机 虚机关闭 虚机重启

    /**
     * 虚机类型 （1：office，2：online，3 game，5：nas01，6：nas02）
     */
    private int vmType;
    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPwd;
    /**
     * 虚机标识
     */
    private String vmId;

    /**
     * 重启方式 hard:硬重启，soft:软重启 虚机重启
     */
    private String oprMode;

    /**
     * 虚机配置 1:低端 2:中端 3:高端 100:翱游公司
     */
    private int vmConfig;

}

