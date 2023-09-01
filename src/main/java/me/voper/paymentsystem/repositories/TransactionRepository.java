package me.voper.paymentsystem.repositories;

import me.voper.paymentsystem.models.Transaction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TransactionRepository extends ReactiveCrudRepository<Transaction, Long> {
}
