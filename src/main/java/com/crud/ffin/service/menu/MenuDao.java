package com.crud.ffin.service.menu;

import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.Menu;
import com.crud.ffin.service.domain.OptionGroup;

import javax.swing.text.html.Option;
import java.util.List;

public interface MenuDao {

    //INSERT
    public void addMenu(Menu menu) throws Exception;

    //INSERT
    public void addOptionGroup(OptionGroup optionGroup) throws Exception;

    //SELECT ONE
    public Menu getMenu(int menuNo) throws Exception;

    //SELECT LIST
    public List<Menu> getMenuList(Search search) throws Exception;

    //UPDATE
    public void updateMenu(Menu menu) throws Exception;

    //UPDATE
    public void updateOptionGroup(OptionGroup optionGroup) throws Exception;

    // 게시판 page 처리를 위한 전체 Row(totalCount) return
    public int getTotalCount(Search search) throws Exception;
}
