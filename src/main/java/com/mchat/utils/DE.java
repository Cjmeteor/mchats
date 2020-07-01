package com.mchat.utils;

import java.sql.*;
import java.util.*;

/**
 * @description
 * @author zhangwenzhi
 * @date 2020/4/15 13:51
 */
public class DE {
    private static Connection connection = null;
    private static Statement stmt = null;
    private static StringBuffer dSqlStringBuffer = new StringBuffer();
    private static Map<String,Object> valueMap = new HashMap<String,Object>();

    public DE() throws Exception{
        if(connection == null || stmt == null){
            System.out.println("连接数据库");
            setConnection();
        }
    }

    public void addSql(String str) {
        dSqlStringBuffer.append(str);
    }

    public void clearSql() {
        dSqlStringBuffer.delete(0,dSqlStringBuffer.length());
        valueMap.clear();
    }

    public void setValue(String key,Object value){
        valueMap.put(key,value);
    }

    //查询操作
    public List<Map> query() throws Exception {
        if(connection == null || stmt == null){
            System.out.println("查询操作重新连接数据库");
            setConnection();
        }
        List<Map> list = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(formatSqlBeforExecute(dSqlStringBuffer));
        // 通过此对象可以得到表的结构，包括，列名，列的个数，列数据类型
        while (rs.next()) {
            Map<String, Object> map = new HashMap<>();
            for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                String colName = rs.getMetaData().getColumnName(i);
                Object value = rs.getObject(colName);//获取列对应的值。
                map.put(colName, value);
            }
            list.add(map);
        }
        rs.close();
        return list;
    }


    //修改操作
    public int update() throws Exception {
        if(connection == null || stmt == null){
            System.out.println("update时重新连接数据库");
            setConnection();
        }
        int code;
        Class.forName("org.postgresql.Driver");
        code = stmt.executeUpdate(formatSqlBeforExecute(dSqlStringBuffer));
        connection.commit();
        /*stmt.close();
        connection.close();*/
        return code;
    }

    /**
     * 连接数据库
     * @author zhangwenzhi
     * @date 2020/7/1 9:43
     */
    private void setConnection() throws Exception{
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(Constant.db_dataSource_url,
                Constant.db_dataSource_username, Constant.db_dataSource_password);
        connection.setAutoCommit(false);
        stmt = connection.createStatement();
    }

    /**
     * sql数值替换
     * @author zhangwenzhi
     * @date 2020/6/30 15:44
     */
    private String formatSqlBeforExecute(StringBuffer stringBuffer){
        String finlStr = stringBuffer.toString();

        for (Map.Entry<String, Object> entry : valueMap.entrySet()) {
            finlStr = finlStr.replace(":"+entry.getKey(),"'"+entry.getValue()+"'");
        }

        return finlStr;
    }

}
