package com.crud.ffin.web.truck;

import com.crud.ffin.common.Page;
import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.Truck;
import com.crud.ffin.service.truck.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

//==> 트럭관리 Controller
@Controller
@RequestMapping("/truck/*")
public class TruckController {

    ///Field
    @Autowired
    @Qualifier("truckServiceImpl")
    private TruckService truckService;
    //setter Method 구현않음

    public TruckController(){
        System.out.println(this.getClass());
    }

    @Value("#{commonProperties['pageUnit']}")
    int pageUnit;
    @Value("#{commonProperties['pageSize']}")
    int pageSize;

    @RequestMapping( value = "addTruck", method = RequestMethod.GET)
    public String addTruck() throws Exception{

        System.out.println("/truck/addTruck : GET");

        return "redirect:/truck/addTruckView.jsp";
    }

    @RequestMapping( value = "addTruck", method=RequestMethod.POST)
    public String addTruck(@ModelAttribute("truck")Truck truck) throws Exception{

        System.out.println("/truck/addTruck : POST");
        //Business Logic
        truckService.addTruck(truck);

        return "redirect:/truck/loginTruck.jsp";
    }

    @RequestMapping( value = "getTruck", method = RequestMethod.GET)
    public String getTruck(@RequestParam("truckId") String truckId, Model model) throws Exception{

        System.out.println("/truck/getTruck : GET");
        //Business Logic
        Truck truck = truckService.getTruck(truckId);
        //Model 과 View 연결
        model.addAttribute("truck", truck);

        return "forward:/truck/getTruck.jsp";
    }

    @RequestMapping( value = "updateTruck", method = RequestMethod.GET)
    public String updateTruck( @RequestParam("truckId") String truckId, Model model, HttpSession session) throws Exception{

        System.out.println("/truck/updateTruck : GET");
        //Business Logic
        Truck truck = truckService.getTruck(truckId);
        //Model 과 View 연결
        model.addAttribute("truck", truck);

        return "forward:/truck/updateTruck.jsp";
    }

    @RequestMapping( value = "updateTruck", method = RequestMethod.POST)
    public String updateTruck(@ModelAttribute("truck") Truck truck, Model model, HttpSession session) throws Exception{

        System.out.println("/truck/updateTruck : POST");
        //Business Logic
        truckService.updateTruck(truck);

        String sessionId=((Truck)session.getAttribute("truck")).getTruckId();
        if(sessionId.equals(truck.getTruckId())){
            session.setAttribute("truck",truck);
        }

        return "redirect:/truck/getTruck?truckId="+truck.getTruckId();
    }

    @RequestMapping( value="login", method=RequestMethod.POST )
    public String login(@ModelAttribute("truck") Truck truck , HttpSession session ) throws Exception {

        System.out.println("/truck/login : POST");
        //Business Logic
        Truck dbTruck = truckService.getTruck(truck.getTruckId());

        if (truck.getPassword().equals(dbTruck.getPassword())) {
            session.setAttribute("truck", dbTruck);
        }

        return "redirect:/index.jsp";
    }

    @RequestMapping( value="logout", method=RequestMethod.GET )
    public String logout(HttpSession session ) throws Exception{

        System.out.println("/truck/logout : POST");

        session.invalidate();

        return "redirect:/index.jsp";
    }

    @RequestMapping( value="getTruckList" )
    public String getTruckList(@ModelAttribute("search") Search search , Model model , HttpServletRequest request) throws Exception{

        System.out.println("/truck/getTruckList : GET / POST");

        if(search.getCurrentPage() ==0 ){
            search.setCurrentPage(1);
        }
        search.setPageSize(pageSize);

        // Business logic 수행
        Map<String , Object> map=truckService.getTruckList(search);

        Page resultPage = new Page( search.getCurrentPage(), ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
        System.out.println(resultPage);

        // Model 과 View 연결
        model.addAttribute("list", map.get("list"));
        model.addAttribute("resultPage", resultPage);
        model.addAttribute("search", search);

        return "forward:/truck/getTruckList.jsp";
    }

    }
