package me.voper.paymentsystem.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "transactions")
public class Transaction {

    @Id
    private Long id;

    @Column("sender")
    private @NonNull Long sender;

    @Column("receiver")
    private @NonNull Long receiver;

    private @NonNull BigDecimal amount;

}
