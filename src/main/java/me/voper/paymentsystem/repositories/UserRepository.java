package me.voper.paymentsystem.repositories;

import me.voper.paymentsystem.models.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {

    Mono<User> findByDocument(String document);

    Mono<User> findByEmail(String email);

}
