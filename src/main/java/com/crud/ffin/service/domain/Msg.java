package com.crud.ffin.service.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Msg {
	
	private int msgNo;
	private String msgSendUserId;
	private String msgRecvUserId;
	private Date msgSendDate;
	private Date msgReadDate;
	private String msgContent;
	private int msgReadStatus;
	

}
