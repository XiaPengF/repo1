package com.xpf.service.impl;

import com.github.pagehelper.PageHelper;
import com.xpf.dao.IOrdersDao;
import com.xpf.domain.Orders;
import com.xpf.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2019/12/31 14:33
 * @Email：x2358114512@163.com
 */
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao iOrdersDao;

    @Override
    public List<Orders> findAll(int page, int size) throws Exception {

        //查询所有订单数据时通过PageHelper来分页显示：当前页码，当前页码的订单数
        PageHelper.startPage(page,size);
        return iOrdersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        System.out.println("ordersId is" + ordersId);
        return iOrdersDao.findById(ordersId);

    }
}
