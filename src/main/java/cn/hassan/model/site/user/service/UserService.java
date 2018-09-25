package cn.hassan.model.site.user.service;

import cn.hassan.model.site.user.bean.User;
import cn.hassan.model.site.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

    @Transactional
	public void saveUser() {
		User user = new User();
		user.setUsername("hassan");
		user.setAddress("hangzhou");
		user.setBirthday(new Date());
		user.setPassward("123");
		user.setSex("1");
		userMapper.insert(user);

		int i = 10;
		int a = i / 0;

	}
}
