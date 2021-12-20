package com.crud.ffin.service.res;

import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.AddCatering;
import com.crud.ffin.service.domain.ResCatering;

import java.util.List;
import java.util.Map;

public interface ResDao {

   /* public List<ResCatering> getResCalUser(String userId) throws Exception;
    public List<AddCatering> getResCalTruck(String truckId) throws Exception;*/

    public Map<String, Object> getUserResList(Search search, String userId,  String resStatusCode) throws Exception;
    public Map<String, Object> getTruckResList(Search search, String truckId) throws Exception;

    public void addRes(ResCatering resCatering) throws Exception;
    public void addCate(AddCatering addCatering) throws Exception;


    public ResCatering getUserRes(int resNo) throws Exception;
    public AddCatering getTruckServ(int servNo) throws Exception;

    public void updateUserResStatus(int resNo, int resStatus, String memo) throws Exception;
    public void updateUserRes(ResCatering resCatering) throws Exception;

    /* 예약 가능한 모든 케이터링 서비스 */
    public List<AddCatering>  getTruckAllServList(Search search) throws Exception;

}
