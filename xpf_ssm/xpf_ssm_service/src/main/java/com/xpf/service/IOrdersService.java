package com.xpf.service;

import com.xpf.domain.Orders;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2019/12/31 14:31
 * @Email：x2358114512@163.com
 */

public interface IOrdersService {

    /**
     * 查询所有的用户信息
     * @return
     * @param page
     * @param size
     */
    List<Orders> findAll(int page, int size)throws Exception;

    Orders findById(String ordersId) throws Exception;
}
