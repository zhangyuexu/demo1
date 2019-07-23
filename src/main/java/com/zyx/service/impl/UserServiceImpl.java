package com.zyx.service.impl;

import com.zyx.mapper.UserMapper;
import com.zyx.pojo.User;
import com.zyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(cacheNames = "user")
    public int add(User user) {
        userMapper.insert(user);
        //插入数据库，生成自增主键后，它会映射到User对象里去，即keyProperty
        int id = user.getId();
        return id;
    }

    @Override
    @Cacheable(cacheNames = "users")
    public List<User> findAllUser() {

        return userMapper.getAll();
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int addAccount() {
        User user = new User();
        user.setCreateTime(new Date());
        user.setAge(18);
        user.setName("测试事务");
        user.setPhone("13209900");
        userMapper.insert(user);

        int i = 9/0;
        int id = user.getId();
        return id;
    }

    @Override
    //@CachePut：作用是主要针对方法配置，能够根据方法的请求参数对其结果进行缓存，和 @Cacheable 不同的是，它每次都会触发真实查询
    @CachePut(cacheNames = "updateUser",condition = "#user!=null",unless = "#result>0")
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    //@CacheEvict：作用是主要针对方法配置，能够根据一定的条件对缓存进行清空
    //beforeInvocation:如果指定为 true，则在方法还没有执行的时候就清空缓存
    //allEntries = true  默认值，删除key对应的值
    @CacheEvict(cacheNames = "delUser",allEntries = true,beforeInvocation = true,condition = "#userId>0")
    public int delete(Long userId) {
        return userMapper.delete(userId);
    }


}
