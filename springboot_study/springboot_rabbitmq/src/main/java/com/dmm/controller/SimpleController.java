package com.dmm.controller;

import com.dmm.simple.product.SimpleProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/4 17:09
 * @motto The more learn, the more found his ignorance.
 */
@RestController
public class SimpleController {

    @Autowired
    private SimpleProduct simpleProduct;

    @GetMapping("/simple")
    public String simpleSend(String s){
        //
        simpleProduct.simpleSend2(s);
        simpleProduct.simpleSend(s);
        simpleProduct.simpleSend(s);
        return "----";
    }
}

