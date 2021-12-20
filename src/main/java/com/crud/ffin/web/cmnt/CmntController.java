package com.crud.ffin.web.cmnt;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.crud.ffin.service.cmnt.CmntService;
import com.crud.ffin.service.domain.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/cmnt/*")
public class CmntController {

    @Autowired
    @Qualifier("cmntServiceImpl")
    private CmntService cmntService;

    public CmntController(){
        System.out.println(this.getClass());
    }



    // 메세지 목록
    @RequestMapping(value = "/message_list")
    public String message_list(HttpServletRequest request, HttpSession session) throws Exception {
        // System.out.println("현대 사용자 nick : " + session.getAttribute("nick"));

        String id = (String) session.getAttribute("userId");

        Msg to = new Msg();
        to.setMsgRecvUserId(id);

        // 메세지 리스트
        ArrayList<Msg> list = cmntService.messageList(to);

        request.setAttribute("list", list);

        return "forward : cmnt/message_list";
    }

    // 메세지 목록
    @RequestMapping(value = "/message_ajax_list")
    public String message_ajax_list(HttpServletRequest request, HttpSession session) throws Exception {
        // System.out.println("현대 사용자 nick : " + session.getAttribute("nick"));

        String id = (String) session.getAttribute("userId");

        Msg to = new Msg();
        to.setId(id);

        // 메세지 리스트
        ArrayList<Msg> list = cmntService.messageList(to);

        request.setAttribute("list", list);

        return "forward: cmnt/message_ajax_list";
    }

    @RequestMapping(value = "/message_content_list")
    public String message_content_list(HttpServletRequest request, HttpSession session) throws Exception {

        int room = Integer.parseInt(request.getParameter("room"));

        Msg to = new Msg();
        to.setMsgRoom(room);
        to.setId((String) session.getAttribute("userId"));

        // 메세지 내용을 가져온다.
        ArrayList<Msg> clist = cmntService.roomContentList(to);

        request.setAttribute("clist", clist);

        return "forward : cmnt/message_content_list";
    }

    // 메세지 리스트에서 메세지 보내기
    @ResponseBody
    @RequestMapping(value = "/message_send_inlist.do")
    public int message_send_inlist(@RequestParam int room, @RequestParam String other_id,
                                   @RequestParam String msgContent, HttpSession session) throws Exception {

        Msg to = new Msg();
        to.setMsgRoom(room);
        to.setMsgSendUserId((String) session.getAttribute("UserId"));
        to.setMsgRecvUserId(other_id);
        to.setMsgContent(msgContent);

        int flag = cmntService.messageSendInlist(to);

        return flag;
    }

}