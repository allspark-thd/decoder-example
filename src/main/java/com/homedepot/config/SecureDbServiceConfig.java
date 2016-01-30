package com.homedepot.config;

import com.homedepot.service.SecureDbService;
import credentialdecoder.CredentialDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SecureDbServiceConfig {

    @Autowired
    CredentialDecoder decoderRing;

    @Bean
    SecureDbService secureDbDemo() {
        return new SecureDbService(decoderRing);
    }
}
