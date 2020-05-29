package com.dmm;

import com.dmm.config.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/3/29 17:24
 * @motto The more learn, the more found his ignorance.
 */
@SpringBootApplication
public class SpringbootNettyApplication {

    public static void main(String[] args) {

//        String a="15738669005";
//        System.out.println(a.substring(7));

        SpringApplication.run(SpringbootNettyApplication.class,args);
        try {
            //启动netty
            new NettyServer(12345).start();

            System.out.println("https://blog.csdn.net/moshowgame");
            System.out.println("http://127.0.0.1:6688/netty-websocket/index");
        }catch(Exception e) {
            System.out.println("NettyServerError:"+e.getMessage());
        }
    }

}

