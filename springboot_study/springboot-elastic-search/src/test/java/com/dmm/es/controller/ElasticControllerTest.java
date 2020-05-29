package com.dmm.es.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/5/12 11:51
 * @motto The more learn, the more found his ignorance.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ElasticControllerTest {

//    @Autowired
//    IElasticService iElasticService;


//    @Autowired
//    ElasticsearchRestTemplate template;

//    @Autowired
//    RestHighLevelClient restHighLevelClient;

    /**
     * Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
     * <p>
     * src/main/java和/src/test/java里面的包名不一样。设置为同一个名称包名就可以了
     */
    @Test
    public void create() {
//        template.createIndex(DocBean.class);

        //restHighLevelClient.indices().create()
    }

    @Test
    public void saveAll(){


//        for (int i=0;i<1000000;i++){
//            DocBean docBean=new DocBean();
//
//            docBean.setContent("孙雪凯是不是不是傻逼傻逼傻逼");
//            docBean.setFirstCode("1"+i);
//            docBean.setSecordCode("2"+i);
//            docBean.setType(i);
//
//            iElasticService.save(docBean);
//        }

    }


}

