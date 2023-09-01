package me.voper.paymentsystem.models;

import lombok.*;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.annotation.Id;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "users")
public class User {

    @Id
    private Long id;

    private BigDecimal balance = BigDecimal.valueOf(1000L);

    @Column("first_name")
    private @NonNull String firstName;

    @Column("last_name")
    private @NonNull String lastName;

    private @NonNull String email;

    private @NonNull String document;

    private @NonNull String password;

    @Column("user_type")
    private @NonNull Type userType;

    public enum Type {
        COMMON, MERCHANT
    }

    @ReadingConverter
    public enum TypeReadConverter implements Converter<String, Type> {

        INSTANCE;

        @Override
        public Type convert(String source) {
            return Type.valueOf(source.toUpperCase());
        }
    }

    @WritingConverter
    public enum TypeWriteConverter implements Converter<Type, String> {

        INSTANCE;

        @Override
        public String convert(Type source) {
            return source.name();
        }
    }

}
