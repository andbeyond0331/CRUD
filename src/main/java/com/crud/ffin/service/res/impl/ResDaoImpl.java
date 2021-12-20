package com.crud.ffin.service.res.impl;

import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.AddCatering;
import com.crud.ffin.service.domain.ResCatering;
import com.crud.ffin.service.res.ResDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("resDaoImpl")
public class ResDaoImpl implements ResDao {

    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSession sqlSession;
    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    ///Constructor
    public ResDaoImpl() {
        System.out.println(this.getClass());
    }


    @Override
    public Map<String, Object> getUserResList(Search search, String userId, String resStatusCode) throws Exception {
        // userId에 따른 user의 예약 내역 dao
        // search Condition 으로 구분할 것 : controller 에서 구분해서 mapper에서 처리
         /*
         21. 12. 20
         searchCondition 으로 나누려고 하고 있다.
         0이면 user의 전체 내역을
         1이면 user의 정보 중에서 resStatus를 확인하는 값을
         mapper에서 구분하는 것으로.
         그럼 애초에 status도 함께 넣는 메소드로 변경해야 할 듯.
         */

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("search",search);
        map.put("userId", userId);
        map.put("resStatusCode", resStatusCode);
        List<ResCatering> list = sqlSession.selectList("ResMapper.getUserResList", map);
        map.put("list",list);
        return map;
    }

    @Override
    public Map<String, Object> getTruckResList(Search search, String truckId) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("search",search);
        map.put("userId", truckId);
        List<AddCatering> list = sqlSession.selectList("ResMapper.getUserResList", map);
        map.put("list", list);
        return map;
    }

    @Override
    public void addRes(ResCatering resCatering) throws Exception {
        sqlSession.insert("ResMapper.addRes", resCatering);
    }

    @Override
    public void addCate(AddCatering addCatering) throws Exception {
        sqlSession.insert("ResMapper.addCate", addCatering);
    }

    @Override
    public ResCatering getUserRes(int resNo) throws Exception {
        return sqlSession.selectOne("ResMapper.getUserRes", resNo);
    }

    @Override
    public AddCatering getTruckServ(int servNo) throws Exception {
        return sqlSession.selectOne("ResMapper.getTruckServ", servNo);
    }

    @Override
    public void updateUserResStatus(int resNo, int resStatus, String memo) throws Exception {
        System.out.println("resNo = " + resNo + ", resStatus = " + resStatus + ", memo = " + memo);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resNo",resNo);
        map.put("resStatus", resStatus);
        map.put("memo", memo);
        sqlSession.update("ResMapper.updateUserRes1", map);
    }

    @Override
    public void updateUserRes(ResCatering resCatering) throws Exception {
        sqlSession.update("ResMapper.updateUserRes2", resCatering);
    }

    @Override
    public List<AddCatering> getTruckAllServList(Search search) throws Exception {
        return sqlSession.selectList("ResMapper.getTruckAllServList", search);
    }
}
