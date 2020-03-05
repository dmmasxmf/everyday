package com.dmm.mapper;

import com.dmm.entry.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2020/3/3 15:41
 * @motto If you would have leisure, do not waste it.
 */
@Repository
public interface UserMapper extends JpaRepository<User,Long> {

    /**
     * 查询用户名
     * @param login
     * @return
     */
    @Query(value = "select * from user where login=?1",nativeQuery = true)
    User selectByLogin(String login);
}
