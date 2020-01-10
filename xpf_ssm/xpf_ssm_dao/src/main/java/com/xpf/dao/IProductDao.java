package com.xpf.dao;

import com.xpf.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2019/12/30 20:05
 * @Email：x2358114512@163.com
 */
@Repository
public interface IProductDao {
    /**
     * 根据id查询产品
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from product where id=#{id}")
    public Product findById(String id)throws Exception;

    /**
     * 查看所有产品的信息
     * @return
     * @throws Exception
     */
    @Select("SELECT * FROM PRODUCT")
    public List<Product> findAll() throws Exception;

    /**
     * 添加产品到数据库中
     * @param product
     * @throws Exception
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values (#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product)throws Exception;
}
