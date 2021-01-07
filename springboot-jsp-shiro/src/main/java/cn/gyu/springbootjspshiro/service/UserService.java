package cn.gyu.springbootjspshiro.service;

import cn.gyu.springbootjspshiro.entity.User;

public interface UserService {
    void register(User user);

    User findByName(String username);
}
