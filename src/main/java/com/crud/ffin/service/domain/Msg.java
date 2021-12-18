package com.crud.ffin.service.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Msg {
	
	private int msgNo;
	private int msgRoom;
	private String msgSendUserId;
	private String msgRecvUserId;
	private Date msgSendDate;
	private Date msgReadDate;
	private String msgContent;
	private int msgReadStatus;


	// 아래부터는 복붙 해온건데 참고 필요, 왜 필요한지 파악할 것

	// 현재 사용자의 메세지 상대 nick을 담는다.
	private String other_nick;
	// 현재 사용자의 메세지 상대 profile을 담는다.
	private String profile;
	// 현재 사용자 nick
	private String nick;
	// 안읽은 메세지 갯수
	private int unread;
}
