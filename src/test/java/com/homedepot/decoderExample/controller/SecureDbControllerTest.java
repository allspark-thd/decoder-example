package com.homedepot.decoderExample.controller;

import com.homedepot.decoderExample.config.DataSourceConfig;
import com.homedepot.decoderExample.service.SecureDbService;
import credentialdecoder.CredentialDecoder;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.IntegrationTest;

@IntegrationTest
public class SecureDbControllerTest {

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
        Mockito.when(dataSourceConfig.getUrl()).thenReturn("jdbc:mariadb://127.0.0.1:3306/mysql");
        Mockito.when(dataSourceConfig.getUser()).thenReturn("root");
        Mockito.when(dataSourceConfig.getDriver()).thenReturn("org.mariadb.jdbc.Driver");
    }
/*
    @Test
    public void testConnectWithValidSecureDbService() throws Exception {
        SecureDbController secureDbController = new SecureDbController(secureDbService);
        assertThat(secureDbController.connect(), equalTo("I can connect to the db"));
    }
*/
}