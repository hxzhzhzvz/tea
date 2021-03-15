package com.dream.tea.service.service.cdkey.impl;

import cn.hutool.json.JSONUtil;
import com.dream.tea.service.dto.req.exchange.BatchCreateCdKeyReqDto;
import com.dream.tea.service.dto.resp.exchange.BatchCreateCdKeyRespDto;
import com.dream.tea.service.mapper.order.CdKeyDetailMapper;
import com.dream.tea.service.mapper.order.CdKeyMapper;
import com.dream.tea.service.model.order.CdKey;
import com.dream.tea.service.model.order.CdKeyDetail;
import com.dream.tea.service.service.cdkey.CdKeyService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yongfa
 */
@Service
public class CdKeyServiceImpl implements CdKeyService {

    private static final int A = 65;

    private static final int Z = 90;

    private static String GENERATE_STR;

    private static final int LEN = 10;

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = A; i <= Z; i++) {
            sb.append((char) (i));
        }
        GENERATE_STR = sb.toString();
    }

    @Resource
    private CdKeyMapper cdKeyMapper;

    @Resource
    private CdKeyDetailMapper cdKeyDetailMapper;

    @Override
    @Transactional(transactionManager = "libraryTransactionManager", rollbackFor = Exception.class)
    public BatchCreateCdKeyRespDto doCreateCdKey(BatchCreateCdKeyReqDto reqDto) {
        // CdKey的生成规则，现在简单处理。直接使用
        CdKey cdKey = new CdKey();
        cdKey.setBizType(reqDto.getBizType());
        cdKey.setExpireTime(reqDto.getExpireTime());
        cdKey.setQuantity(reqDto.getQuantity());
        cdKey.setExtendObj(JSONUtil.toJsonStr(reqDto.getExtendObj()));
        cdKey.setStatus(1);
        cdKeyMapper.insert(cdKey);

        List<String> cdCodeList = generateCdCode(reqDto.getQuantity());
        List<CdKeyDetail> cdKeyDetailList = new ArrayList<>(cdCodeList.size());
        for (String cdCode : cdCodeList) {
            CdKeyDetail cdKeyDetail = new CdKeyDetail();
            cdKeyDetail.setCdKeyId(cdKey.getId());
            cdKeyDetail.setCode(cdCode);
            cdKeyDetail.setExchangeStatus(0);
            cdKeyDetail.setStatus(1);
            cdKeyDetailList.add(cdKeyDetail);
        }
        cdKeyDetailMapper.batchInsert(cdKeyDetailList);
        BatchCreateCdKeyRespDto respDto = new BatchCreateCdKeyRespDto();
        respDto.setCdCodeList(cdCodeList);
        return respDto;
    }

    private List<String> generateCdCode(int count) {
        List<String> cdCodeList = new ArrayList<>(count);
        while (count-- > 0) {
            cdCodeList.add(RandomStringUtils.random(LEN, GENERATE_STR));
        }
        return cdCodeList;
    }

    public static void main(String[] args) {
        System.out.println((int) 'A');
        System.out.println((int) 'Z');
    }
}
