package com.crud.ffin.service.cmnt;

import com.crud.ffin.common.Search;
import com.crud.ffin.service.domain.Msg;

import java.util.ArrayList;
import java.util.Map;

public interface CmntDao {

    public ArrayList<Msg> messageList(Msg to) throws Exception;
    public ArrayList<Msg> roomContentList(Msg to) throws Exception;
    public int messageSendInlist(Msg to) throws Exception;

}
