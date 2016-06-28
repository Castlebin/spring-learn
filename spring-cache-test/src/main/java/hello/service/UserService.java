package hello.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;

import hello.bean.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

    @Cacheable("user")
    public User getUserByName(String name) {
        log.info("UserService.getUserByName()-> name: " + name);
        User user = new User(name, 18);

        return user;
    }

    @Cacheable("user")
    public User getAnotherUserByName(String name) {
        log.info("UserService.getAnotherUserByName()-> name: " + name);
        User user = new User(name, 20);

        return user;
    }

    /**
     * 错误！参数列表与getNow()方法一样，存放于同样的cache空间中，
     * 分别访问两个方法后会类型转换报错：类型转换错误！
     */
    @Cacheable("user")
    public User getUser() {
        log.info("UserService.getUser()-> name: " + "唐僧");
        User user = new User("唐僧", 20);

        return user;
    }

    /**
     * 错误！参数列表与getUser()方法一样，存放于同样的cache空间中，
     * 分别访问两个方法后会类型转换报错：类型转换错误！
     */
    @Cacheable("user")
    public Date getNow() {
        log.info("UserService.getNow()");

        return new Date();
    }

}
