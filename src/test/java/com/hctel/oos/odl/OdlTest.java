package com.hctel.oos.odl;

import com.hctel.oos.ncmount.utils.Ncmount;
import org.junit.jupiter.api.Test;

public class OdlTest {



    @Test
    public void connected(){
        System.out.println("开始连接测试");
        /**
         * 在Topology节点上注册监听器
         */

        Ncmount ncmount = new Ncmount();
        ncmount.getDevices(null);


    }



    @Test
    public void testSubscribe(){


    }
}
