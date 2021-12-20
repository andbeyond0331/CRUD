package com.crud.ffin.web.purchase;

import com.crud.ffin.service.domain.Coupon;
import com.crud.ffin.service.domain.Purchase;
import com.crud.ffin.service.domain.ResCatering;
import com.crud.ffin.service.purchase.PurchaseService;
import com.crud.ffin.service.res.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/purchase/*")
public class PurchaseRestController {

    ///Field
    @Autowired
    @Qualifier("purchaseServiceImpl")
    private PurchaseService purchaseService;


    public PurchaseRestController(){
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


    @RequestMapping( value="json/addIamport")
    @ResponseBody
    public Purchase addiamport(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("json/addIamport   : POST");
        request.setCharacterEncoding("UTF-8");
        Purchase purchase = new Purchase();

        return purchase;
    }


    @RequestMapping( value="json/cancelIamport")
    @ResponseBody
    public Purchase cancelIamport(HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("json/cancelIamport   : POST");
        request.setCharacterEncoding("UTF-8");
        Purchase purchase = new Purchase();

        return purchase;
    }

    @RequestMapping( value="json/getCouponList ")
    @ResponseBody
    public Coupon getCouponList (HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("json/getCouponList    : POST");
        request.setCharacterEncoding("UTF-8");
        Coupon coupon = new Coupon();

        return coupon;
    }








}