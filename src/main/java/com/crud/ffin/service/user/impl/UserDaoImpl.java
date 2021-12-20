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


    @Override
    public String idChkDuplication(String userId) throws Exception {
        return sqlSession.selectOne("UserMapper.idChkDuplication", userId);
    }

    @Override
    public String emailChkDuplication(String userEmail) throws Exception {
        return sqlSession.selectOne("UserMapper.emailChkDuplication", userEmail);
    }

    @Override
    public String phoneChkDuplication(String userPhone) throws Exception {
        return sqlSession.selectOne("UserMapper.phoneChkDuplication", userPhone);
    }

    @Override
    public void addUserInfo(User user) throws Exception {
        sqlSession.insert("UserMapper.addUserInfo", user);
    }

    @Override
    public User getUser(String userId) throws Exception {
        return sqlSession.selectOne("UserMapper.getUser", userId);
    }

    @Override
    public Map<String, Object> getUserList(Search search) throws Exception {
        return null;
    }

    @Override
    public String findUserId(String userId) throws Exception {
        return sqlSession.selectOne("UserMapper.getUserId",userId);
    }

    @Override
    public void updatePassword(User user) throws Exception {
        sqlSession.update("UserMapper.updatePassword", user);
    }

    @Override
    public void updateUserInfo(User user) throws Exception {
        sqlSession.update("UserMapper.updateUserInfo", user);
    }

    @Override
    public void updateUserProfile(User user) throws Exception {
        sqlSession.update("UserMapper.updateUserProfile", user);
    }

    @Override
    public void updateUserMap(User user) throws Exception {
        sqlSession.update("UserMapper.updateUserMap",user);
    }

    @Override
    public void updateUserByeStatus(User user) throws Exception {
        sqlSession.update("UserMapper.updateUserByeStatus", user);
    }

    @Override
    public void updateBlackStatus(User user) throws Exception {
        sqlSession.update("UserMapper.updateBlackStatus", user);
    }

    @Override
    public void addReport(Report report) throws Exception {
        sqlSession.insert("UserMapper.addReport",report);
    }

    @Override
    public Report getReport(int reportNo) throws Exception {
        return sqlSession.selectOne("UserMapper.getReport", reportNo);
    }

    @Override
    public Map<String, Object> getReportList(Search search) throws Exception {
        return null;
    }

    @Override
    public int getTotalCount(Search search) throws Exception {
        return 0;
    }
}
