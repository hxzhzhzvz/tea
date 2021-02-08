package com.dream.tea.service.utils;

import cn.hutool.extra.qrcode.QrCodeUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author yongfa
 */
public class QrCodeUtils {

    /**
     * 生成输出二维码
     *
     * @param content    二维码携带的内容
     * @param imageType  二维码文件的类型
     * @param targetFile 二维码的输出路径
     * @throws FileNotFoundException 异常
     */
    public static void generate(String content, String imageType, File targetFile) throws FileNotFoundException {
        FileOutputStream out = new FileOutputStream(targetFile);
        QrCodeUtil.generate(content, 120, 120, imageType, out);
    }
}
