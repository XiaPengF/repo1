package com.xpf.service;

import com.xpf.domain.Product;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2019/12/30 20:09
 * @Email：x2358114512@163.com
 */
public interface IProductService {
    /**
     * 查看所有产品的信息
     * @return
     * @throws Exception
     */
    public List<Product> findAll() throws Exception;

    /**
     * 添加产品
     * @param product
     */
    void save(Product product)throws Exception;
}
