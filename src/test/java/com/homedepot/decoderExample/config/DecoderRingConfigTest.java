package com.homedepot.decoderExample.config;

import credentialdecoder.CredentialDecoder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.fail;


public class DecoderRingConfigTest {

    private String goodString = "{ 'credentials': { 'password': 'c3ZjLXBhc3N3b3Jk' } }";

    private String badString = "{}";


    private Base64DecoderRingConfig base64DecoderRingConfig;

    @Before
    public void setUp() throws Exception {
        base64DecoderRingConfig = new Base64DecoderRingConfig();
    }

    @Test
    public void testNewDecoderRingwithValidInput() throws Exception {
        base64DecoderRingConfig.setBase64(goodString);
        CredentialDecoder credentialDecoder = base64DecoderRingConfig.newDecoderRing();
        assertThat(credentialDecoder.getPassword(), equalTo("svc-password"));
    }

    @Test
    public void testNewDecoderRingwithInValidInput() throws Exception {
        base64DecoderRingConfig.setBase64(badString);
        try {
            CredentialDecoder credentialDecoder = base64DecoderRingConfig.newDecoderRing();
            credentialDecoder.getPassword();
            fail("expected error to be thrown");
        } catch (RuntimeException re) {
            Assert.assertThat(
                    re.getMessage(),
                    containsString("not found")
            );
        }
    }
}