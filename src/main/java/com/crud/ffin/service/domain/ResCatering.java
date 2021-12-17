package com.crud.ffin.service.domain;

import java.util.Date;
import lombok.Data;

@Data
public class ResCatering {
	
	private int resNo;
	private int servNo;
	private String resUserId;
	private Date resDate;
	private String resAdd;
	private String resRequest;
	private int resQuotation;
	private int resStatusCode;
	private String resMemo;
	private String resPhone;
	private int resRealQuotation;
	private Date resCancelDate;
	private int resMenuNo;
	private int resMenuQty;
	
	
	

}
