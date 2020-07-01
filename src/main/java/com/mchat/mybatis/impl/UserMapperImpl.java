package com.mchat.mybatis.impl;

import com.mchat.entity.User;
import com.mchat.mybatis.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * UserDaoImpl
 *
 * @author zhangwenzhi
 * @description
 * @date 2020/7/1 11:27
 */
@Service
public class UserMapperImpl implements UserMapper {

    private SqlSession sqlSession;

    public UserMapperImpl() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    /**
     * 登录验证
     * @author zhangwenzhi
     * @date 2020/7/1 14:20
     */
    @Override
    public List verifyLoginInfo(Map para) throws Exception{
        String dlm = para.get("dlm").toString();
        String password = para.get("password").toString();

        User loginUser = new User();
        loginUser.setLogin_name(dlm);
        loginUser.setMm(password);

        List userList = sqlSession.selectList("UserMapper.selectUser", loginUser);
        return userList;
    }

}
