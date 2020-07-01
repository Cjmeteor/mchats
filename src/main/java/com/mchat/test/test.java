package com.mchat.test;

/**
 * test
 *
 * @author zhangwenzhi
 * @description
 * @date 2020/6/24 16:49
 */
public class test {

    public static void main(String[] arg){
        System.out.println(getGenderFromCard("230125199609123710"));
    }

    private static String getGenderFromCard(String card){
        if (Integer.valueOf(card.substring(16, 17)) % 2 == 1) {
            return "1";
        } else {
            return "2";
        }
    }
}
