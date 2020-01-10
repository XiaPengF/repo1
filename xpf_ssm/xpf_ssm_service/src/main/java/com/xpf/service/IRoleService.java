package com.xpf.service;

import com.xpf.domain.Permission;
import com.xpf.domain.Role;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2020/1/1 15:13
 * @Email：x2358114512@163.com
 */
public interface IRoleService {

    List<Role> findAll()throws Exception;

    void save(Role role)throws Exception;

    Role findById(String roleId);

    List<Permission> findOtherPermission(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);
}
