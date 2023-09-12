package me.voper.paymentsystem.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import me.voper.paymentsystem.models.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.util.List;

@Configuration
@EnableR2dbcRepositories
public class R2dbcConfig extends AbstractR2dbcConfiguration {

    @Override
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get("r2dbc:h2:mem///testdb");
    }

    @Override
    protected List<Object> getCustomConverters() {
        return List.of(User.TypeReadConverter.INSTANCE, User.TypeWriteConverter.INSTANCE);
    }

}
