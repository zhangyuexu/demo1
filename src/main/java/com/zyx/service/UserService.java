package com.zyx.service;

import com.zyx.pojo.User;

import java.util.List;

public interface UserService {

    public int add(User user);

    public List<User> findAllUser();

    //测试事务
    public int addAccount();

    public int update(User user);

    public int delete(Long userId);
}
