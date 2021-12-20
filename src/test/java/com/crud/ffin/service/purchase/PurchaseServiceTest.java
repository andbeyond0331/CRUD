package com.crud.ffin.service.purchase;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) //Junit4의 Runwith과 같은 기능을 하는 Junit5 어노테이션
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Order를 붙일 때 사용
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PurchaseServiceTest {

    @Test
    void addCart() {
    }

    @Test
    void addPurchase() {
    }

    @Test
    void updatePoint() {
    }

    @Test
    void addCoupon() {
    }

    @Test
    void updatePurchase() {
    }

    @Test
    void updateTotalPoint() {
    }

    @Test
    void updateCouponStatus() {
    }

    @Test
    void updateOrderTranCode() {
    }

    @Test
    void updateOrderCookingTime() {
    }

    @Test
    void updateOrderCancel() {
    }

    @Test
    void updateOrderRefusal() {
    }

    @Test
    void updaterefundStatus() {
    }

    @Test
    void updateOrder() {
    }

    @Test
    void getCouponList() {
    }

    @Test
    void getCartList() {
    }

    @Test
    void getOrderList() {
    }

    @Test
    void getPurchaseList() {
    }

    @Test
    void getSalesList() {
    }

    @Test
    void getPointList() {
    }

    @Test
    void getPurchase() {
    }

    @Test
    void getOrderDetail() {
    }

    @Test
    void getCoupon() {
    }

    @Test
    void getTotalPoint() {

    }
}