package com.dream.tea.service.utils;

import cn.hutool.core.codec.Base64Decoder;
import cn.hutool.core.codec.Base64Encoder;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author yongfa
 */
public class RsaUtil {

    /**
     * 加密算法
     */
    private static final String ALGORITHM = "RSA";

    public static void genKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGen.initialize(1024, new SecureRandom());
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        String publicKeyString = Base64Encoder.encode(publicKey.getEncoded());
        String privateKeyString = Base64Encoder.encode(privateKey.getEncoded());
        System.out.println("publicKey===>" + publicKeyString);
        System.out.println("privateKey===>" + privateKeyString);
    }

    /**
     * 生成私钥
     *
     * @param base64PrivateKey
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String base64PrivateKey) throws Exception {
        byte[] bytes = Base64Decoder.decode(base64PrivateKey);
        return KeyFactory.getInstance(ALGORITHM).generatePrivate(new PKCS8EncodedKeySpec(bytes));
    }

    /**
     * 生成公钥
     *
     * @param base64PublicKey
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(String base64PublicKey) throws Exception {
        byte[] bytes = Base64Decoder.decode(base64PublicKey);
        return KeyFactory.getInstance(ALGORITHM).generatePublic(new X509EncodedKeySpec(bytes));
    }


    public static void main(String[] args) {
        try {
            genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
