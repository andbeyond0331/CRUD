package com.crud.ffin.web.res;


import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.AddCatering;
import com.crud.ffin.service.domain.ResCatering;
import com.crud.ffin.service.res.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/res/*")
public class ResController {

    ///Field
    @Autowired
    @Qualifier("resServiceImpl")
    private ResService resService;

    public ResController(){
        System.out.println(this.getClass());
    }

/*
    @Value("#{commonProperties['pageUnit']}")
    //@Value("#{commonProperties['pageUnit'] ?: 3}")
    int pageUnit;

    @Value("#{commonProperties['pageSize']}")
    //@Value("#{commonProperties['pageSize'] ?: 2}")
    int pageSize;*/


    @RequestMapping( value="addRes", method= RequestMethod.GET)
    public String addRes(@RequestParam("servNo") int servNo) throws Exception {
        // addResView
        System.out.println("/res/addRes   : GET");

        return "redirect: /res/addResView.jsp";
    }

    @RequestMapping( value="addRes", method=RequestMethod.POST)
    public String addRes(@ModelAttribute("ResCatering") ResCatering resCatering) throws Exception {
        System.out.println("/res/addRes   : GET") ;
        return "forward: /res/addRes.jsp";
    }

    @RequestMapping( value="addCate", method=RequestMethod.GET)
    public String addCate(@RequestParam("truckId") String truckId) throws Exception {
        // addCateView
        System.out.println("/res/addCate   : GET");

        return "redirect: /res/addCate.jsp";
    }

    @RequestMapping( value="addCate", method=RequestMethod.POST)
    public String addCate(@ModelAttribute("AddCatering") AddCatering addCatering)  throws Exception {
        System.out.println("/res/addRes   : POST");

        return "forward: /res/addRes.jsp";
    }

    @RequestMapping( value="getResCalUser", method=RequestMethod.GET)
    public String getResCalUser(@RequestParam("userId") String userId) throws Exception {
        // addCateView
        System.out.println("/res/getResCalUser   : GET");

        return "redirect: /res/getResCalUser.jsp";
    }

    @RequestMapping( value="getResCalTruck", method=RequestMethod.GET)
    public String getResCalTruck(@RequestParam("truckId") String truckId) throws Exception {
        // addCateView
        System.out.println("/res/getResCalUser   : GET");

        return "redirect: /res/getResCalUser.jsp";
    }

    @RequestMapping( value="getUserResList")
    public String getUserResList(@ModelAttribute("search") Search search, @RequestParam("userId") String userId) throws Exception {
        // addCateView
        System.out.println("/res/getUserResList");

        return "forward: /res/getUserResList.jsp";
    }


    @RequestMapping( value="getTruckResList")
    public String getTruckResList(@ModelAttribute("search") Search search, @RequestParam("truckId") String truckId) throws Exception {
        // addCateView
        System.out.println("/res/getTruckResList");

        return "forward: /res/getTruckResList.jsp";
    }

    @RequestMapping( value="getUserRes", method=RequestMethod.GET)
    public String getUserRes(@RequestParam("resNo") int resNo) throws Exception {
        // 유저의 예약 정보를 알 수 있음
        System.out.println("/res/getUserRes   : GET");

        return "redirect: /res/getUserRes.jsp";
    }

    @RequestMapping( value="getTruckServ", method=RequestMethod.GET)
    public String getTruckServ(@RequestParam("servNo") int servNo) throws Exception {
        // 트럭이 등록한 서비스를 상세조회 할 수 있음
        System.out.println("/res/getTruckServ   : GET");

        return "redirect: /res/getTruckServ.jsp";
    }

    @RequestMapping( value="updateUserRes", method=RequestMethod.POST)
    public String updateUserRes(@ModelAttribute("ResCatering") ResCatering resCatering) throws Exception {
        // addCateView
        System.out.println("/res/updateUserRes   : POST");

        // 이거도 다시 고민하기......
        // 1. 예약자의 예약 내역을 수정할 수도 있고.
        // 2. 사업자가 예약을 수락/거절 했을 때 상태값을 변경할 수도 있음
        // 3. 이 때 같은 메소드를 쓸 것인가!!!!!!!!!!
        return "forward: /res/updateUserRes.jsp";
    }


}