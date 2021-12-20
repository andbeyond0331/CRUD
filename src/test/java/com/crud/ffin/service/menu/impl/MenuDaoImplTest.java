package com.crud.ffin.service.menu.impl;

import com.crud.ffin.service.domain.Menu;
import com.crud.ffin.service.menu.MenuService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.junit.jupiter.api.Assertions.*;

class MenuDaoImplTest {

    @Autowired
    @Qualifier("menuServiceImpl")
    private MenuService menuService;

    @Test
    void addMenu() throws Exception{

        Menu menu = new Menu();
        menu.setMenuTruckId("truck01");
        menu.setMenuName("메뉴이름테스트");
        menu.setMenuPrice(10000);
        menu.setMenuDetail("메뉴설명테스트");
        menu.setIsSigMenu(0);
        menu.setMenuImg1("menuImgTest1.jpg");
        menu.setMenuImg2("menuImgTest2.jpg");
        menu.setMenuImg3("menuImgTest3.jpg");


        System.out.println("menu : " + menu);

        menuService.addMenu(menu);

        System.out.println("menu : " + menu);

        Assert.assertEquals("메뉴이름테스트", menu.getMenuName());
        Assert.assertEquals("truck01", menu.getMenuTruckId());
        Assert.assertEquals(10000, menu.getMenuPrice());
        Assert.assertEquals("메뉴설명테스트", menu.getMenuDetail());
        Assert.assertEquals(0, menu.getIsSigMenu());
        Assert.assertEquals("menuImgTest1.jpg", menu.getMenuImg1());
        Assert.assertEquals("menuImgTest2.jpg", menu.getMenuImg2());
        Assert.assertEquals("menuImgTest3.jpg", menu.getMenuImg3());

    }

//    @Test
    void addOptionGroup() {
    }

//    @Test
    void getMenu() {
    }

//    @Test
    void getMenuList() {
    }

//    @Test
    void updateMenu() {
    }

//    @Test
    void updateOptionGroup() {
    }
}