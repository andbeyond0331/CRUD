package com.crud.ffin.service.domain;

import java.sql.Timestamp;
import lombok.Data;
import lombok.Getter;

public class Coupon {
	private String flightId; //flight_id
	private String airline; //airline
	private int price; //price
	private String tripCourse; //trip_course
	private String depCity; //dep_city
	private String depDate; //dep_date
	private String depTime; //dep_time
	private String arrCity; //arr_city
	private String arrDate; //arr_date
	private String arrTime;	//arr_time
	private String seatGrade; //seat_grade
	private int adultNum; //adult_num
	private int childNum; //child_num
	private int infantNum; //infant_num
	private String leadTime; //lead_time
	private String stopOver; //stop_over
	private String orderStatus; //order_status
	private Timestamp orderDate; //order_date
	private String refundDate; 
	
	private String orderId;
	private String buyerId;
	
	
	

	
}
