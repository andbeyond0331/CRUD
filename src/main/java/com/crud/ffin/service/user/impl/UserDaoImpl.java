package com.crud.ffin.service.user.impl;

import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.Report;
import com.crud.ffin.service.domain.User;
import com.crud.ffin.service.user.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {

    //Field
    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSession sqlSession;
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    //Constructor
    public UserDaoImpl() {
        System.out.println("Default Constructor :: UserDaoImpl.UserDaoImpl");
    }

    //Method
    @Override
    public String idChkDuplication(String userId) throws Exception {
        return null;
    }

    @Override
    public String emailChkDuplication(String userEmail) throws Exception {
        return null;
    }

    @Override
    public void addUser(User user) throws Exception {

    }

    @Override
    public User getUser(String userId) throws Exception {
        return null;
    }

    @Override
    public Map<String, Object> getUserList(Search search) throws Exception {
        return null;
    }

    @Override
    public String findUserId(String userId) throws Exception {
        return null;
    }

    @Override
    public void updatePassword(User user) throws Exception {

    }

    @Override
    public void updateUser(User user) throws Exception {

    }

    @Override
    public void updateUserByeStatus(User user) throws Exception {

    }

    @Override
    public void updateBlackStatus(User user) throws Exception {

    }

    @Override
    public void addReport(Report report) throws Exception {

    }

    @Override
    public void updateReport(int reportNo) throws Exception {

    }

    @Override
    public Report getReport(int reportNo) throws Exception {
        return null;
    }

    @Override
    public Map<String, Object> getReportList(Search search) throws Exception {
        return null;
    }

    @Override
    public void deleteReport(String reportNo) throws Exception {

    }

    @Override
    public int getTotalCount(Search search) throws Exception {
        return 0;
    }
}
