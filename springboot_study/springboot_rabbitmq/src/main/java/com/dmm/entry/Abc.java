package com.dmm.entry;

import com.alibaba.fastjson.JSON;

import java.util.UUID;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/4/17 18:39
 * @motto The more learn, the more found his ignorance.
 */

public class Abc {
    public static void main(String[] args) {

        VmCommand vmCommand=new VmCommand();
        vmCommand.setCommand(0);
        vmCommand.setCommandExplain("分配虚机");
        BusinessProcess businessProcess=new BusinessProcess();
        businessProcess.setBusinessId(1);
        businessProcess.setUuid(UUID.randomUUID().toString());
        vmCommand.setBusinessProcess(businessProcess);
        VmEntry vmEntry=new VmEntry();
        vmEntry.setOprMode("soft");
        vmEntry.setUserName("dmm");
        vmEntry.setUserPwd("123.com");
        vmEntry.setVmConfig(1);
        vmEntry.setVmId(UUID.randomUUID().toString());
        vmEntry.setVmType(1);
        vmCommand.setVmEntry(vmEntry);

        System.out.println(JSON.toJSON(vmCommand));

        ListenerMessage<TestReturnMessage> listenerMessage=new ListenerMessage<>();

        listenerMessage.setCode(200);
        listenerMessage.setMessage("成功");

        TestReturnMessage testReturnMessage=new TestReturnMessage();

        testReturnMessage.setBusinessProcess(businessProcess);
        testReturnMessage.setCommand(0);
        testReturnMessage.setCommandExplain("分配虚机");
        ReturnVmEntry returnVmEntry=new ReturnVmEntry();
        returnVmEntry.setOprMode("soft");
        returnVmEntry.setUserName("dmm");
        returnVmEntry.setUserPwd("123.com");
        returnVmEntry.setVmConfig(1);
        returnVmEntry.setVmId(UUID.randomUUID().toString());
        returnVmEntry.setVmType(1);

        returnVmEntry.setAgentState(0);
        returnVmEntry.setState(0);
        returnVmEntry.setMaintenance(0);
        returnVmEntry.setBalance(100);

        testReturnMessage.setReturnVmEntry(returnVmEntry);

        listenerMessage.setData(testReturnMessage);

        System.out.println(JSON.toJSON(listenerMessage));


        

    }
}

