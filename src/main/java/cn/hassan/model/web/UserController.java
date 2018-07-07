package cn.hassan.model.web;

import cn.hassan.model.bean.User;
import cn.hassan.model.exception.BoException;
import cn.hassan.model.jms.MessageProducer;
import cn.hassan.model.jms.enums.DestinationEnums;
import cn.hassan.model.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/7/6 21:51
 * Description:
 */
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private MessageProducer producer;

    @ApiOperation(value="获取模型详细信息", notes="根据url的id来指定更新对象，根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    })
    @RequestMapping(value="/user/finduser/{id}", method=RequestMethod.GET)
    public User findUserById(@PathVariable Integer id) {
        return service.findUserById(id);
    }

    @ApiOperation(value="异常测试类")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @ApiOperation(value="异常测试类2")
    @RequestMapping(value="/json",method = RequestMethod.GET)
    public String json() throws BoException {
        throw new BoException("发生错误2");
    }

    @ApiOperation(value="redis测试类")
    @RequestMapping(value="/redis/{name}",method = RequestMethod.GET)
    public void setRedis(@PathVariable String name) {
        redisTemplate.opsForValue().set("name",name);
    }

    @ApiOperation(value="mq测试类")
    @RequestMapping(value="/mq",method = RequestMethod.GET)
    public void mqTest() {
        producer.send("hassan",DestinationEnums.SEND_USER_DESTINATION.value());
    }
}
