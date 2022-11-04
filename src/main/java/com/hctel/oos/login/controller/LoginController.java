//package com.hctel.oos.login.controller;
//
//import com.alibaba.fastjson.JSON;
//
//
//import com.hctel.oos.login.dao.UserDao;
//import com.hctel.oos.login.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//
//import javax.annotation.Resource;
//import java.util.HashMap;
//
////@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
//@RestController
//public class LoginController {
//    @Resource
//    UserDao userDao;
//
//    @CrossOrigin
//    @RequestMapping("/test")
//    public String test() {
//        return "ok";
//    }
//
//    @RequestMapping("/login")
//    public String login(@RequestBody User user) {
//        User userByUI = userDao.queryUserByUI(user.getUsername(), user.getPassword());
//        System.out.println("user:" + userByUI);
//        HashMap<String, Object> res = new HashMap<>();
//        String flag = "ERROR";
//        if (userByUI != null) {
//            flag = "OK";
//        }
//        res.put("flag", flag);
//        res.put("user", user);
//        return JSON.toJSONString(res);
//    }
//
//    @RequestMapping("/register")
//    public String register(@RequestBody User user) {
//        User user1 = userDao.queryById(user.getUserid());
//        System.out.println("@" + user1);
//        System.out.println("user---" + user);
//        HashMap<String, Object> res = new HashMap<>();
//        String flag = "ERROR";
//        if (user1 == null) {
//            flag = "SUCCESS";
//            int insert = userDao.insert(user);
//            System.out.println(insert);
//        }
//        System.out.println(flag);
//        res.put("flag", flag);
//        res.put("user", user);
//        String s = JSON.toJSONString(res);
//        return s;
//    }
//
//
//}
