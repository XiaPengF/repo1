package com.xpf.controller;

import com.github.pagehelper.PageInfo;
import com.xpf.domain.Orders;
import com.xpf.domain.Product;
import com.xpf.service.IOrdersService;
import com.xpf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2019/12/31 14:35
 * @Email：x2358114512@163.com
 */
@Controller
@RequestMapping(value = "/orders")
public class OrdersController {
    @Autowired
    private IOrdersService iOrdersService;

//    //查询订单数据没有分页的情况（注意：aside.jsp中要修改一些参数）
//    @RequestMapping(value = "/findAll.do")
//    public ModelAndView findAll() throws Exception {  //订单的查询
//        ModelAndView modelAndView = new ModelAndView();
//        List<Orders> all = iOrdersService.findAll();
//        for (Orders product: all) {
//            System.out.println(product);
//        }
//        System.out.println("完成查询数据库");
//
//        modelAndView.addObject("ordersList", all);
//        modelAndView.setViewName("orders-list");
//
//        return modelAndView;
//    }


    //查询订单数据为分页的情况（注意：aside.jsp中要修改一些参数）
    @RequestMapping(value = "/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "4")Integer size) throws Exception {  //订单的查询
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> all = iOrdersService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(all);
//        for (Orders product: all) {
//            System.out.println(product);
//        }
        System.out.println("完成查询数据库");

        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("orders-page-list");

        return modelAndView;
    }

    //查询订单数据中的订单详情：多表操作
    @RequestMapping(value = "/findById.do")
    public ModelAndView findById( @RequestParam(name = "id",required = true) String ordersId) throws Exception {  //订单的详情查询
        ModelAndView modelAndView = new ModelAndView();
        Orders orders = iOrdersService.findById(ordersId);
        System.out.println(orders);
        System.out.println("完成查询数据库");

        modelAndView.addObject("orders", orders);
        modelAndView.setViewName("orders-show");

        return modelAndView;
    }


}
