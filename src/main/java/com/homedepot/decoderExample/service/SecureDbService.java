package com.homedepot.decoderExample.service;

import com.homedepot.decoderExample.config.DataSourceConfig;
import credentialdecoder.CredentialDecoder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Service;

@EnableAutoConfiguration
@Service
public class SecureDbService {

    @Autowired
    private DataSourceConfig dataSourceConfig;

    private CredentialDecoder decoderRing;
    private Logger log = Logger.getLogger(SecureDbService.class);

    public SecureDbService(CredentialDecoder decoderRing) {
        this.decoderRing = decoderRing;
    }

    public SecureDbService() {

    }

    public DataSourceBuilder configureDataSourceBuilder() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        try {
            dataSourceBuilder.driverClassName(dataSourceConfig.getDriver());
            dataSourceBuilder.url(dataSourceConfig.getUrl());
            dataSourceBuilder.username(dataSourceConfig.getUser());
            dataSourceBuilder.password(decoderRing.getPassword());
        }
        catch(Exception e )
        {
            throw new RuntimeException(
                    String.format("Unable to configure datasource"));
        }
        return dataSourceBuilder;
    }
}

