package com.crud.ffin.service.menu.impl;

import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.Menu;
import com.crud.ffin.service.domain.OptionGroup;
import com.crud.ffin.service.menu.MenuDao;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("menuDaoImpl")
public class MenuDaoImpl implements MenuDao {

    ///FFF
    @Autowired
    @Qualifier("sqlSessionTemplate")
    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }


    ///MMM

    @Override
    public void addMenu(Menu menu) throws Exception {

        sqlSession.insert("MenuMapper.addMenu", menu);

    }

    @Override
    public void addOptionGroup(OptionGroup optionGroup) throws Exception {

        sqlSession.insert("MenuMapper.addOptionGroup", optionGroup);
    }

    @Override
    public Menu getMenu(int menuNo) throws Exception {
        return sqlSession.selectOne("MenuMapper.getMenu", menuNo);
    }

    @Override
    public List<Menu> getMenuList(Search search) throws Exception {
        return sqlSession.selectList("MenuMapper.getMenuList",search);
    }

    @Override
    public void updateMenu(Menu menu) throws Exception {

        sqlSession.update("MenuMapper.updateMenu", menu);

    }

    @Override
    public void updateOptionGroup(OptionGroup optionGroup) throws Exception {

        sqlSession.update("MenuMapper.updateOptionGroup", optionGroup);
    }

    @Override
    public int getTotalCount(Search search) throws Exception {
        return sqlSession.selectOne("MenuMapper.getTotalCount",search);
    }
}
