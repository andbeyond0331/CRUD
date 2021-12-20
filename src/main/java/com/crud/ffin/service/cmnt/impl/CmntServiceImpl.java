package com.crud.ffin.service.cmnt.impl;

import com.crud.ffin.service.cmnt.CmntDao;
import com.crud.ffin.service.cmnt.CmntService;
import com.crud.ffin.service.domain.Msg;
import com.crud.ffin.service.res.ResDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("cmntServiceImpl")
public class CmntServiceImpl implements CmntService {

    @Autowired
    @Qualifier("cmntDaoImpl")
    private CmntDao cmntDao;

    public CmntServiceImpl() {
        System.out.println(this.getClass());
    }


    @Override
    public ArrayList<Msg> messageList(Msg to) throws Exception {
        return cmntDao.messageList(to);
    }

    @Override
    public ArrayList<Msg> roomContentList(Msg to) throws Exception {
        return cmntDao.roomContentList(to);
    }

    @Override
    public int messageSendInlist(Msg to) throws Exception {
        return cmntDao.messageSendInlist(to);
    }
}
