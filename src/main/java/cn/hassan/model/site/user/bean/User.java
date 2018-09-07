package cn.hassan.model.site.user.bean;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String password;

    private String username;

    private Date birthday;

    private String sex;

    private String address;
}