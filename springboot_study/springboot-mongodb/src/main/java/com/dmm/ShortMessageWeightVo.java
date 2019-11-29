package com.dmm;

import java.io.Serializable;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/11/29 15:21
 * @motto The more learn, the more found his ignorance.
 */

public class ShortMessageWeightVo implements Serializable {

    private String requestUrl;

    private int weight;

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ShortMessageWeightVo{" +
                "requestUrl='" + requestUrl + '\'' +
                ", weight=" + weight +
                '}';
    }
}

