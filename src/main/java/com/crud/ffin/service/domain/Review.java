package com.crud.ffin.service.domain;
import lombok.Data;

@Data
public class Review {
	
	private int rvNo; 
	private int rvOrderNo;
	private String rvRegTime; 
	private String rvStar; 
	private String rvContent;
	private String rvTruckCmtContent;
	private String rvTruckCmtRegTime;
	private String rvImg1;
	private String rvImg2;
	private String rvImg3;
	private int rvDelete;
	private int rvTCDelete;


	

}