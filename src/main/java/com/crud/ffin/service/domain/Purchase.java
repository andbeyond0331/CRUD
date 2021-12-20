package com.crud.ffin.service.domain;

import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;

@Data
public class Purchase {
	
	//***********************************
	
	private int orderNo; //주문번호
	private String orderUserId; //이용자아이디
	private String orderTruckId; //트럭아이디
	private int payPointNo; //결제시 사용한 포인트번호
	private int payCouponNo; //결제시 사용한 쿠폰번호
	private int payResNo; //결제시 사용한 케이터링번호
	private int orderQty; //주문 수량
	private String orderRequest; //주문 요청사항
	private int orderStatus; //주문상태코드
	private int orderPickUpTime; //픽업희망시간
	private int orderCookingTime; //예상조리 시간
	private int orderCancelReason; //주문취소 사유
	private int orderNopeReason; //주문거절 사유
	private int orderTotalPrice; //주문금액
	private Date payDateTime; //결제일시
	private Date payRefundDateTime; //결제취소일시
	private int payServiceType; //일반결제,케이터링결제
	private int payOption; //결제방법
	private int payRefundStatus; //환불유무
	private int payPrice; //할인금이 적용된 결제금액

}
