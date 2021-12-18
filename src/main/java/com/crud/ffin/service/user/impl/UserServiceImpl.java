package com.crud.ffin.service.user.impl;

import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.Report;
import com.crud.ffin.service.domain.User;
import com.crud.ffin.service.user.UserDao;
import com.crud.ffin.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    //Field
    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //Constructor
    public UserServiceImpl() {
        System.out.println("Default Constructor :: UserServiceImpl.UserServiceImpl");
    }


    //Method
    @Override
    public String idChkDuplication(String userId) throws Exception {
        System.out.println("UserServiceImpl.idChkDuplication");
        return userDao.idChkDuplication(userId);
    }

    @Override
    public String emailChkDuplication(String userEmail) throws Exception {
        System.out.println("UserServiceImpl.emailChkDuplication"); // soutm + tab키
        return userDao.emailChkDuplication(userEmail);
    }

    @Override
    public void addUser(User user) throws Exception {
        System.out.println("UserServiceImpl.addUser");
        userDao.addUser(user);
    }

    @Override
    public User getUser(String userId) throws Exception {
        System.out.println("UserServiceImpl.getUser");
        return userDao.getUser(userId);
    }

    @Override
    public Map<String, Object> getUserList(Search search) throws Exception {
        System.out.println("UserServiceImpl.getUserList");
        return userDao.getUserList(search);
    }

    @Override
    public String findUserId(String userId) throws Exception {
        System.out.println("UserServiceImpl.findUserId");
        return userDao.findUserId(userId);
    }

    @Override
    public void updatePassword(User user) throws Exception {
        System.out.println("UserServiceImpl.updatePassword");
        userDao.updatePassword(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        System.out.println("UserServiceImpl.updateUser");
        userDao.updateUser(user);
    }

    @Override
    public void updateUserByeStatus(User user) throws Exception {
        System.out.println("UserServiceImpl.updateUserByeStatus");
        userDao.updateUserByeStatus(user);
    }

    @Override
    public void updateBlackStatus(User user) throws Exception {
        System.out.println("UserServiceImpl.updateBlackStatus");
        userDao.updateBlackStatus(user);
    }

    @Override
    public void addReport(Report report) throws Exception {
        System.out.println("UserServiceImpl.addReport");
        userDao.addReport(report);
    }

    @Override
    public void updateReport(int reportNo) throws Exception {
        System.out.println("UserServiceImpl.updateReport");
        userDao.updateReport(reportNo);
    }

    @Override
    public Report getReport(int reportNo) throws Exception {
        System.out.println("UserServiceImpl.getReport");
        return userDao.getReport(reportNo);
    }

    @Override
    public Map<String, Object> getReportList(Search search) throws Exception {
        System.out.println("UserServiceImpl.getReportList");
        return userDao.getReportList(search);
    }

    @Override
    public void deleteReport(String reportNo) throws Exception {
        System.out.println("UserServiceImpl.deleteReport");
        userDao.deleteReport(reportNo);
    }
}
