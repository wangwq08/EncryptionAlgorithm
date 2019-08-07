package com.wangwq.encryptionalgorithm.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @Description: MD5算法实现
 * @Author: wangwq
 * @CreateDate: 2019/08/07 18:15
 */
public class MD5Util {
    public static String MD5(String content) throws NoSuchAlgorithmException {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = content.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);

            byte[] md = mdInst.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

//    public static String MD5_2(String content) {
//        String result = null;
//
//        if (content == null) {
//            return null;
//        }
//        Base64.getEncoder() ;
//        BASE64Encoder base64en = new BASE64Encoder();
//
//        try {
//            MessageDigest md5 = MessageDigest.getInstance("MD5");
//            result = Base64.getEncoder(md5.digest(content.getBytes("UTF-8")));
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }
}

