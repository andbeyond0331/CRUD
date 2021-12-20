package com.crud.ffin.service.domain;

import lombok.Data;

import java.util.Date;

@Data
public class User {

	//user TABLE
	private String userId;
	private String userPassword;
	private String userName;
	private String userPhone;
	private String userBirth;
	private String userAddr;
	private String userAddrDetail;
	private Date userRegDate;
	private double userMapLa;
	private double userMapLo;
	private String reportCount;
	private String userEmail;
	private int userEmailStatus;
	private String userProImg;
	private int userFavPlace;
	private int userFavPlaceDetail;
	private String userFavMenu;
	private String userIntro;
	private int userTotalPoint;
	private int userByeStatus;
	private int userByeReason;
	private Date userByeRegDate;
	private Date blackRegDate;
	private Date blackRestPer;
	private int role;

}
