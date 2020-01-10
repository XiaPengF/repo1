package com.xpf.controller;

import com.xpf.domain.Permission;
import com.xpf.domain.Role;
import com.xpf.domain.UserInfo;
import com.xpf.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2020/1/1 15:56
 * @Email：x2358114512@163.com
 */
@Controller
@RequestMapping(value = "/role")  // /product/findAll.do
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping(value = "/findAll.do")

    public ModelAndView findAll() throws Exception{

        ModelAndView modelAndView = new ModelAndView();
        List<Role> roles = roleService.findAll();
        for (Role role : roles) {
            System.out.println(role);
        }
        System.out.println("完成查询数据库");

        modelAndView.addObject("roleList", roles);
        modelAndView.setViewName("role-list");

        return modelAndView;
    }


    @RequestMapping(value = "/save.do")  //注意除了查询，增删改需要事务的支持（在service层开启事务）
    public String save(Role role) throws Exception {  //角色的添加操作
        roleService.save(role);

        return "redirect:findAll.do";  //添加用户后需要再查询一次用户表
    }

    //查询角色及用户可以添加的权限
    @RequestMapping(value = "/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission( @RequestParam(name = "id",required = true) String roleId)  throws Exception{
        ModelAndView modelAndView = new ModelAndView();

        //1.根据用户id查询出角色
        Role role = roleService.findById(roleId);

        //2.根据用户id查询出可以添加的权限
        List<Permission> otherPermissions = roleService.findOtherPermission(roleId);

        modelAndView.addObject("role", role);
        modelAndView.addObject("permissionList", otherPermissions);
        modelAndView.setViewName("role-permission-add");

        return modelAndView;
    }

    //给用户添加角色
    @RequestMapping(value = "/addPermissionToRole.do")
    public String addPermissionToRole( @RequestParam(name = "roleId",required = true) String roleId,
                                 @RequestParam(name = "ids",required = true) String[]permissionIds ){
        roleService.addPermissionToRole(roleId, permissionIds);
        return  "redirect:findAll.do";
    }

}
