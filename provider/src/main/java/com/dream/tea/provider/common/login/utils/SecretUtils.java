package com.dream.tea.provider.common.login.utils;


import cn.hutool.json.JSONUtil;
import com.dream.tea.provider.common.login.config.JwtAuthConfig;
import com.dream.tea.provider.common.login.entity.JwtPayload;
import com.dream.tea.service.utils.RsaUtil;
import io.jsonwebtoken.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author yongfa
 */
@Component
public class SecretUtils {

    private PrivateKey privateKey;

    private PublicKey publicKey;

    @Resource
    private JwtAuthConfig jwtAuthConfig;

    @PostConstruct
    private void init() throws Exception {
        if (!StringUtils.isEmpty(jwtAuthConfig.getPrivateKey())) {
            privateKey = RsaUtil.getPrivateKey(jwtAuthConfig.getPrivateKey());
        }
        if (!StringUtils.isEmpty(jwtAuthConfig.getPublicKey())) {
            publicKey = RsaUtil.getPublicKey(jwtAuthConfig.getPublicKey());
        }
    }


    /**
     * 创建token
     *
     * @param jwtPayload 用户的信息的载荷
     * @return 加密后的字符串
     */
    public String createToken(JwtPayload jwtPayload) {
        String subjectStr = JSONUtil.toJsonStr(jwtPayload);
        JwtBuilder builder = Jwts.builder()
                .setSubject(subjectStr)
                .signWith(SignatureAlgorithm.RS256, privateKey);

        return builder.compact();
    }

    /**
     * 解析token
     *
     * @param userTokenStr 加密字符串
     * @return 解析出来的用户信息载荷对象
     */
    public JwtPayload parseToken(String userTokenStr) {
        String subjectStr;
        try {
            subjectStr = Jwts.parser()
                   // .setAllowedClockSkewSeconds(jwtAuthConfig.getSkewSeconds())
                    .setSigningKey(publicKey)
                    .parseClaimsJws(userTokenStr).getBody().getSubject();
        } catch (ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException | MalformedJwtException e) {
            return null;
        }
        return JSONUtil.toBean(subjectStr, JwtPayload.class);
    }
}
