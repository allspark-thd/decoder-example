package com.homedepot.decoderExample.service;

public class VcapServicesStrings {
    public static String valid ="{'valid': [{'credentials': " +
            "{" +
            "'app_id':'app'," +
            "'user_id': 'user'," +
            "'vault_url': 'localhost:8085'," +
            "'login_path': '/v1/auth/app-id/login'," +
            "'creds_path': ' /v1/secret/dbidtest'," +
            "}," +
            "{'database': " +
            "{" +
            "'url':'jdbc:mariadb://localhost;AUTO_RECONNECT=TRUE'," +
            "'user': 'dummy'," +
            "'driver': 'org.mariadb.jdbc.Driver'," +
            "}," +
            "'label': 'valid'," +
            "'name': 'hellodb'," +
            "'plan': 'spark'," +
            "'tags': ['Data Stores','Data Store','relational','mysql']" +
            "}]}";
    public static String empty = "{}";
}

