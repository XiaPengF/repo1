package com.xpf.service.impl;

import com.xpf.dao.ISysLogDao;
import com.xpf.domain.SysLog;
import com.xpf.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2020/1/2 19:58
 * @Email：x2358114512@163.com
 */
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao iSysLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        iSysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() throws Exception {
        return iSysLogDao.findAll();
    }
}
