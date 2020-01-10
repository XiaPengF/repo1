package com.xpf.controller;

import com.xpf.domain.Orders;
import com.xpf.domain.Product;
import com.xpf.domain.Role;
import com.xpf.domain.UserInfo;
import com.xpf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2020/1/1 11:41
 * @Email：x2358114512@163.com
 */
@Controller
@RequestMapping(value = "/user")  // /product/findAll.do
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/findAll.do")
    public ModelAndView findAll() throws Exception {  //产品的查询

        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> users = userService.findAll();
        for (UserInfo userInfo : users) {
            System.out.println(userInfo);
        }
        System.out.println("完成查询数据库");

        modelAndView.addObject("userList", users);
        modelAndView.setViewName("user-list");

        return modelAndView;
    }

    @RequestMapping(value = "/save.do")  //注意除了查询，增删改需要事务的支持（在service层开启事务）
    public String save(UserInfo userInfo) throws Exception {  //用户的添加操作
        userService.save(userInfo);

        return "redirect:findAll.do";  //添加用户后需要再查询一次用户表
    }

    //查询用户数据中的用户详情：多表操作
    @RequestMapping(value = "/findById.do")
    public ModelAndView findById( @RequestParam(name = "id",required = true) String id) throws Exception {  //订单的详情查询
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        System.out.println(userInfo);
        System.out.println("完成查询数据库");

        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("user-show");

        return modelAndView;
    }


    //查询用户及用户可以添加的角色
    @RequestMapping(value = "/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole( @RequestParam(name = "id",required = true) String userid)  throws Exception{
        ModelAndView modelAndView = new ModelAndView();

        //1.根据用户id查询出用户
        UserInfo userInfo = userService.findById(userid);

        //2.根据用户id查询出可以添加的角色
        List<Role> otherRoles = userService.findOtherRole(userid);

        modelAndView.addObject("user", userInfo);
        modelAndView.addObject("roleList", otherRoles);
        modelAndView.setViewName("user-role-add");

        return modelAndView;
    }

    //给用户添加角色
    @RequestMapping(value = "/addRoleToUser.do")
    public String addRoleToUser( @RequestParam(name = "userId",required = true) String userId,
                                 @RequestParam(name = "ids",required = true) String[] roleIds ){
        userService.addRoleToUser(userId,roleIds);
        return  "redirect:findAll.do";
    }


}
