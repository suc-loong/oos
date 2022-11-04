package com.hctel.oos.common.controller;

import com.hctel.oos.common.service.impl.LeftTreeViewService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/26 15:12
 * @Version 0.1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/topology/node/{node}")
public class LeftTreeView {
    @Resource
    private LeftTreeViewService leftTreeViewService;

    @GetMapping("/left-tree-view")
    public String getLeftTreeView(@PathVariable String node){
        return leftTreeViewService.getLeftTreeView(node);
    }


}
