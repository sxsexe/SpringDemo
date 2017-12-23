package com.smart.service;


import com.smart.dao.LoginDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginDao loginDao;

    public boolean hasMatchUser(String username, String password) {
        int matchCount = userDao.getMatchCount(username, password);
        return matchCount > 0;
    }

    public User findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    public void loginSuccess(User user) {
        LoginLog loginLog = new LoginLog();
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        loginLog.setUserId(user.getUserId());
        loginDao.insertLoginLog(loginLog);
    }

}
