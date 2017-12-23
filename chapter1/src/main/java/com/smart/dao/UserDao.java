package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int getMatchCount(String username, String password) {

        String sql = "SELECT count(*) FROM t_user WHERE user_name = ? and password = ?";
        return jdbcTemplate.queryForInt(sql, new Object[]{username, password});
    }

    public User findUserByName(final String name) {

        String sql = "SELECT * from t_user where user_name = ?";
        final User user = new User();
        jdbcTemplate.query(sql, new Object[]{name}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserName(name);
                user.setUserId(resultSet.getInt("user_id"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user) {
        String sql = "UPDATE t_user SET last_visit = ? , last_id = ? WHERE user_id = ?";
        jdbcTemplate.update(sql, new Object[]{user.getLastVisit(), user.getLastIp(), user.getUserId()});
    }

}
