package com.homedepot.decoderExample.service;

import com.homedepot.decoderExample.config.DataSourceConfig;
import credentialdecoder.CredentialDecoder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Service;

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

        DataSourceBuilder dataSourceBuilder = null;
        if (dataSourceConfig !=null) {
            try {

                log.info(decoderRing.getPassword());
                log.info(dataSourceConfig.getDriver());
                log.info(dataSourceConfig.getUser());
                log.info(dataSourceConfig.getUrl());

                dataSourceBuilder = DataSourceBuilder.create();
                dataSourceBuilder.driverClassName(dataSourceConfig.getDriver());
                dataSourceBuilder.url(dataSourceConfig.getUser());
                dataSourceBuilder.username(dataSourceConfig.getUrl());
                dataSourceBuilder.password(decoderRing.getPassword());

            } catch (Exception e) {
                log.error("Unable to create datasource with credentials -" + e.toString());
            }
        }
        return dataSourceBuilder;
    }
}

