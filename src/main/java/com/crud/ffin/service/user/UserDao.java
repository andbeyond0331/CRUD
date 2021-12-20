package com.crud.ffin.service.user;

import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.Report;
import com.crud.ffin.service.domain.User;

import java.util.Map;

public interface UserDao {

    //  *** user ***

    //id 중복체크
    public String idChkDuplication(String userId) throws Exception;
    //Email 중복체크
    public String emailChkDuplication(String userEmail) throws Exception;
    //phone 중복체크
    public String phoneChkDuplication(String userPhone) throws Exception;


    //회원가입
    public void addUser(User user) throws Exception;
    //회원정보
    public User getUser(String userId) throws Exception;
    //회원목록
    public Map<String, Object> getUserList(Search search) throws Exception;

    //id 찾기
    public String findUserId(String userId) throws Exception;
    //pw 수정
    public void updatePassword(User user) throws Exception;
    //정보수정
    public void updateUserInfo(User user) throws Exception;
    //프로필수정
    public void updateUserProfile(User user) throws Exception;
    //위치수정
    public void updateUserMap(User user) throws Exception;
    //탈퇴
    public void updateUserByeStatus(User user) throws Exception;


    // *** admin ***

    //블랙여부
    public void updateBlackStatus(User user) throws Exception;


    // *** Report ***

    //신고등록
    public void addReport(Report report) throws Exception;
    //신고보기
    public Report getReport(int reportNo) throws Exception;
    //신고목록
    public Map<String, Object> getReportList(Search search) throws Exception;

    //page 처리
    public int getTotalCount(Search search) throws Exception;


}
