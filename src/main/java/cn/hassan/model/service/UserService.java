package cn.hassan.model.service;

import cn.hassan.model.bean.User;
import cn.hassan.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/6 21:49
 * Description:
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
