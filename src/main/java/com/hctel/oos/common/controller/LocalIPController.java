package com.hctel.oos.common.controller;

import com.hctel.oos.common.service.impl.LocalIPService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/12/12 11:19
 * @Version 0.1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/server")
public class LocalIPController {
    @Resource
    private LocalIPService localIPService;

    @GetMapping
    public List<String> getLocalIPList() {
        return localIPService.getLocalIPList();
    }
}
