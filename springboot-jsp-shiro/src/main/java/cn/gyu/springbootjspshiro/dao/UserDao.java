package cn.gyu.springbootjspshiro.dao;

import cn.gyu.springbootjspshiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    void save(User user);

    User findByName(String username);
}
