package com.dmm.config;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/3/30 9:25
 * @motto The more learn, the more found his ignorance.
 */

public class MyChannelHandlerPool {

    public MyChannelHandlerPool(){}

    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}

