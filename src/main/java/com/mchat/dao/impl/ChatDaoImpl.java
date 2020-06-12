package com.mchat.dao.impl;

import com.mchat.dao.ChatDao;
import com.mchat.utils.DE;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ChatDaoImpl
 *
 * @author zhangwenzhi
 * @description
 * @date 2020/6/5 15:39
 */
@Service
public class ChatDaoImpl implements ChatDao {

    @Override
    public List queryUser() throws Exception {
        DE de = new DE();
        de.clearSql();
        de.addSql(" select userid id, name text from mchat.user_info  ");
        return de.query();
    }
}
