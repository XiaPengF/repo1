package com.xpf.service.impl;

import com.xpf.dao.IRoleDao;
import com.xpf.domain.Permission;
import com.xpf.domain.Role;
import com.xpf.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2020/1/1 15:14
 * @Email：x2358114512@163.com
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao iRoleDao;

    @Override
    public List<Role> findAll() throws Exception{
        return iRoleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        iRoleDao.save(role);
    }

    @Override
    public Role findById(String roleId) {
        return iRoleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermission(String roleId) {
        return iRoleDao.findOtherPermission(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {
        for (String permissionId:permissionIds) {
            iRoleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
