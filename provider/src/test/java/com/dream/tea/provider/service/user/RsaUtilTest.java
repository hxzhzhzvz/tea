package com.dream.tea.provider.service.user;

import com.dream.tea.service.utils.RsaUtil;

import java.security.NoSuchAlgorithmException;

/**
 * @author yongfa
 */
public class RsaUtilTest {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        RsaUtil.genKeyPair();
    }
}
