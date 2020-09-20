package com.wfg.classloader;

/**
 * java
 *
 * @Title: com.wfg.jvm.classloader
 * @Date: 2020/8/29 6:24
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {

        //获取 系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);
        //sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取系统类上层  扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);
        //sun.misc.Launcher$ExtClassLoader@4554617c

        //尝试获取引导类加载器-->获取不到引导类加载器
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);
        //null


        //用户类加载使用类加载器 -->使用系统类加载器进行加载
        ClassLoader demoClassLoader = ClassLoaderDemo.class.getClassLoader();
        System.out.println(demoClassLoader);
        //sun.misc.Launcher$AppClassLoader@18b4aac2

        //java核心类使用类加载器-->java核心类库都是使用引导类加载器加载的
        ClassLoader stringClassLoader = String.class.getClassLoader();
        System.out.println(stringClassLoader);
        //null

    }
}
