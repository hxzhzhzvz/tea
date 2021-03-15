package com.dream.tea.service.mapper.library;

import com.dream.tea.service.model.library.SingleVideo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yongfa
 */
@Repository
public interface SingleVideoMapper {

    /**
     * 获取小于等于maxId的limitSize个取值
     *
     * @param maxId     最大的自增id
     * @param limitSize 返回的条数
     * @return 查询结果
     */
    List<SingleVideo> getByMaxIdAndLimitSize(@Param("maxId") Long maxId, @Param("limitSize") Integer limitSize);
}