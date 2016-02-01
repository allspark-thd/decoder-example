package com.homedepot.decoderExample.config;

import credentialdecoder.CredentialDecoder;
import credentialdecoder.vault.VaultCredentialDecoder;
import org.json.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
@ConfigurationProperties(prefix="creds")
public class VaultDecoderRingConfig {

    private String app_id, user_id, vault_url, login_path, creds_path;

    @Bean
    CredentialDecoder newDecoderRing() {

        JSONObject credentials = new JSONObject();

        credentials.put("app_id", this.getApp_id());
        credentials.put("user_id", this.getUser_id());
        credentials.put("vault_url", this.getVault_url());
        credentials.put("login_path", this.getLogin_path());
        credentials.put("creds_path", this.getCreds_path());

        VaultCredentialDecoder decoderRing = new VaultCredentialDecoder(credentials);
        return decoderRing;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getVault_url() {
        return vault_url;
    }

    public void setVault_url(String vault_url) {
        this.vault_url = vault_url;
    }

    public String getLogin_path() {
        return login_path;
    }

    public void setLogin_path(String login_path) {
        this.login_path = login_path;
    }

    public String getCreds_path() {
        return creds_path;
    }

    public void setCreds_path(String creds_path) {
        this.creds_path = creds_path;
    }
}

