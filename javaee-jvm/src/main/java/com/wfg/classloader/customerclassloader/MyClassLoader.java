package com.wfg.classloader.customerclassloader;

import java.io.*;

/**
 * java
 *
 * @Title: com.wfg.jvm.classloader.customerClassLoader
 * @Date: 2020/8/29 9:37
 * @Author: wfg
 * @Description:
 * @Version:
 */
public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] bytes = getClassFromCustomerPaher(name);
        if(bytes==null){
            throw new ClassNotFoundException("文件未找到");
        }else {
            return defineClass(name,bytes,0,bytes.length);
        }
    }


    private byte[] getClassFromCustomerPaher(String name) throws ClassNotFoundException {
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        byte[] data = null;

        try{

            // 读取文件内容

            //name = name.replaceAll("\\.","\\\\");

            System.out.println("加载文件名："+name);

            // 将文件读取到数据流中

            fis = new FileInputStream(name);

            baos = new ByteArrayOutputStream();

            int ch = 0;

            while ((ch = fis.read()) != -1){

                baos.write(ch);

            }

            data = baos.toByteArray();

        }catch (Exception e){

            throw new ClassNotFoundException("Class is not found:"+name,e);

        }finally {

            // 关闭数据流

            try {

                fis.close();

                baos.close();

            }catch (Exception e){

                e.printStackTrace();

            }

        }

        return data;


    }


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> clss = Class.forName("D:\\projectopen\\java\\out\\production\\02-volatile\\com\\wfg\\demo1.class", true, myClassLoader);
        Object o = clss.newInstance();
        System.out.println(o.getClass().getClassLoader());
    }
}
