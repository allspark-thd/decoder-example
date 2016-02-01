package com.homedepot.decoderExample.service;

import com.homedepot.decoderExample.config.DataSourceConfig;
import credentialdecoder.base64.Base64CredentialDecoder;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class SecureDbServiceBase64Test {

    @Mock
    private Base64CredentialDecoder base64CredentialDecoder;

    @Mock
    private DataSourceConfig dataSourceConfig;

    @InjectMocks
    SecureDbService secureDbBase64 = new SecureDbService(base64CredentialDecoder);
    
    @Before
    public void setup() throws Exception{

        MockitoAnnotations.initMocks(this);
        JSONObject validResponse = new JSONObject("{ password: 'password'}");

        Mockito.when(base64CredentialDecoder.getPassword()).thenReturn(validResponse.toString());
        Mockito.when(dataSourceConfig.getUrl()).thenReturn("jdbc:mariadb://localhost;AUTO_RECONNECT=TRUE");
        Mockito.when(dataSourceConfig.getUser()).thenReturn("dummy");
        Mockito.when(dataSourceConfig.getDriver()).thenReturn("org.mariadb.jdbc.Driver");
    }

    @Test
    public void should_Create_DataSourceBuilder_With_Valid_Creds() {
        DataSourceBuilder dataBuilder = secureDbBase64.configureDataSourceBuilder();
        assertNotNull(dataBuilder);
    }

    @Test
    public void should_Return_Null_When_Given_Invalid_Creds() {
        SecureDbService secureDbNull = new SecureDbService(base64CredentialDecoder);
        assertNull(secureDbNull.configureDataSourceBuilder());
    }

}

