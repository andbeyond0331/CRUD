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

/*

    @Override
    public List<ResCatering> getResCalUser(String userId) throws Exception {
        return sqlSession.selectList("ResMapper.getUserResList", userId);
        // getResCalUser 을 호출하면 리스트가 뽑혀서 달력에 찍어줄 예정이므로 mapper의 이름은 getUserResList로 잡음
        // 이걸 이름을 동일하게 갈지는 고민을 해 보겠음
    }

    @Override
    public List<AddCatering> getResCalTruck(String truckId) throws Exception {
        return sqlSession.selectList("ResMapper.getTruckResList", truckId);
        // getResCalTruck 을 호출하면 리스트가 뽑혀서 달력에 찍어줄 예정이므로 mapper의 이름은 getTruckResList 잡음
        // 이걸 이름을 동일하게 갈지는 고민을 해 보겠음
    }
*/

    @Override
    public Map<String, Object> getUserResList(Search search, String userId) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("search",search);
        map.put("userId", userId);
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
    public void updateUserRes(int resNo, int resStatus) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("resNo",resNo);
        map.put("resStatus", resStatus);
        sqlSession.update("ResMapper.updateUserRes", map);
    }
}
