package com.smart.dao;

import com.smart.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void insertLoginLog(LoginLog loginLog) {

        String sql = "INSERT INTO t_login_log (user_id, ip, login_datetime) VALUES(?, ?, ?)";

        Object[] args = {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()};
        jdbcTemplate.update(sql, args);

    }

}
