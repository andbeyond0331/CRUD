package com.crud.ffin.service.menu.impl;

import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.Menu;
import com.crud.ffin.service.menu.MenuDao;
import com.crud.ffin.service.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("menuServiceImpl")
public class MenuServiceImpl implements MenuService {

    //FFF
    @Autowired
    @Qualifier("menuDaoImpl")
    private MenuDao menuDao;
    public void setMenuDao(MenuDao menuDao){
        this.menuDao = menuDao;
    }

    ///CCC
    public MenuServiceImpl(){
        System.out.println(this.getClass());
    }

    ///MMM
    @Override
    public void addMenu(Menu menu) throws Exception {
        menuDao.addMenu(menu);
    }

    @Override
    public Menu getMenu(int menuNo) throws Exception {
        return menuDao.getMenu(menuNo);
    }

    @Override
    public Map<String, Object> getMenuList(Search search) throws Exception {
        List<Menu> list = menuDao.getMenuList(search);
        int totalCount = menuDao.getTotalCount(search);

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("list",list);
        map.put("totalCount", new Integer(totalCount));

        return map;
    }

    @Override
    public void updateMenu(Menu menu) throws Exception {

        menuDao.updateMenu(menu);

    }
}
