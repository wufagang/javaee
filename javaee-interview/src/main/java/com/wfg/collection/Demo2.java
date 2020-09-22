package com.wfg.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * java
 *
 * @Title: com.wfg.collection
 * @Date: 2020/8/29 16:13
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class Demo2 {

    public static void main(String[] args) {
        //HashSet线程不安全

        Set<String> set  = new CopyOnWriteArraySet(new HashSet());
    }
}
