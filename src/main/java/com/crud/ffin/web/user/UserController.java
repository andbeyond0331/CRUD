package com.crud.ffin.web.user;

import com.crud.ffin.service.domain.Report;
import com.crud.ffin.service.domain.User;
import com.crud.ffin.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user/*")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    public UserController() {
        System.out.println("Default Constructor :: UserController.UserController");
    }

//    @Value("#{commonProperties['pageUnit']}")
//    int pageUnit;
//
//    @Value("#{commonProperties['pageSize']}")
//    int pageSize;

    @RequestMapping(value="loginUser", method = RequestMethod.GET)
    public String loginUser() throws Exception{
        System.out.println("UserController.loginUser : GET");
        return "redirect:/user/loginUser.jsp";
    }

    @RequestMapping(value = "loginUser", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User user, HttpSession session) throws Exception{
        System.out.println("UserController.login : POST");
        User dbUser = userService.getUser(user.getUserId());

        if(user.getUserPassword().equals(dbUser.getUserPassword())){
            session.setAttribute("user", dbUser);
        }

        return "redirect:/main.jsp";
    }

    //Logout 추가할것

    @RequestMapping(value = "addUserInfo", method = RequestMethod.GET)
    public String addUserInfo() throws Exception {
        System.out.println("UserController.addUser : GET");
        return "redirect:/user/addUserInfo.jsp";
    }

    @RequestMapping(value = "addUserInfo", method = RequestMethod.POST)
    public String addUserInfo(@ModelAttribute("user") User user) throws Exception{
        System.out.println("UserController.addUserInfo : POST");
        userService.addUserInfo(user);

        return "redirect:/user/addUserProfile.jsp";
    }

    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public String getUser(@RequestParam("userId") String userId, Model model) throws Exception{
        System.out.println("UserController.getUser : GET");
        User user = userService.getUser(userId);
        model.addAttribute("user",user);

        return "forward:/user/getUser.jsp";
    }

    @RequestMapping(value = "updateUserInfo", method = RequestMethod.GET)
    public String updateUserInfo (@RequestParam("userId") String userId, Model model) throws Exception {
        System.out.println("UserController.updateUserInfo : GET");
        User user = userService.getUser(userId);
        model.addAttribute("user", user);

        return "forward:/user/updateUserInfo.jsp";
    }

    @RequestMapping(value = "updateUserInfo",method = RequestMethod.POST)
    public String updateUserInfo ( @ModelAttribute("user") User user, Model model, HttpSession session) throws Exception{
        System.out.println("UserController.updateUserInfo : POST");
        userService.updateUserInfo(user);

        String sessionId = ((User)session.getAttribute("user")).getUserId();
        if(sessionId.equals(user.getUserId())){
            session.setAttribute("user", user);
        }
        return "redirect:/main.jsp";
    }

    @RequestMapping(value = "updateUserProfile", method = RequestMethod.GET)
    public String updateUserProfile (@RequestParam("userId") String userId, Model model) throws Exception {
        System.out.println("UserController.updateUserProfile : GET");
        User user = userService.getUser(userId);
        model.addAttribute("user", user);

        return "forward:/user/updateUserProfile.jsp";
    }

    @RequestMapping(value = "updateUserProfile",method = RequestMethod.POST)
    public String updateUserProfile ( @ModelAttribute("user") User user, Model model, HttpSession session) throws Exception{
        System.out.println("UserController.updateUserProfile : POST");
        userService.updateUserProfile(user);

        String sessionId = ((User)session.getAttribute("user")).getUserId();
        if(sessionId.equals(user.getUserId())){
            session.setAttribute("user", user);
        }
        return "redirect:/main.jsp";
    }

//    @RequestMapping(value = "updateUserMap", method = RequestMethod.GET)
//    public String updateUserMap (@RequestParam("userId") String userId, Model model) throws Exception {
//        System.out.println("UserController.updateUserMap : GET");
//        User user = userService.getUser(userId);
//        model.addAttribute("user", user);
//
//        return "forward:/user/updateUserProfile.jsp";
//    }
//
//    @RequestMapping(value = "updateUserMap",method = RequestMethod.POST)
//    public String updateUserMap ( @ModelAttribute("user") User user, Model model, HttpSession session) throws Exception{
//        System.out.println("UserController.updateUserMap : POST");
//        userService.updateUserMap(user);
//
//        String sessionId = ((User)session.getAttribute("user")).getUserId();
//        if(sessionId.equals(user.getUserId())){
//            session.setAttribute("user", user);
//        }
//        return "redirect:/main.jsp";
//    }



    // *** report ***
    @RequestMapping(value = "addReport", method = RequestMethod.GET)
    public String addReport() throws Exception {
        System.out.println("UserController.addReport : GET");
        return "forward:/user/addReport.jsp";
    }

    @RequestMapping(value = "addReport", method = RequestMethod.POST)
    public String addReport(@ModelAttribute("report") Report report, Model model, HttpSession session) throws Exception {
        System.out.println("UserController.addReport : POST");

        User user = (User)session.getAttribute("user");
        report.setReportUserId(user.getUserId());

        userService.addReport(report);

        return "redirect:/user/getReportList.jsp";
    }

    @RequestMapping(value = "getReport", method = RequestMethod.GET)
    public String getReport( @RequestParam("reportNo") int reportNo, Model model) throws Exception {
        System.out.println("UserController.getReport : GET");
        Report report = userService.getReport(reportNo);
        model.addAttribute("report", report);

        return "forward:/user/getReport.jsp";
    }

    //getReportList


}
