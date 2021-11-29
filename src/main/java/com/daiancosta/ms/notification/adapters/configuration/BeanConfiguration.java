package com.daiancosta.ms.notification.adapters.configuration;

import com.daiancosta.ms.notification.MsNotificationApplication;
import com.daiancosta.ms.notification.application.ports.EmailRepositoryPort;
import com.daiancosta.ms.notification.application.ports.SendEmailServicePort;
import com.daiancosta.ms.notification.application.services.EmailServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = MsNotificationApplication.class)
public class BeanConfiguration {

    @Bean
    EmailServiceImpl emailServiceImpl(EmailRepositoryPort repository, SendEmailServicePort sendEmailServicePort) {
        return new EmailServiceImpl(repository, sendEmailServicePort);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}