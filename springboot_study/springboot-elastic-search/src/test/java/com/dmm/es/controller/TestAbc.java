package com.dmm.es.controller;

import com.dmm.es.SpringBootElasticSearchApplication;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/5/12 18:21
 * @motto The more learn, the more found his ignorance.
 */
@SpringBootTest(classes = SpringBootElasticSearchApplication.class)
@RunWith(SpringRunner.class)
public class TestAbc {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Autowired

    @Test
    public void aa(){

        //restHighLevelClient.
        System.out.println("dtvgbhjnmkl,");
    }
}

