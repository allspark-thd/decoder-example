package com.homedepot.decoderExample.config;

import org.junit.Before;

public class VaultDecoderRingConfigTest {
    
    private String goodString = "{ 'credentials': { 'password': 'c3ZjLXBhc3N3b3Jk' } }";

    private String badString = "{}";


    private VaultDecoderRingConfig vaultDecoderRingConfig;

    @Before
    public void setUp() throws Exception {
        vaultDecoderRingConfig = new VaultDecoderRingConfig();
    }

//    @Test
//    public void testNewDecoderRingwithValidInput() throws Exception {
//        vaultDecoderRingConfig
//        CredentialDecoder credentialDecoder = vaultDecoderRingConfig.newDecoderRing();
//        assertThat(credentialDecoder.getPassword(), equalTo("svc-password"));
//    }
//
//    @Test
//    public void testNewDecoderRingwithInValidInput() throws Exception {
//        vaultDecoderRingConfig.setBase64(badString);
//        try {
//            CredentialDecoder credentialDecoder = vaultDecoderRingConfig.newDecoderRing();
//            credentialDecoder.getPassword();
//            fail("expected error to be thrown");
//        } catch (RuntimeException re) {
//            Assert.assertThat(
//                    re.getMessage(),
//                    containsString("not found")
//            );
//        }
//     }
}
