package com.homedepot.decoderExample.service;

import com.homedepot.decoderExample.config.DataSourceConfig;
import credentialdecoder.vault.VaultCredentialDecoder;
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

public class SecureDbServiceTest {

    @Mock
    private VaultCredentialDecoder vaultCredentialDecoder;

    @Mock
    private DataSourceConfig dataSourceConfig;

    @InjectMocks
    SecureDbService secureDbBaseVault = new SecureDbService(vaultCredentialDecoder);
    
    @Before
    public void setup() throws Exception{

        MockitoAnnotations.initMocks(this);
        JSONObject validResponse = new JSONObject("{ password: 'password'}");

        Mockito.when(vaultCredentialDecoder.getPassword()).thenReturn(validResponse.toString());
        Mockito.when(dataSourceConfig.getUrl()).thenReturn("jdbc:mariadb://localhost:3306/mysql");
        Mockito.when(dataSourceConfig.getUser()).thenReturn("dummy");
        Mockito.when(dataSourceConfig.getDriver()).thenReturn("org.mariadb.jdbc.Driver");
    }

    @Test
    public void should_Create_DataSourceBuilder_With_Valid_Creds() {
        DataSourceBuilder dataBuilder = secureDbBaseVault.configureDataSourceBuilder();
        assertNotNull(dataBuilder);
    }

    @Test
    public void should_Return_Null_When_Given_Invalid_Creds() {
        SecureDbService secureDbNull = new SecureDbService(vaultCredentialDecoder);
        assertNull(secureDbNull.configureDataSourceBuilder());
    }

}

