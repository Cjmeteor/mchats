package com.mchat.utils;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: zhangwenzhi
 * @time: 2020/4/16 11:15
 */
public class PubUtils {
    /**
     * 方法描述: 获取序列值
     * @author: zhangwenzhi
     * @time: 2020/4/16 11:16
     */
    public static String getSeqValue(String seqName) throws Exception{
        DE de = new DE();
        de.clearSql();
        de.addSql("select nextval('"+seqName+"')");
        List<Map> list = de.query();
        if(list.size()>0){
            return list.get(0).get("nextval").toString();
        }else{
            throw new Exception("运行出错");
        }
    }

    //每月多少天
    public static int MonthContainDays(int year,int month){
        if(isLeapYear(year)&&month==2) return 29;
        if(!isLeapYear(year)&&month==2) return 28;
        if(month==4||month==6||month==7||month==11) {
            return 30;
        }else{
            return 31;
        }
    }

    //判断闰年
    public static boolean isLeapYear(int year){
        return year / 4 == 0 && year / 100 != 0;
    }

    //各年龄创建子节点权重(权重—年龄）
    public static int getProbability(int currentAge){
        //4*(x-22)+40,-1*(x-62)
        int probability = 0;
        //年龄下界
        if(currentAge<13) return probability;

        if (currentAge<22) probability = 4*(currentAge-22)+50;

        if(currentAge>=22) probability = 72-currentAge;

        return probability;
    }

}
