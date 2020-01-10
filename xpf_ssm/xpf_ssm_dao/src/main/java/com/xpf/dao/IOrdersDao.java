package com.xpf.dao;

import com.xpf.domain.Member;
import com.xpf.domain.Orders;
import com.xpf.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2019/12/31 14:28
 * @Email：x2358114512@163.com
 */
@Repository
public interface IOrdersDao {

    /**
     * 查询所有的用户信息
     * @return
     */
    @Select("select * from orders")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one = @One(select = "com.xpf.dao.IProductDao.findById"))
           })
    List<Orders> findAll()throws Exception;

    /**
     * 根据订单编号查询该订单的详细信息：多表操作
     * @param ordersId
     * @return
     * @throws Exception
     */
    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",javaType = Product.class,one = @One(select = "com.xpf.dao.IProductDao.findById")),
            @Result(column = "id",property = "travellers",javaType = java.util.List.class,many = @Many(select = "com.xpf.dao.ITravellerDao.findByOrdersId")),
            @Result(column = "memberId",property = "member",javaType = Member.class,one = @One(select = "com.xpf.dao.IMemberDao.findById"))
    })
    Orders findById(String ordersId)throws Exception;


//    @Select("select * from orders where id=#{ordersId}")
//    @Results({
//            @Result(id = true, property = "id", column = "id"),
//            @Result(property = "orderNum", column = "orderNum"),
//            @Result(property = "orderTime", column = "orderTime"),
//            @Result(property = "orderStatus", column = "orderStatus"),
//            @Result(property = "peopleCount", column = "peopleCount"),
//            @Result(property = "peopleCount", column = "peopleCount"),
//            @Result(property = "payType", column = "payType"),
//            @Result(property = "orderDesc", column = "orderDesc"),
//            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.xpf.dao.IProductDao.findById")),
//            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.xpf.dao.IMemberDao.findById")),
//            @Result(property = "travellers",column = "id",javaType =java.util.List.class,many = @Many(select = "com.xpf.dao.ITravellerDao.findByOrdersId"))
//    })
//    Orders findById(String ordersId) throws Exception;
}
