package com.xpf.service.impl;

import com.xpf.dao.IUserDao;
import com.xpf.domain.Role;
import com.xpf.domain.UserInfo;
import com.xpf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: Xia
 * @Date: 2019/12/31 21:14
 * @Email：x2358114512@163.com
 */
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = null;
        try {
            userInfo = iUserDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //将自己查询的用户对象封装给spring-security框架中，让spring-security框架接着处理

//        User user = new User(userInfo.getUsername(),"{noop}"+ userInfo.getPassword(), getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(), userInfo.getPassword(),
                userInfo.getStatus()==0 ? false : true ,  //userInfo.getStatus()==0 表示此账户不可用
                true,true,true,
                getAuthority(userInfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();

        for (Role role:roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() throws Exception{
        return iUserDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) throws Exception {
        // 对密码进行加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));

        iUserDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String userId) throws Exception {
        return iUserDao.findById(userId);
    }

    @Override
    public List<Role> findOtherRole(String userid) {
        return iUserDao.findOtherRole(userid);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) {
        for (String roleId: roleIds) {
            iUserDao.addRoleToUser(userId, roleId);
        }
    }
}
