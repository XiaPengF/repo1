package com.xpf.service;

import com.xpf.domain.Permission;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2020/1/1 16:14
 * @Email：x2358114512@163.com
 */
public interface IPermissionService {

    List<Permission> findAll() throws Exception;

    void save(Permission permission)throws Exception;
}
