package com.crud.ffin.service.res.impl;

import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.AddCatering;
import com.crud.ffin.service.domain.ResCatering;
import com.crud.ffin.service.res.ResDao;
import com.crud.ffin.service.res.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("resServiceImpl")
public class ResServiceImpl implements ResService{

    @Autowired
    @Qualifier("resDaoImpl")
    private ResDao resDao;

    public ResServiceImpl() {
        System.out.println(this.getClass());
    }

   /* @Override
    public List<ResCatering> getResCalUser(String userId) throws Exception {
        return resDao.getResCalUser(userId);
    }

    @Override
    public List<AddCatering> getResCalTruck(String truckId) throws Exception {
        return resDao.getResCalTruck(truckId);
    }*/

    @Override
    public Map<String, Object> getUserResList(Search search, String userId) throws Exception {
        return resDao.getUserResList(search, userId);
    }

    @Override
    public Map<String, Object> getTruckResList(Search search, String truckId) throws Exception {
        return resDao.getTruckResList(search, truckId);
    }

    @Override
    public void addRes(ResCatering resCatering) throws Exception {
        resDao.addRes(resCatering);
    }

    @Override
    public void addCate(AddCatering addCatering) throws Exception {
        resDao.addCate(addCatering);
    }

    @Override
    public ResCatering getUserRes(int resNo) throws Exception {
        return resDao.getUserRes(resNo);
    }

    @Override
    public AddCatering getTruckServ(int servNo) throws Exception {
        return resDao.getTruckServ(servNo);
    }

    @Override
    public void updateUserRes(int resNo, int resStatus) throws Exception {
        resDao.updateUserRes(resNo, resStatus);
    }
}
