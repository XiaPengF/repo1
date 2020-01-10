package com.xpf.dao;

import com.xpf.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2019/12/31 16:59
 * @Email：x2358114512@163.com
 */
public interface ITravellerDao {

    /**
     * 根据ordersId查询游客信息
     * @param ordersId
     * @return
     * @throws Exception
     */
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
