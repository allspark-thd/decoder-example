package com.homedepot.decoderExample.controller;

import com.homedepot.decoderExample.config.DataSourceConfig;
import com.homedepot.decoderExample.service.SecureDbService;
import credentialdecoder.CredentialDecoder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SecureDbControllerTest {

    private String app_id = "app";
    private String user_id = "user_id";
    private String vault_url = "vault_url";
    private String login_path = "login_path";
    private String creds_path = "creds_path";

    @Mock
    DataSourceConfig dataSourceConfig;

    @Mock
    CredentialDecoder credentialDecoder;

    @InjectMocks
    SecureDbService secureDbService = new SecureDbService(credentialDecoder);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.when(credentialDecoder.getPassword()).thenReturn("maria_root");
        Mockito.when(dataSourceConfig.getUrl()).thenReturn("jdbc:mysql://127.0.0.1");
        Mockito.when(dataSourceConfig.getUser()).thenReturn("root");
        Mockito.when(dataSourceConfig.getDriver()).thenReturn("org.mariadb.jdbc.Driver");
    }

    @Test
    public void testConnectWithValidSecureDbService() throws Exception {
        SecureDbController secureDbController = new SecureDbController(secureDbService);
        assertThat(secureDbController.connect(), equalTo("I can connect to the db"));
    }

}