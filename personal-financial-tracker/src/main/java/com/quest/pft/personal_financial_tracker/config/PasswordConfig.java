package com.quest.pft.personal_financial_tracker.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Log4j2
@Configuration
public class PasswordConfig {

    @Value("${password.privateKeyStr}")
    private String privateKeyStr;

    @Value("${password.publicKeyStr}")
    private String publicKeyStr;

    @Getter
    private PrivateKey privateKey;
    @Getter
    private PublicKey  publicKey;


    @PostConstruct
    private void init(){
        decodePrivateKey();
        decodePublicKey();
    }

    private void decodePrivateKey(){
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(this.privateKeyStr);

            PKCS8EncodedKeySpec privateKeySpecs = new PKCS8EncodedKeySpec(decodedBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("Ed25519");

            this.privateKey = keyFactory.generatePrivate(privateKeySpecs);
        } catch (Exception e){
            log.error("Error in Private Key Conversion : {}",e.getMessage());
        }
    }

    private void decodePublicKey(){
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(this.publicKeyStr);

            X509EncodedKeySpec publicKeySpecs = new X509EncodedKeySpec(decodedBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("Ed25519");

            this.publicKey = keyFactory.generatePublic(publicKeySpecs);
        } catch (Exception e){
            log.error("Error in Public Key Conversion : {}",e.getMessage());
        }
    }
}
