package ru.k2.swaggerdemotinkoff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.HttpLogFormatter;
import ru.k2.swaggerdemotinkoff.support.CustomHttpLogFormatter;

@Configuration
public class AppConfig {

    @Bean
    public HttpLogFormatter httpLogFormatter(){
        return new CustomHttpLogFormatter();
    }
}
