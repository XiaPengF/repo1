package com.xpf.service.impl;

import com.xpf.dao.IPermissionDao;
import com.xpf.domain.Permission;
import com.xpf.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2020/1/1 16:14
 * @Email：x2358114512@163.com
 */
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao iPermissionDao;

    @Override
    public List<Permission> findAll() throws Exception {
        return iPermissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        iPermissionDao.save(permission);

    }
}
