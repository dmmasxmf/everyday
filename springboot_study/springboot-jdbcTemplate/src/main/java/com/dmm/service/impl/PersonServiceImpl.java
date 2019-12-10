package com.dmm.service.impl;

import com.dmm.mapper.UserNoteMapper;
import com.dmm.service.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/9 11:33
 * @motto The more learn, the more found his ignorance.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private UserNoteMapper userNoteMapper;

    @Override
    @Transactional
    public void addUser() {
        userNoteMapper.addUser("vdstygbhnjkm","vsdgbhmk,");
        System.out.println(1/0);
    }
}

