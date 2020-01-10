package com.xpf.service;

import com.xpf.domain.SysLog;

import java.util.List;

/**
 * @Author: Xia
 * @Date: 2020/1/2 19:52
 * @Email：x2358114512@163.com
 */
public interface ISysLogService {

    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll()throws Exception;
}
