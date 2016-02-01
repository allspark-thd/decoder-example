package com.homedepot.decoderExample.service;

import com.homedepot.decoderExample.config.DataSourceConfig;
import credentialdecoder.base64.Base64CredentialDecoder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNull;

public class SecureDbServiceTest {

    @Mock
    private Base64CredentialDecoder base64CredentialDecoder;
    private DataSourceConfig dataSourceConfig;
    
    @Before
    public void setup() throws Exception{
       MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void should_Create_DataSource_With_Valid_Creds() {
//        SecureDbService secureDB = new SecureDbService(base64CredentialDecoder, dataSourceConfig);
//        JSONObject validResponse = new JSONObject("{ password: 'password'}");
//
//        Mockito.when(base64CredentialDecoder.getPassword()).thenReturn(validResponse.toString());
//        Mockito.when(dataSourceConfig.getUrl()).thenReturn("jdbc:mariadb://localhost;AUTO_RECONNECT=TRUE");
//        Mockito.when(dataSourceConfig.getUser()).thenReturn("dummy");
//        Mockito.when(dataSourceConfig.getDriver()).thenReturn("org.mariadb.jdbc.Driver");
//        assertNotNull(secureDB.configureDataSourceBuilder());
//    }

    @Test
    public void should_Return_Null_When_Given_Invalid_Creds() {
        SecureDbService secureDb = new SecureDbService(base64CredentialDecoder, dataSourceConfig);
        assertNull(secureDb.configureDataSourceBuilder());
    }

}

//    @Test
//    public void itShouldFindTwoHostnamesToCheck() {
//
//        checker = new VcapServicesChecker(
//                new JSONObject(willitconnect.service.VcapServicesStrings.valid));
//
//        List<CheckedEntry> shouldBeASingleHostName = checker.getConnectionResults();
//        assertThat(shouldBeASingleHostName, hasSize(2));
//        assertThat(shouldBeASingleHostName.get(0).getEntry(),
//                is(equalTo("us-cdbr-iron-east-02.valid.net:3306")));
//        assertThat(shouldBeASingleHostName.get(1).getEntry(),
//                is(equalTo("us-cdbr-iron-east-02.valid.net:3306")));
//    }
//
//    @Test
//    public void itShouldCheckOnlyValidHostnames() {
//        String json = "{ a: [{'hostname':'a.com:80'},{'hostname':'e.com'}]}";
//        checker = new VcapServicesChecker(new JSONObject(json));
//        assertThat(checker.getConnectionResults().get(0).getLastChecked(),
//                is(not(equalTo(Date.from(Instant.EPOCH)))));
//        assertThat(checker.getConnectionResults().get(1).getLastChecked(),
//                is(equalTo(Date.from(Instant.EPOCH))));
//    }