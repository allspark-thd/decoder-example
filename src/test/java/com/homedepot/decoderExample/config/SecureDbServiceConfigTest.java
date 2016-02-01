package com.homedepot.decoderExample.config;

import com.homedepot.decoderExample.service.SecureDbService;
import org.junit.Test;

import static org.junit.Assert.assertNull;

public class SecureDbServiceConfigTest {

    /**
     * WARNING!
     * This test assumes you don't have VCAP_SERVICES set in your
     * environment when running it!
     */
    @Test
    public void it_handles_null_vcapServices() {
        SecureDbServiceConfig config = new SecureDbServiceConfig();
        SecureDbService dbDemo = config.secureDbDemo();
        assertNull(dbDemo.configureDataSourceBuilder());
    }
}