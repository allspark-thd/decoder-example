package com.homedepot.decoderExample.config;

import credentialdecoder.CredentialDecoder;
import credentialdecoder.base64.Base64CredentialDecoder;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ConfigurationProperties(prefix="creds")
public class Base64DecoderRingConfig {

    private String base64;

    @Bean
    CredentialDecoder newDecoderRing() {
        Base64CredentialDecoder decoderRing = new Base64CredentialDecoder();
        JSONObject credentials = new JSONObject(getBase64());
        decoderRing.init(credentials);
        return decoderRing;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}

