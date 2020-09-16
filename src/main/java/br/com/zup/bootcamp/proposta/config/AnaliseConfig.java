package br.com.zup.bootcamp.proposta.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnaliseConfig {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.NONE;
    }
}
