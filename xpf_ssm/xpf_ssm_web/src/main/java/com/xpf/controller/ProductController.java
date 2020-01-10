package com.xpf.controller;

import com.xpf.domain.Product;
import com.xpf.service.IProductService;
import com.xpf.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Xia
 * @Date: 2019/12/30 20:43
 * @Email：x2358114512@163.com
 */
@Controller
@RequestMapping(value = "/product")  // /product/findAll.do
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping(value = "/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception {  //产品的查询
        ModelAndView modelAndView = new ModelAndView();
        List<Product> all = productService.findAll();
        for (Product product: all) {
            System.out.println(product);
        }
        System.out.println("完成查询数据库");

        modelAndView.addObject("productList", all);
        modelAndView.setViewName("product-list");

        return modelAndView;
    }

    @RequestMapping(value = "/save.do")  //注意除了查询，增删改需要事务的支持（在service层开启事务）
    public String save(Product  product) throws Exception {  //产品的添加
        productService.save(product);

        return "redirect:findAll.do";
    }
}
