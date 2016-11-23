package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import hello.bean.User;
import hello.service.AnotherUserService;
import hello.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AnotherUserService anotherUserService;

    @RequestMapping("/getUserByName")
    public User getUserByName(String name) {
        log.info("UserController.getUserByName()-> name: " + name);

        return userService.getUserByName(name);
    }

    @RequestMapping("/getAnotherUserByName")
    public User getAnotherUserByName(String name) {
        log.info("UserController.getAnotherUserByName()-> name: " + name);

        return userService.getAnotherUserByName(name);
    }

    @Cacheable("user")
    @RequestMapping("/getUserByNameControllerCache")
    public User getUserByNameControllerCache(String name) {
        log.info("UserController.getUserByNameControllerCache()-> name: " + name);

        return anotherUserService.getAnotherUserByName(name);
    }

    @Cacheable("user")
    @RequestMapping("/getAnotherUserByNameControllerCache")
    public User getAnotherUserByNameControllerCache(String name) {
        log.info("UserController.getAnotherUserByNameControllerCache()-> name: " + name);

        return anotherUserService.getAnotherUserByName(name);
    }

    @RequestMapping("/getUser")
    public User getUser() {
        log.info("UserController.getUser()");

        return userService.getUser();
    }

    @RequestMapping("/getAnotherUser")
    public User getAnotherUser() {
        log.info("UserController.getAnotherUser()");

        return anotherUserService.getAnotherUser();
    }

    @RequestMapping("/getNow")
    public Date getNow() {
        log.info("UserController.getNow()");

        return userService.getNow();
    }

}
