package com.dream.tea.provider.converter.user;

import com.dream.tea.provider.common.login.entity.JwtPayload;
import com.dream.tea.provider.vo.req.user.RegisterReqVo;
import com.dream.tea.provider.vo.resp.user.LoginRespVo;
import com.dream.tea.provider.vo.resp.user.RegisterRespVo;
import com.dream.tea.service.model.user.User;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author yongfa
 */
@Mapper
public interface UserVoConverter {

    UserVoConverter INSTANCE = Mappers.getMapper(UserVoConverter.class);

    /**
     * 将请求对象封装成user对象
     *
     * @param reqVo
     * @return
     */
    User registerReqVoToUser(RegisterReqVo reqVo);

    /**
     * 将user对象转换成JwtPayload
     *
     * @param user
     * @return
     */
    @Mapping(source = "id", target = "userId")
    JwtPayload userToJwtPayload(@Param("user") User user);

    /**
     * 将token转换成vo对象
     *
     * @param token
     * @return
     */
    RegisterRespVo tokenToRegisterRespVo(String token);

    /**
     * 将token转换成vo对象
     *
     * @param token
     * @return
     */
    LoginRespVo tokenToLoginRespVo(String token);
}
