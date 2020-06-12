package com.mchat.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: zhangwenzhi
 * @time: 2020/4/15 13:51
 */
public class DE {
    private static Connection c = null;
    private static Statement stmt = null;
    private static StringBuffer dSqlStringBuffer = new StringBuffer();

    public void DE() throws Exception {

    }

    public void addSql(String str) {
        dSqlStringBuffer.append(str);
    }

    public void clearSql() {
        dSqlStringBuffer = new StringBuffer();
    }

    //查询操作
    public List<Map> query() throws Exception {
        List<Map> list = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection(Constant.db_dataSource_url,
                Constant.db_dataSource_username, Constant.db_dataSource_password);
        c.setAutoCommit(false);
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery(dSqlStringBuffer.toString());
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
        stmt.close();
        c.close();
        return list;
    }

    //修改操作
    public int update() throws Exception {
        int code;
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection(Constant.db_dataSource_url,
                Constant.db_dataSource_username, Constant.db_dataSource_password);
        c.setAutoCommit(false);
        stmt = c.createStatement();
        code = stmt.executeUpdate(dSqlStringBuffer.toString());
        c.commit();
        stmt.close();
        c.close();
        return code;
    }


}
