package com.homedepot.decoderExample.config;

import com.homedepot.decoderExample.service.SecureDbService;
import credentialdecoder.CredentialDecoder;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan

public class SecureDbServiceConfig {

    @Autowired
    CredentialDecoder decoderRing;

    @Autowired
    JSONObject dataSourceProps;

    @Bean
    SecureDbService secureDbDemo() {
        return new SecureDbService(decoderRing, dataSourceProps);
    }
}
