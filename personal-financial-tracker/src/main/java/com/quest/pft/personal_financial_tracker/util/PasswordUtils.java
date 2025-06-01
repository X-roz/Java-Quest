package com.quest.pft.personal_financial_tracker.util;

import com.quest.pft.personal_financial_tracker.config.PasswordConfig;
import lombok.RequiredArgsConstructor;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

@RequiredArgsConstructor
public class PasswordUtils {

    private final PasswordConfig passwordConfig;

    public String encryptPassword(String password) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature = Signature.getInstance("Ed25519");
        signature.initSign(passwordConfig.getPrivateKey());
        signature.update(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(signature.sign());
    }

}
