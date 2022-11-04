package com.hctel.oos.ncmount.alarm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.alarm.service.AlarmService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 14:53
 * @Version 0.1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/topology/node/{node}/")
public class AlarmController {
    @Resource
    private AlarmService alarmService;

    @GetMapping("alarms")
    public JSONObject getAlarms(@PathVariable String node){
        return alarmService.getAlarms(node);
    }

    @GetMapping("alarms&history")
    public JSONObject getHistoryAlarms(@PathVariable String node,@RequestBody JSONObject input){
        return alarmService.getHistoryAlarms(node,input);
    }

    @GetMapping("alarms&mask")
    public JSONObject getAlarmMaskStates(@PathVariable String node){
        return alarmService.getAlarmMaskStates(node);
    }

    @PostMapping("alarms&mask")
    public String configAlarmMaskState(@PathVariable String node,@RequestBody JSONObject alarmMaskState){
        return alarmService.configAlarmMaskState(node,alarmMaskState);
    }


}
