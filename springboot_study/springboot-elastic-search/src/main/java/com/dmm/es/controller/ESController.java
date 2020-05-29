package com.dmm.es.controller;

import com.dmm.es.entry.DocBean;
import com.dmm.es.service.IElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/5/12 16:31
 * @motto The more learn, the more found his ignorance.
 */
@RestController
public class ESController {

    @Autowired
    private IElasticService iElasticService;

    @GetMapping("/dmm")
    public void save(){

        List<DocBean> list=new ArrayList<>();

        for (int i=0;i<10000;i++){
            DocBean docBean=new DocBean();

            docBean.setContent("孙雪凯是不是不是傻逼傻逼傻逼");
            docBean.setFirstCode("1"+i);
            docBean.setSecordCode("2"+i);
            docBean.setType(i);
            docBean.setId(Integer.toUnsignedLong(i));
            list.add(docBean);

        }
        iElasticService.saveAll(list);
    }
}

