package com.mchat.dao.impl;

import com.alibaba.fastjson.JSONObject;
import com.mchat.dao.ChatDao;
import com.mchat.utils.DE;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public List queryUser(Map para) throws Exception {
        String userid = (String)para.get("userid");
        DE de = new DE();
        de.clearSql();
        de.addSql(" select userid, username, state from mchat.user_info  ");
        de.addSql("  where userid <> '"+userid+"' or userid IS NULL");
        return de.query();
    }

    @Override
    public List verifyLoginInfo(Map para) throws Exception{
        String dlm = para.get("dlm").toString();
        String password = para.get("password").toString();

        DE de = new DE();
        de.clearSql();
        de.addSql(" select userid, username, state from mchat.user_info  ");
        de.addSql("  where login_name = :dlm");

        de.setValue("dlm",dlm);
        de.setValue("password",password);
        return de.query();
    }
}
