package hello.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import hello.bean.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AnotherUserService {

    @Cacheable("user")
    public User getUserByName(String name) {
        log.info("AnotherUserService.getUserByName()-> name: " + name);
        User user = new User(name, 18);

        return user;
    }

    @Cacheable("user")
    public User getAnotherUserByName(String name) {
        log.info("AnotherUserService.getAnotherUserByName()-> name: " + name);
        User user = new User(name, 20);

        return user;
    }

    @Cacheable("user")
    public User getAnotherUser() {
        log.info("AnotherUserService.getAnotherUser()-> name: " + "悟空");
        User user = new User("悟空", 20);

        return user;
    }

}
