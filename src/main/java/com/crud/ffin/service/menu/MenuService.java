package com.crud.ffin.service.menu;

import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.Menu;

import java.util.Map;

public interface MenuService {

    //메뉴 등록
    public void addMenu(Menu menu) throws Exception;

    //메뉴 조회
    public Menu getMenu(int menuNo) throws Exception;

    //메뉴 목록 조회
    public Map<String, Object> getMenuList(Search search) throws Exception;

    //메뉴 수정
    public void updateMenu(Menu menu) throws Exception;

}
