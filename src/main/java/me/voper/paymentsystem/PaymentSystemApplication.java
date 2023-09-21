package me.voper.paymentsystem;

import me.voper.paymentsystem.models.Transaction;
import me.voper.paymentsystem.models.User;
import me.voper.paymentsystem.services.TransactionService;
import me.voper.paymentsystem.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;

@SpringBootApplication
public class PaymentSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner insertData(UserService userService, TransactionService transactionService) {
        return args -> {
            userService.saveAll(List.of(
                    new User("John", "Smith", "johnsmith@gmail.com", "1251251", "password", User.Type.COMMON),
                    new User("Rachel", "Martin", "rachelmartin@gmail.com", "35151", "baracat", User.Type.COMMON),
                    new User("Paul", "Hank", "paulhank@gmail.com", "74373", "leron", User.Type.COMMON),
                    new User("Dan", "Williams", "danwilliams@gmail.com", "02360923", "valles", User.Type.MERCHANT),
                    new User("Franklin", "Wink", "franklinwink@gmail.com", "92105910", "hernandez", User.Type.MERCHANT)
            )).blockLast(Duration.ofSeconds(10L));

            transactionService.save(new Transaction(1L, 2L, BigDecimal.valueOf(100L)))
                    .subscribe();
        };
    }

}
