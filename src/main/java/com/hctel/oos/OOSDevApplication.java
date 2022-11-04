package com.hctel.oos;

import com.hctel.oos.netconf.notifications.service.impl.SubscribeDeviceMessage;
import com.hctel.oos.netconf.service.NetconfService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * SpringBoot  启动器
 */
//包扫描，指定位置
//@MapperScan({"com.hctel.oos.ncmount","com.hctel.oos.netconf","com.hctel.oos.ncmount.me"})
@ComponentScan({"com.hctel.oos.ncmount","com.hctel.oos.netconf","com.hctel.oos.common","com.hctel.oos.login"})
@SpringBootApplication
public class OOSDevApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(OOSDevApplication.class, args);
        SubscribeDeviceMessage message = new SubscribeDeviceMessage();
        message.receiveNotification();

        if (false) {
            String[] names = run.getBeanDefinitionNames();
            int i = 0;
            for (String name : names) {
                System.out.println(name);
                i++;
            }
            System.out.println("\n" + i + "\n");
            //容器组件是单实例的
            NetconfService s1 = run.getBean("netconfService", NetconfService.class);
            NetconfService s2 = run.getBean("netconfService", NetconfService.class);
            System.out.println(s1 == s2);
        }
    }

}
