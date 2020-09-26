package com.wfg.mylock;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * javaee
 *
 * @Title: com.wfg.mylock
 * @Date: 2020/9/26 11:37
 * @Author: wfg
 * @Description:
 * @Version:
 */
public enum CountDownLatchEnum {

    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FORE(4,"赵"),FIVE(5,"魏"),SIX(6,"韩");

    CountDownLatchEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static CountDownLatchEnum foreachEnum(int index){
        CountDownLatchEnum[] countDownLatchEnums = CountDownLatchEnum.values();
        for (CountDownLatchEnum item: countDownLatchEnums ) {
            if (item.getCode()==index){
                return item;
            }
        }

        return null;
    }
}
