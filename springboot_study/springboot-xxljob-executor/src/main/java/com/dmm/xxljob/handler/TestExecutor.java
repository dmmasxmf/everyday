package com.dmm.xxljob.handler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/1/15 14:20
 * @motto The more learn, the more found his ignorance.
 */
@Component
public class TestExecutor {

    private static Logger logger = LoggerFactory.getLogger(TestExecutor.class);

    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("demoJobHandler")
    public ReturnT<String> demoJobHandler(String param) throws Exception {
        XxlJobLogger.log("XXL-JOB, Hello World.");

        for (int i = 0; i < 5; i++) {
            XxlJobLogger.log("beat at:" + i);
            System.out.println("---------------------------------"+param);
            TimeUnit.SECONDS.sleep(2);
        }
        return ReturnT.SUCCESS;
    }

}

