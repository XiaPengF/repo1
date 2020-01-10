package com.xpf.service;

import com.xpf.domain.Role;
import com.xpf.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2019/12/31 21:13
 * @Email：x2358114512@163.com
 */
public interface IUserService extends UserDetailsService {
    /**
     * 查询所有用户的方法
     * @return
     */
    List<UserInfo> findAll()throws Exception;

    void save(UserInfo userInfo) throws  Exception;

    UserInfo findById(String userId) throws  Exception;

    List<Role> findOtherRole(String userid);

    void addRoleToUser(String userId, String[] roleIds);
}
