package com.crud.ffin.service.res;

import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.AddCatering;
import com.crud.ffin.service.domain.ResCatering;

import java.util.List;
import java.util.Map;

public interface ResService {

    // service 단에서는 필요 없을 것 같아
    // public List<ResCatering> getResCalUser(String userId) throws Exception;
    // public List<AddCatering> getResCalTruck(String truckId) throws Exception;

    // 1. 전체 내역을 뽑을 수 있어야 하고
    // 2. id로도 내역을 뽑을 수 있어야 하는 List 들이라
    // 3. userId와 truckId를 이 메소드에 넣지 말고
    // 4. 애초에 service 호출할 때 search에 담으면 어떨까 함. 아님 애초에 search랑 id를 map에 담아서 보내도 되고.
    // 5. 뭐가 좋을까? 고민해보자.
    public Map<String, Object> getUserResList(Search search, String userId) throws Exception;
    public Map<String, Object> getTruckResList(Search search, String truckId) throws Exception;

    public void addRes(ResCatering resCatering) throws Exception;
    public void addCate(AddCatering addCatering) throws Exception;


    public ResCatering getUserRes(int resNo) throws Exception;
    public AddCatering getTruckServ(int servNo) throws Exception;

    // 수락, 취소, 거절시 쓰는 메소드
    public void updateUserResStatus(int resNo, int resStatus, String memo) throws Exception;
    // 전체 수정시 쓰는 메소드
    public void updateUserRes(ResCatering resCatering) throws Exception;





}