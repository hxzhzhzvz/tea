package com.dream.tea.provider.converter.user;

import com.dream.tea.provider.common.login.entity.JwtPayload;
import com.dream.tea.provider.vo.req.user.RegisterReqVo;
import com.dream.tea.provider.vo.resp.user.LoginRespVo;
import com.dream.tea.provider.vo.resp.user.RegisterRespVo;
import com.dream.tea.service.model.user.User;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-06T22:14:21+0800",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class UserVoConverterImpl implements UserVoConverter {

    @Override
    public User registerReqVoToUser(RegisterReqVo reqVo) {
        if ( reqVo == null ) {
            return null;
        }

        User user = new User();

        user.setAccount( reqVo.getAccount() );
        user.setPassword( reqVo.getPassword() );
        user.setBirthday( reqVo.getBirthday() );
        user.setSex( reqVo.getSex() );
        user.setNickName( reqVo.getNickName() );
        user.setHearUrl( reqVo.getHearUrl() );

        return user;
    }

    @Override
    public JwtPayload userToJwtPayload(User user) {
        if ( user == null ) {
            return null;
        }

        JwtPayload jwtPayload = new JwtPayload();

        jwtPayload.setUserId( user.getId() );

        return jwtPayload;
    }

    @Override
    public RegisterRespVo tokenToRegisterRespVo(String token) {
        if ( token == null ) {
            return null;
        }

        RegisterRespVo registerRespVo = new RegisterRespVo();

        registerRespVo.setToken( token );

        return registerRespVo;
    }

    @Override
    public LoginRespVo tokenToLoginRespVo(String token) {
        if ( token == null ) {
            return null;
        }

        LoginRespVo loginRespVo = new LoginRespVo();

        loginRespVo.setToken( token );

        return loginRespVo;
    }
}
