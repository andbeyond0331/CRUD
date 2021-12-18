package com.crud.ffin.web.res;


import com.crud.ffin.service.domain.ResCatering;
import com.crud.ffin.service.purchase.PurchaseService;
import com.crud.ffin.service.res.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/res/*")
public class ResRestController {

    ///Field
    @Autowired
    @Qualifier("resServiceImpl")
    private ResService resService;


    public ResRestController(){
        System.out.println(this.getClass());
    }

/*

    @Value("#{commonProperties['pageUnit']}")
    //@Value("#{commonProperties['pageUnit'] ?: 3}")
    int pageUnit;

    @Value("#{commonProperties['pageSize']}")
    //@Value("#{commonProperties['pageSize'] ?: 2}")
    int pageSize;
*/


    @RequestMapping( value="json/updateUserRes")
    @ResponseBody
    public ResCatering updateUserRes(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("json/updateUserRes   : POST");
        request.setCharacterEncoding("UTF-8");

        // statusCode (수락시/거절시/취소시)
        // memo (수락메모/거절메모/ 취소시null)
        // update method 쓰고 (status와 memo만 업데이트 하는 메소드 생성)
        // return 값은 예약내용 보내야하니까 ResCatering
        ResCatering resCatering = new ResCatering();
        return resCatering;
    }







}