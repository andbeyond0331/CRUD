package com.crud.ffin.web.res;

import com.crud.ffin.common.Page;
import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.AddCatering;
import com.crud.ffin.service.domain.ResCatering;
import com.crud.ffin.service.res.ResService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/res/*")
@PropertySource("classpath:config/common.properties")
public class ResController {

    ///Field
    @Autowired
    @Qualifier("resServiceImpl")
    private ResService resService;

    public ResController(){
        System.out.println(this.getClass());
    }


    @Value("${pageUnit}") //pageUnit은 propertySource를 위에 선언하고 @value의 값을 지정해줌
            //추후 pageUnit과 pageSize 출력되는지 jUnit에서 확인이 필요합니다.
    //@Value("#{commonProperties['pageUnit'] ?: 3}")
    int pageUnit;

    @Value("${pageSize}")
    int pageSize;


    @RequestMapping( value="addRes", method= RequestMethod.GET)
    public String addRes(@RequestParam("servNo") int servNo, Model model) throws Exception {
        // addResView
        // '이용자'가 service를 보면 서비스 상세 내역과 동시에 바로 addResView로 이동한다.

        System.out.println("/res/addRes   : GET");
        System.out.println("servNo = " + servNo);
        //AddCatering addCatering = new AddCatering();
        AddCatering addCatering = resService.getTruckServ(servNo);
        System.out.println("addCatering = " + addCatering);
        model.addAttribute("addCatering", addCatering);
        return "forward: /res/addResView.jsp";
    }

    @RequestMapping( value="addRes", method=RequestMethod.POST)
    public String addRes(@ModelAttribute("ResCatering") ResCatering resCatering, Model model) throws Exception {
        System.out.println("/res/addRes   : POST") ;
        System.out.println("resCatering = " + resCatering);
        // 이용자가 서비스 예약버튼 눌렀을 때, 예약 되는 화면.
        // 예약 완료시 모달창으로 예약 완료창 띄우고 다시 캘린더로 가는 것으로 구현 생각 중.
        // 그러면 ajax 일 듯
        // 일단은 여기에 구현
        resService.addRes(resCatering);
        model.addAttribute("resCatering", resCatering);
        return "forward: /res/addRes.jsp";
    }

    @RequestMapping( value="addCate", method=RequestMethod.GET)
    public String addCate(@RequestParam("truckId") String truckId, Model model) throws Exception {
        // addCateView
        System.out.println("/res/addCate   : GET");
        System.out.println("truckId = " + truckId);
        // truck Service에서 truck을 불러와서 addCatering의 truck에 담아야 함.
        // 그리고 addCatering을 model에 담아서 보내라

        return "redirect: /res/addCate.jsp";
    }

    @RequestMapping( value="addCate", method=RequestMethod.POST)
    public String addCate(@ModelAttribute("AddCatering") AddCatering addCatering)  throws Exception {
        System.out.println("/res/addCate   : POST");
        System.out.println("addCatering = " + addCatering);

        resService.addCate(addCatering);
        // 서비스 등록시에도 예약 등록과 마찬가지로, 모달창 띄워야해서 결국 ajax 일 듯
        return "forward: /res/addRes.jsp";
    }

    @RequestMapping( value="getResCalUser", method=RequestMethod.GET)
    public String getResCalUser(@RequestParam("userId") String userId, @ModelAttribute("search") Search search, Model model) throws Exception {
        // addCateView
        System.out.println("/res/getResCalUser   : GET");
        System.out.println("userId = " + userId);
        // 이게 user의 캘린더를 불러오는거............... ㅎ
        // 1) user의 목록을 불러올 수 있어야 하고 + 그 중에서 status 값이 '예약완료'인 5인 것만 불러와야해서 이걸 메소드 처리 할 지 아님 불러와서 status값이 5인것만 화면에 출력할지 고민중

         /*21. 12. 20
         searchCondition 으로 나누려고 하고 있다. (getUserResList를!)
         0이면 user의 전체 내역을
         1이면 user의 정보 중에서 resStatus를 확인하는 값을
         mapper에서 구분하는 것으로.*/
        String resStatusCode="5"; //예약 완료된 건에 대하여 출력
                                // 추후 화면단에서 보낼 수도 있음
        search.setSearchCondition("1");
        Map<String , Object> map = resService.getUserResList(search, userId, resStatusCode);
        // 2) 전체 서비스를 알아야 함 (select all) => service, dao 생성 필요

        // 이 때 이걸 한 화면에서 다 뿌릴 수 있느냐가 궁금.
        // 그리고 이건 ajax 일지도.
        model.addAttribute("userList", map.get("list"));
        return "redirect: /res/getResCalUser.jsp";
    }

    @RequestMapping( value="getResCalTruck", method=RequestMethod.GET)
    public String getResCalTruck(@RequestParam("truckId") String truckId, @ModelAttribute("search") Search search, Model model) throws Exception {
        // addCateView
        System.out.println("/res/getResCalTruck   : GET");
        // 트럭은 자기의 서비스만 불러오면 된다.
        // 이걸 full calendar에 어떻게 넣느냐가 문제
        Map<String , Object> map = resService.getTruckResList(search, truckId);
        model.addAttribute("list", map.get("list"));
        return "redirect: /res/getResCalUser.jsp";
    }

    @RequestMapping( value="getUserResList")
    public String getUserResList(@ModelAttribute("search") Search search, @RequestParam("userId") String userId, Model model) throws Exception {
        // addCateView
        System.out.println("/res/getUserResList");
        // 이거는 user의 예약내역목록을 보여주는 list 처리하는 메소드
        // 위의 메소드와 비슷한데 이건 status를 전체 다 보여준다.
        Map<String , Object> map = resService.getUserResList(search, userId);
        model.addAttribute("list", map.get("list"));
        return "forward: /res/getUserResList.jsp";
    }


    @RequestMapping( value="getTruckResList")
    public String getTruckResList(@ModelAttribute("search") Search search, @RequestParam("truckId") String truckId, Model model) throws Exception {
        // addCateView
        System.out.println("/res/getTruckResList");
        // 트럭의 서비스를 예약한 리스트로 STATUS 전체 값을 보야주고 잇다.
        Map<String , Object> map = resService.getTruckResList(search, truckId);
        model.addAttribute("list", map.get("list"));
        return "forward: /res/getTruckResList.jsp";
    }

    @RequestMapping( value="getUserRes", method=RequestMethod.GET)
    public String getUserRes(@RequestParam("resNo") int resNo,  Model model) throws Exception {
        // 유저의 예약 정보를 알 수 있음
        // 예약의 상세정보
        System.out.println("/res/getUserRes   : GET");
        ResCatering resCatering = resService.getUserRes(resNo);
        model.addAttribute("resCatering", resCatering);
        // forward or redirect
        return "forward: /res/getUserRes.jsp";
    }

    @RequestMapping( value="getTruckServ", method=RequestMethod.GET)
    public String getTruckServ(@RequestParam("servNo") int servNo,  Model model) throws Exception {
        // 트럭이 등록한 서비스를 상세조회 할 수 있음
        // 서비스의 상세정보..
        // 사실 addResView와 같은 역할로 생각했는데, 넘기는 부분에 대해 더 고민해볼 것.
        // 우선은 상세정보창(read Only)을 생각해서 만든 메소드
        System.out.println("/res/getTruckServ   : GET");
        AddCatering addCatering = resService.getTruckServ(servNo);
        model.addAttribute("addCatering", addCatering);
        return "forward: /res/getTruckServ.jsp";
    }

    @RequestMapping( value="updateUserRes", method=RequestMethod.POST)
    public String updateUserRes(@ModelAttribute("ResCatering") ResCatering resCatering) throws Exception {
        // updateUserRes
        System.out.println("/res/updateUserRes   : POST");

        // 이거도 다시 고민하기......
        // 1. 예약자의 예약 내역을 수정할 수도 있고.
        // 2. 사업자가 예약을 수락/거절 했을 때 상태값을 변경할 수도 있음 ==> rest서버.
        // 3. 이 때 같은 메소드를 쓸 것인가!!!!!!!!! ==> rest서버와 그냥 서버로 구분
        // 4. 이거는 예약시 전체 내용 수정하는거로..!

        resService.updateUserRes(resCatering);

        return "redirect: /res/updateUserRes.jsp";
    }


}