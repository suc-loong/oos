package com.hctel.oos.ftpserver;

import com.hctel.oos.common.utils.IPUtils;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Authority;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/12/9 16:03
 * @Version 0.1.0
 */
public class FtpServer4Odl {
    public void ftpServerStarter() {
        FtpServerFactory serverFactory = new FtpServerFactory();

        ListenerFactory factory = new ListenerFactory();
        //设置监听端口
        factory.setPort(21);
        String ip = null;
        try {
            ip = IPUtils.getLocalHostLANAddress().getHostAddress();
            System.out.println("ip: "+ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        factory.setServerAddress("192.168.10.58");

        //替换默认监听
        serverFactory.addListener("default", factory.createListener());

        //用户名
        BaseUser user = new BaseUser();
        user.setName("admin");
        //密码 如果不设置密码就是匿名用户
        user.setPassword("123456");
        //用户主目录
        user.setHomeDirectory("E:\\FTPServerPath");

        List<Authority> authorities = new ArrayList<Authority>();
        //增加写权限
        authorities.add(new WritePermission());
        user.setAuthorities(authorities);

        //增加该用户
        try {
            serverFactory.getUserManager().save(user);
        } catch (FtpException e) {
            e.printStackTrace();
        }

        /**
         * 也可以使用配置文件来管理用户
         */
//      PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
//      userManagerFactory.setFile(new File("users.properties"));
//      serverFactory.setUserManager(userManagerFactory.createUserManager());

        FtpServer server = serverFactory.createServer();
        try {
            server.start();
        } catch (FtpException e) {
            e.printStackTrace();
        }
    }
}
