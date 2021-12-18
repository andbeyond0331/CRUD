package com.crud.ffin.service.purchase.impl;

import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.*;
import com.crud.ffin.service.purchase.PurchaseDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("purchaseDaoImpl")
public class PurchaseDaoImpl implements PurchaseDao {

    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSession sqlSession;
    public void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }
    public PurchaseDaoImpl(){
        System.out.println(this.getClass());
    }

    public void addCart(OrderDetail orderDetail) throws Exception{
        sqlSession.insert("PurchaseMapper.addCart",orderDetail);
    }//장바구니에 정보 등록
    public void addPurchase(Purchase purchase)throws Exception{
        sqlSession.insert("PurchaseMapper.addPurchse",purchase);
    }
    //주문번호 생성을 위해서
    public void updatePoint(Point point)throws Exception{
        sqlSession.insert("purchaseMapper.updatePoint",point);
    }// 포인트 적립차감 등록
    public void addCoupon(Coupon coupon)throws Exception{
        sqlSession.insert("purchaseMapper.addCoupon",coupon);
    }// 쿠폰발급 등록




    public void updatePurchase(Purchase purchase)throws Exception{
        sqlSession.update("purchasMapper.updatePurchase",purchase);
    } //결제 시 결제에 대한 정보 업데이트
    public void updateOrderRefusal (Purchase purchase)throws Exception{
        sqlSession.update("purchaseMapper.updateOrderRefusal",purchase);
    } //주문취소 사유
    public void updateTotalPoint (User user)throws Exception{
        sqlSession.update("purchaseMapper.updateTotalPoint",user);
    } //총포인트 수정
    public void updateCouponStatus (Coupon coupon)throws Exception{
        sqlSession.update("purchaseMapper.updateCouponStatus",coupon);
    } //쿠폰사용으로 사용유무수정
    public void updateOrderCancel (Purchase purchase)throws Exception{
        sqlSession.update("purchaseMapper.updateOrderCancel",purchase);
    } //주문취소로 주문상태변경,주문취소사유
    public void updaterefundStatus(Purchase purchase)throws Exception{
        sqlSession.update("purchaseMapper.updatefundStatus",purchase);
    }//주문거절로 주문상태변경,주문거절사유
    public void updateOrderTranCode (Purchase purchase) throws Exception{
        sqlSession.update("purchaseMapper.updateOrderTranCode",purchase);
    }//주문접수로 주문상태변경
    public void updateOrderCookingTime (Purchase purchase) throws Exception{
        sqlSession.update("purchaseMapper.updateOrderCookingTime",purchase);
    }//주문접수 시 예상조리시간
    public void updateOrder(Purchase purchase)throws Exception{
        sqlSession.update("purchaseMapper.updateOrder",purchase);
    } //결제이후 결제정보 추가업데이트







    public List<Purchase> getCouponList(Search search, String userId)throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("search",search);
        map.put("userId",userId);
        return sqlSession.selectList("PurchaseMapper.getCouponList",map);
    } //쿠폰 리스트를 출력
    public List<Purchase> getCartList(Search search ,int orderNo)throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("search",search);
        map.put("orderNo",orderNo);
        return sqlSession.selectList("PurchaseMapper.getCartList",map);
    } //주문상세에 있는 정보 List?로 가져옴
    public List<Purchase> getOrderList(Search search, String truckId)throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("search",search);
        map.put("truckId",truckId);
        return sqlSession.selectList("purchaseMapper.getOrderList",map);
    } //현재판매목록
    public List getPurchaseList(Search search , String userId)throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("search",search);
        map.put("userId",userId);
        return sqlSession.selectList("purchaseMapper.getPurchaseList",map);
    }//마이페이지에서 구매이력
    public List getSalesList(Search search , String truckId)throws Exception{
        return sqlSession.selectList("purchaseMapper.");
    } //마이페이지에서 판매이력
    public List getPointList(Search search , String userId)throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("search",search);
        map.put("userId",userId);
        return sqlSession.selectList("purchaseMapper.getPointList",map);
    }//마이페이지에서 포인트내역조회



    public int getPoint (String userId)throws Exception{
        return sqlSession.selectOne("purchaseMapper.getPoint",userId);
    }//보유 총포인트 조회
    public int getCoupon(int couponNo)throws Exception{
        return sqlSession.selectOne("purchaseMapper.getCoupon",couponNo);
    }// 쿠폰 할인금
    public Purchase getPurchase(int orderNo)throws Exception{
        return sqlSession.selectOne("purchaseMapper.getPurchase",orderNo);
    } // 결제정보 조회
    public Purchase getOrderDetail(int orderNo)throws Exception{
        return sqlSession.selectOne("purchaseMapper.getOrderDetail",orderNo);
    } //주문정보 조회 이용자의 정보도 함께

}