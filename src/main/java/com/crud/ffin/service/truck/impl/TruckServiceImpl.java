package com.crud.ffin.service.truck.impl;

import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.Truck;
import com.crud.ffin.service.truck.TruckDao;
import com.crud.ffin.service.truck.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//==> 푸드트럭관리 서비스 구현
@Service("truckServiceImpl")
public class TruckServiceImpl implements TruckService{

    ///Field
    @Autowired
    @Qualifier("truckDaoImpl")
    private TruckDao truckDao;

    public void setTruckDao(TruckDao truckDao) {
        this.truckDao = truckDao;
    }

    ///Constructor
    public TruckServiceImpl() {
        System.out.println(this.getClass());
    }

    ///Method
    @Override
    public void addTruck(Truck truck) throws Exception {
        truckDao.addTruck(truck);
    }

    @Override
    public Truck getTruck(String truckId) throws Exception {
        return truckDao.getTruck(truckId);
    }

    @Override
    public void getNotice(String truckId) throws Exception {

    }

    @Override
    public Map<String, Object> getTruckList(Search search) throws Exception {
        List<Truck> list = truckDao.getTruckList(search);
        int totalCount = truckDao.getTotalCount(search);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("list", list);
        map.put("totalCount", new Integer(totalCount));

        return map;
    }

    @Override
    public void updateTruck(Truck truck) throws Exception {
        truckDao.updateTruck(truck);
    }

    @Override
    public int getTotalCount(Search search) throws Exception {
        return 0;
    }

    @Override
    public void login(Truck truck) throws Exception {

    }

    @Override
    public void logout(Truck truck) throws Exception {

    }

    @Override
    public void findTruckId(Truck truck) throws Exception {

    }

    @Override
    public boolean updateBusiStatus(String truckId) throws Exception {
        boolean result=true;
        Truck truck = truckDao.getTruck(truckId);
        if(truck != null) {
            result = false;
        }
        return result;
    }

    @Override
    public void updateNotice(Truck truck) throws Exception {

    }

    @Override
    public void findTruck(Truck truck) throws Exception {

    }

    @Override
    public void updateTruckProfile(Truck truck) throws Exception {

    }

    @Override
    public void getTruckProfile(Truck truck) throws Exception {

    }

    @Override
    public void getTruckInfo(Truck truck) throws Exception {

    }

    @Override
    public void updateTruckInfo(Truck truck) throws Exception {

    }

    @Override
    public boolean updateBusiStatus(Truck truck) throws Exception {
        return false;
    }

    @Override
    public void updateTruckPassword(Truck truck) throws Exception {

    }

    @Override
    public void byeTruck(Truck truck) throws Exception {

    }

    @Override
    public void uploadFile(Truck truck) throws Exception {

    }

    @Override
    public void sendEmail(Truck truck) throws Exception {

    }

    @Override
    public void emailAuth(Truck truck) throws Exception {

    }

    @Override
    public void messageAuth(Truck truck) throws Exception {

    }

    @Override
    public void captchaAuth(Truck truck) throws Exception {

    }

    @Override
    public void busiLiceAuth(Truck truck) throws Exception {

    }

    @Override
    public void getNewTruck(Truck truck) throws Exception {

    }

    @Override
    public List<Truck> getNewTruckList(Search search) throws Exception {
        return null;
    }
}
