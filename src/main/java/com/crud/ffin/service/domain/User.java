package com.crud.ffin.service.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import lombok.Data;

@Data
public class User {
	
	

	//user TABLE
	private String userId;  //user_id
	private String userPassword; //nickname
	private String userName; //user_name
	private String userPhone;  //phone
	private Date userBirth; 
	private String userAddr;
	private String userAddrDetail;
	private double userMapLa;
	private double userMapLo;
	private String reportCount;
	private String userEmail;
	private int userEmailStatus;
	private String userProImg;
	private int userFavPlace;
	private String userFavMenu;
	private String userIntro;
	private int userTotalPoint;
	private int userByeStatus;
	private int userByeReason;
	private Date blackRegDate;
	private Date blackRestPer;
	private int role;
	
	

	
	
	
	
	

}
