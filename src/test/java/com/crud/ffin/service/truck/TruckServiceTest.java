package com.crud.ffin.service.truck;

import com.crud.ffin.service.domain.Truck;
import com.crud.ffin.service.truck.TruckService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration( locations = { "classpath:config/context-aspect.xml",
        "classpath:config/context-common.xml",
        "classpath:config/context-mybatis.xml",
        "classpath:config/context-transaction.xml" })

public class TruckServiceTest {

    /**
     *
     */
    //==>@RunWith,@ContextConfiguration 이용 Wiring, Test 할 instance DI
    @Autowired
    @Qualifier("truckServiceImpl")
    private TruckService truckService;

    @Test
    public void testAddTruck() throws Exception {
        Truck truck = new Truck();
        truck.setTruckId("testTruckId");
        truck.setTruckCEOName("testTruckCEOName");
        truck.setTruckPhone("000-0000-0000");
        truck.setTruckEmail("abc@gmail.com");
        truck.setTruckName("testTruckName");
        truck.setTruckBusiLice("aaa.jpg");
        truck.setTruckCate(8);
        truck.setTruckJoinReqStatus(Integer.parseInt("1"));
        truck.setTruckJoinReqDate(Date.valueOf("2021-12-20"));
        truck.setTruckBusiStatus(0);
        truck.setTruckRegDate(Date.valueOf("2021-12-20"));
        truck.setRole(1);

        truckService.addTruck(truck);

        truck = truckService.getTruck("testTruckId");

        //==> console 확인
        //System.out.println(truck);

        //==> API 확인
        Assert.assertEquals("testTruckId", truck.getTruckId());
        Assert.assertEquals("testTruckCEOName", truck.getTruckCEOName());
        Assert.assertEquals("000-0000-0000", truck.getTruckPhone());
        Assert.assertEquals("abc@gmail.com", truck.getTruckEmail());
        Assert.assertEquals("testTruckName", truck.getTruckName());
        Assert.assertEquals("aaa.jpg", truck.getTruckBusiLice());
        Assert.assertEquals(8, truck.getTruckCate());
        Assert.assertEquals(Integer.parseInt("1"), truck.getTruckJoinReqStatus());
        Assert.assertEquals(Date.valueOf("2021-12-20"), truck.getTruckJoinReqDate());
        Assert.assertEquals(0, truck.getTruckBusiStatus());
        Assert.assertEquals(Date.valueOf("2021-12-20"), truck.getTruckJoinReqDate());
        Assert.assertEquals(1, truck.getRole());
    }


    //@Test
    void getTruck() {
    }

    //@Test
    void getNotice() {
    }

    //@Test
    void getTruckProfile() {
    }

    //@Test
    void getTruckInfo() {
    }

    //@Test
    void getNewTruck() {
    }

    //@Test
    void updateTruck() {
    }

    //@Test
    void findTruck() {
    }

    //@Test
    void updateTruckProfile() {
    }

    //@Test
    void updateTruckInfo() {
    }

    //@Test
    void updateBusiStatus() {
    }

    //@Test
    void testUpdateBusiStatus() {
    }

    //@Test
    void updateNotice() {
    }

    //@Test
    void updateTruckPassword() {
    }

    //@Test
    void getTruckList() {
    }

    //@Test
    void getNewTruckList() {
    }

    //@Test
    void login() {
    }

    //@Test
    void logout() {
    }

    //@Test
    void findTruckId() {
    }

    //@Test
    void byeTruck() {
    }

    //@Test
    void uploadFile() {
    }

    //@Test
    void sendEmail() {
    }

    //@Test
    void emailAuth() {
    }

    //@Test
    void messageAuth() {
    }

    //@Test
    void captchaAuth() {
    }

    //@Test
    void busiLiceAuth() {
    }

    //@Test
    void getTotalCount() {
    }
}