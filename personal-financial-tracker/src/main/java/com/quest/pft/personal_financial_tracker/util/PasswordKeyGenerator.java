package com.quest.pft.personal_financial_tracker.util;

import lombok.extern.log4j.Log4j2;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.KeyPairGenerator;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Log4j2
public class PasswordKeyGenerator {
    public static void main(String[] args){
        try{
            // Key Pair Generation
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("Ed25519");
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            PrivateKey privateKey = keyPair.getPrivate();
            PublicKey publicKey = keyPair.getPublic();

            String privateKeyStr = Base64.getEncoder().encodeToString(privateKey.getEncoded());
            String publicKeyStr = Base64.getEncoder().encodeToString(publicKey.getEncoded());

            log.info("Private key : {}" , privateKeyStr);
            log.info("Public key : {}" , publicKeyStr);

            // Signature
            Signature signature = Signature.getInstance("Ed25519");

            byte[] prBytes = Base64.getDecoder().decode(privateKeyStr);
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(prBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("Ed25519");
            PrivateKey decodedPrivateKey = keyFactory.generatePrivate(privateKeySpec);

            signature.initSign(decodedPrivateKey);
            signature.update("welcome".getBytes(StandardCharsets.UTF_8));

            String signatureStr  = Base64.getEncoder().encodeToString(signature.sign());

            // Verification
            byte[] signatureBytes = Base64.getDecoder().decode(signatureStr);

            // prepare signature data with public key to verify
            Signature verifySignature  = Signature.getInstance("Ed25519");

            byte[] pbBytes = Base64.getDecoder().decode(publicKeyStr);
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(pbBytes);
            keyFactory = KeyFactory.getInstance("Ed25519");
            PublicKey decodedPublicKey = keyFactory.generatePublic(publicKeySpec);

            verifySignature.initVerify(decodedPublicKey);
            verifySignature.update("welcome".getBytes(StandardCharsets.UTF_8));

            log.info("Verification : {}" , verifySignature.verify(signatureBytes));

        }catch (Exception e){
            log.error("Error in key generation : {}",e.getMessage());
        }
    }
}
