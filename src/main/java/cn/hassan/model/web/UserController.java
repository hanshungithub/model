package cn.hassan.model.web;

import cn.hassan.model.bean.User;
import cn.hassan.model.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/6 21:51
 * Description:
 */
@Api("模型接口")
@Controller
public class UserController {

    @Autowired
    private UserService service;

    @ApiOperation(value="获取模型详细信息")
    @ApiImplicitParam(name = "ID", value = "用户ID", required = true, dataType = "Integer")
    @GetMapping("/user/finduser")
    public User findUserById(Integer id) {
        return service.findUserById(id);
    }
}
