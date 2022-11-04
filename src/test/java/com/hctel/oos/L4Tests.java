package com.hctel.oos;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import javax.xml.bind.SchemaOutputResolver;

import static java.lang.StrictMath.*;

public class L4Tests {



    /**
     * 计算字节长度和取整
     */
    @Test
    public void testCharLong(){
        byte aa1 = 2;
        short aa2 = 21321;
        int aa3 = 2321;
        long aa4 = 2321;
        char cc1 = 2;
        String ss1 = "java计算字节长度";
        StringBuffer ss2 = new StringBuffer("java计算字节长度");

        System.out.println("aa1: "+String.valueOf(aa1).getBytes().length);
        System.out.println("aa2: "+String.valueOf(aa2).getBytes().length);
        System.out.println("aa3: "+String.valueOf(aa3).getBytes().length);
        System.out.println("aa4: "+String.valueOf(aa4).getBytes().length);
        System.out.println("===============================");


        //floor函数，其功能是“向下取整”，或者说“向下舍入”、“向零取舍”，即取不大于x的最大整数
        double nDigits = floor(log10(abs(aa2))) + 1;
        System.out.println("-> "+nDigits);
        //ceil函数是向上取整，它返回的是大于或等于函数参数,并且与之最接近的整数
        double nCeil = ceil(log10(abs(aa2)));
        System.out.println("-> "+nCeil);
        //round函数是四舍五入
        double nRound = round(log10(abs(aa2)));
        System.out.println("-> "+nRound);

        System.out.println(ss1.getBytes().length);
        System.out.println(ss1.length());
        System.out.println("--------------------------");
        System.out.println(ss2.toString().getBytes().length);
        System.out.println(ss2.length());


    }

    /**
     * 测试字符自动隐藏转换
     */
    @Test
    public void autoConversion(){
        //C++中，某些数据占多少位，多少字节，是与机器操作系统，硬件，有关系的。
        //而java中，是与操作系统，硬件无关的，因为java是运行在虚拟机上的，所以数据大小都是固定的

        byte aa1 = 2;
        short aa2 = 21321;
        int aa3 = 2321;
        long aa4 = 2321L;
        float aa5 = 1.0F;

        //不加f直接默认是double
        System.out.println("float aa5: "+aa5);
        double aa6 = 0.2;
        //在Java中是16位的,因为Java用的是Unicode，支持中文变量名
        char aa7 = '2';
        char aa8 = 'd';
        System.out.println("char aa7: "+aa7);
        System.out.println("char aa8: "+aa8);
        String ss1 = "java计算字节长度";
        StringBuffer ss2 = new StringBuffer("java计算字节长度");
        System.out.println("=============================");
        short tt1 = aa1;
        System.out.println("byte  -> short  tt1: \t"+tt1);
        int tt2 = aa2;
        System.out.println("short -> int    tt2: \t"+tt2);
        long tt3 = aa3;
        System.out.println("int   -> long   tt3: \t"+tt3);
        long tt4 = aa1;
        System.out.println("byte  -> long   tt4: \t"+tt4);
        float tt5 = aa4;
        System.out.println("long  -> float  tt5: \t"+tt5);
        double tt6 = aa5;
        System.out.println("float -> double tt6: \t"+tt6);

        System.out.println("=============================");
        String ss3 = aa5 + "";
        System.out.println("float + 空字符串 ss3: "+ss3);
        String ss4 = 1 + 2+ ss1;
        System.out.println("数字 + 数字 + String ss4："+ss4);
        //ss1+1时 会把1当成成字符串处理
        String ss5 = ss1 + 1 + 2;
        System.out.println("String + 数字 + 数字 ss5："+ss5);

    }
}
