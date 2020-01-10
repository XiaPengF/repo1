package com.xpf.controller;

import com.xpf.domain.Permission;
import com.xpf.domain.Role;
import com.xpf.service.IPermissionService;
import com.xpf.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2020/1/1 16:11
 * @Email：x2358114512@163.com
 */
@Controller
@RequestMapping(value = "/permission")  // /product/findAll.do
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;

    @RequestMapping(value = "/findAll.do")

    public ModelAndView findAll() throws Exception{

        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissions = permissionService.findAll();
        for (Permission permission : permissions) {
            System.out.println(permission);
        }
        System.out.println("完成查询数据库");

        modelAndView.addObject("permissionList", permissions);
        modelAndView.setViewName("permission-list");

        return modelAndView;
    }


    @RequestMapping(value = "/save.do")  //注意除了查询，增删改需要事务的支持（在service层开启事务）
    public String save(Permission permission) throws Exception {  //角色的添加操作
        permissionService.save(permission);

        return "redirect:findAll.do";  //添加用户后需要再查询一次用户表
    }
}
