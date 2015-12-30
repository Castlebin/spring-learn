package com.heller.hello;

import com.heller.hello.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;

@Slf4j
@SpringBootApplication
public class Application {

    @Bean
    BookingService bookingService() {
        return new BookingService();
    }

    @Bean
    JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        log.info("creating tables...");
        jdbcTemplate.execute("DROP TABLE BOOKINGS IF EXISTS ");
        jdbcTemplate.execute("CREATE TABLE BOOKINGS(" +
                "ID serial, FIRST_NAME VARCHAR(5) NOT NULL)");

        return jdbcTemplate;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        BookingService bookingService = ctx.getBean(BookingService.class);

        bookingService.book("Alice", "Bob", "Carol");
        Assert.isTrue(bookingService.findAllBookings().size() == 3, "First booking should work with no problem");

        try {
            bookingService.book("Chris", "Samuel");
        }
        catch (RuntimeException e) {
            log.info("v--- The following exception is expect because 'Samuel' is too big for the DB ---v");
            log.error(e.getMessage());
        }

        for (String person : bookingService.findAllBookings()) {
            log.info("So far, " + person + " is booked.");
        }

        Assert.isTrue(bookingService.findAllBookings().size()==3, "'Samuel' should have triggered a rollback");

        try {
            bookingService.book("Buddy", null);
        }
        catch (RuntimeException e) {
            log.info("v--- The following exception is expect because null is not valid for the DB ---v");
            log.error(e.getMessage());
        }

        for (String person : bookingService.findAllBookings()) {
            log.info("So far, " + person + " is booked.");
        }
        log.info("You shouldn't see Buddy or null. null violated DB constraints, and Buddy was rolled back in the same TX");
        Assert.isTrue(bookingService.findAllBookings().size() == 3, "'null' should have triggered a rollback");
    }
}
