package com.homedepot.decoderExample.service;

import credentialdecoder.CredentialDecoder;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Service;

@Service
public class SecureDbService {

    private JSONObject dataSourceProps;
    private CredentialDecoder decoderRing;
    private Logger log = Logger.getLogger(SecureDbService.class);

    public SecureDbService(CredentialDecoder decoderRing, JSONObject dataSourceProps) {
        this.decoderRing = decoderRing;
        this.dataSourceProps = dataSourceProps;
    }

    public SecureDbService() {

    }

    public DataSourceBuilder configureDataSourceBuilder() {

        DataSourceBuilder dataSourceBuilder = null;
        if (dataSourceProps !=null) {
            try {

                log.info(decoderRing.getPassword());
                log.info(dataSourceProps.getString("driver"));
                log.info(dataSourceProps.getString("user"));
                log.info(dataSourceProps.getString("url"));

                dataSourceBuilder = DataSourceBuilder.create();
                dataSourceBuilder.driverClassName(dataSourceProps.getString("driver"));
                dataSourceBuilder.url(dataSourceProps.getString("user"));
                dataSourceBuilder.username(dataSourceProps.getString("url"));
                dataSourceBuilder.password(decoderRing.getPassword());

            } catch (Exception e) {
                log.error("Unable to create datasource with credentials -" + e.toString());
            }
        }
        return dataSourceBuilder;
    }
}

