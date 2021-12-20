package com.crud.ffin.service.user.test;

import com.crud.ffin.service.domain.User;
import com.crud.ffin.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = { "classpath:config/context-aspect.xml",
                                        "classpath:config/context-common.xml",
                                        "classpath:config/context-mybatis.xml",
                                        "classpath:config/context-transaction.xml" })
public class UserServiceTest {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    //@Test
    void testIdChkDuplication() {
    }

    //@Test
    void testEmailChkDuplication() {
    }

    //@Test
    void testPhoneChkDuplication() {
    }

    @Test
    public void testAddUserInfo() throws Exception {
        User user = new User();
        user.setUserId("testUserId");
        user.setUserPassword("test00");
        user.setUserName("test");
        user.setUserPhone("010-1234-5678");
        user.setUserBirth("2021-12-25");
        user.setUserAddr("testAddr");
        user.setUserAddrDetail("testAddrDetail");
        user.setUserEmail("test@test.com");

        System.out.println("안녕"+user);

        userService.addUserInfo(user);

    }

   //@Test
    void testGetUser() {
    }

    //@Test
    void testGetUserList() {
    }

    //@Test
    void testFindUserId() {
    }

    //@Test
    void testUpdatePassword() {
    }

    //@Test
    void testUpdateUserInfo() {
    }

    //@Test
    void testUpdateUserProfile() {
    }

    //@Test
    void testUpdateUserMap() {
    }

    //@Test
    void testUpdateUserByeStatus() {
    }

    //@Test
    void testUpdateBlackStatus() {
    }

    //@Test
    void testAddReport() {
    }

    //@Test
    void testGetReport() {
    }

    //@Test
    void testGetReportList() {
    }
}