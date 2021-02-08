package com.dream.tea.provider.service.utils;

import com.dream.tea.service.utils.QrCodeUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author yongfa
 */
public class QrCodeUtilsTest {

    public static void main(String[] args) throws FileNotFoundException {
        QrCodeUtils.generate("http://121.5.62.86/staticSource/android/app-1.0.0.apk","png",new File("E://app-1.0.0.png"));
    }
}
