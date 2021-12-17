package com.crud.ffin.service.truck;

import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.Truck;

import java.util.List;

public interface TruckService {

    // INSERT
    public void addTruck(Truck truck) throws Exception ;

    // SELECT ONE
    public Truck getTruck(String truckId) throws Exception ;

    // SELECT LIST
    public List<Truck> getTruckList(Search search) throws Exception ;

    // UPDATE
    public void updateTruck(Truck truck) throws Exception ;

    // 게시판 Page 처리를 위한 전체Row(totalCount)  return
    public int getTotalCount(Search search) throws Exception ;

    public void login(Truck truck) throws Exception ;
    public void logout(Truck truck) throws Exception ;
    public boolean updateBusiStatus(Truck truck) throws Exception ;
    public void updateNotice(Truck truck) throws Exception ;
    public void findTruck(Truck truck) throws Exception ;
    public void updateTruckProfile(Truck truck) throws Exception ;
    public void getTruckProfile(Truck truck) throws Exception ;
    public void getTruckInfo(Truck truck) throws Exception ;
    public void updateTruckInfo(Truck truck) throws Exception ;
    public void updateTruckPassword(Truck truck) throws Exception ;
    public void byeTruck(Truck truck) throws Exception ;
    public void uploadFile(Truck truck) throws Exception ;
    public void sendEmail(Truck truck) throws Exception ;
    public void emailAuth(Truck truck) throws Exception ;
    public void messageAuth(Truck truck) throws Exception ;
    public void captchaAuth(Truck truck) throws Exception ;
    public void busiLiceAuth(Truck truck) throws Exception ;
    public void getNewTruck(Truck truck) throws Exception ;
    public List<Truck> getNewTruckList(Search search) throws Exception ;

}
