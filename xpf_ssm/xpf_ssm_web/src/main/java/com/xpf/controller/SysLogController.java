package com.xpf.controller;

import com.xpf.domain.SysLog;
import com.xpf.domain.UserInfo;
import com.xpf.service.ISysLogService;
import com.xpf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2020/1/2 19:49
 * @Email：x2358114512@163.com
 */
@Controller
@RequestMapping(value = "sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping(value = "/findAll.do")
    public ModelAndView findAll() throws Exception {  //日志的查询

        ModelAndView modelAndView = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll();
        for (SysLog sysLog : sysLogs) {
            System.out.println(sysLog);
        }
        System.out.println("完成查询数据库");

        modelAndView.addObject("sysLogs", sysLogs);
        modelAndView.setViewName("syslog-list");

        return modelAndView;
    }

}
