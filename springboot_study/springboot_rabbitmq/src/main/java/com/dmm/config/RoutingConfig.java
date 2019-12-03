package com.dmm.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author Mr. Du
 * @explain 路由
 * @createTime 2019/12/1 19:15
 * @motto The more learn, the more found his ignorance.
 */
@Configuration
public class RoutingConfig {

    private String routing1="1";

    private String routing2="2";

    private String routing3="3";

    private String routing4="4";

    private String routing5="5";

    public String getRouting1() {
        return routing1;
    }

    public void setRouting1(String routing1) {
        this.routing1 = routing1;
    }

    public String getRouting2() {
        return routing2;
    }

    public void setRouting2(String routing2) {
        this.routing2 = routing2;
    }

    public String getRouting3() {
        return routing3;
    }

    public void setRouting3(String routing3) {
        this.routing3 = routing3;
    }

    public String getRouting4() {
        return routing4;
    }

    public void setRouting4(String routing4) {
        this.routing4 = routing4;
    }

    public String getRouting5() {
        return routing5;
    }

    public void setRouting5(String routing5) {
        this.routing5 = routing5;
    }

}

