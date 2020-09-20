package com.wfg.classloader;

import sun.misc.Launcher;
import sun.misc.URLClassPath;
import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;

/**
 * java
 *
 * @Title: com.wfg.jvm.classloader
 * @Date: 2020/8/29 9:25
 * @Author: wfg
 * @Description:
 * @Version:  虚拟机自带加载器
 */
public class ClassLoaderDemo1 {

    public static void main(String[] args) {
        System.out.println("********启动类加载器*********");
        URLClassPath bootstrapClassPath = Launcher.getBootstrapClassPath();
        //获取BootStrapClassLoader能够加载的api路径
        URL[] urLs = bootstrapClassPath.getURLs();
        for (URL urL : urLs) {
            System.out.println(urL);
            /**
             * file:/D:/Program%20Files/Java/jdk1.8.0_101/jre/lib/resources.jar
             * file:/D:/Program%20Files/Java/jdk1.8.0_101/jre/lib/rt.jar
             * file:/D:/Program%20Files/Java/jdk1.8.0_101/jre/lib/sunrsasign.jar
             * file:/D:/Program%20Files/Java/jdk1.8.0_101/jre/lib/jsse.jar
             * file:/D:/Program%20Files/Java/jdk1.8.0_101/jre/lib/jce.jar
             * file:/D:/Program%20Files/Java/jdk1.8.0_101/jre/lib/charsets.jar
             * file:/D:/Program%20Files/Java/jdk1.8.0_101/jre/lib/jfr.jar
             * file:/D:/Program%20Files/Java/jdk1.8.0_101/jre/classes
             */
        }

        //从上面的路径中随意选择一个类 看看他的类加载器是什么
        //Provider位于 /jdk1.8.0_171.jdk/Contents/Home/jre/lib/jsse.jar 下，引导类加载器加载它
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader);
        //null

        System.out.println("********拓展类加载器********");
        String extDirs = System.getProperty("java.ext.dirs");
        System.out.println(extDirs);
//        for (String path : extDirs.split(";")){
//            System.out.println(path);
//            /**
//             * D:\Program Files\Java\jdk1.8.0_101\jre\lib\ext
//             * C:\Windows\Sun\Java\lib\ext
//             */
//        }


        //从上面的路径中随意选择一个类 看看他的类加载器是什么:拓展类加载器
        ClassLoader classLoader1 = CurveDB.class.getClassLoader();
        System.out.println(classLoader1);
        //sun.misc.Launcher$ExtClassLoader@4b67cf4d


    }
}
