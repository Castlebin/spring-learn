package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
@EnableCaching
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

/**
 * 说明：
 * 使用Spring的@Cache*相关的注解时，尤其是@Cacheable注解，要知道在cache中对应的key为 cache空间名称+方法参数列表的值组合，
 * 所以即使是不同的方法调用，如果对应的方法列表参数值完全一样，那么就会命中，因此可能会产生错误的命中！
 * 注意！
 *
 * Spring的cache可以使用在各个层级上，甚至包括Controller层，功能强大
 */