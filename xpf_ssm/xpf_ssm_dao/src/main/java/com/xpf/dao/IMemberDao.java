package com.xpf.dao;

import com.xpf.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Xia
 * @Date: 2019/12/31 16:51
 * @Email：x2358114512@163.com
 */
public interface IMemberDao {
    /**
     * 根据id查询会员
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select * from member where id=#{id}")
    public Member findById(String id)throws Exception;
}
