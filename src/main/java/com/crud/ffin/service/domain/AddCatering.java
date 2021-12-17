package com.crud.ffin.service.domain;

import java.util.Date;

import lombok.Data;
@Data
public class AddCatering {
	
	private int servNo;
	private String servTruckId;
	private Date servDate;
	private String servTime;
	private String servLocation;
	private String servMenuName;
	private int servMenuPrice;
	private String servMenuImg;
	private int servMenuMinQty;
	private int servMenuMaxQty;
	
	
	
	

}
