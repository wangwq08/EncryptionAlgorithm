package com.wangwq.encryptionalgorithm.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * @Description: AES加密算法实现
 * @Author: wangwq
 * @CreateDate: 2019/08/07 19:10
 */
public class AESUtil {

    /**
     * @Description: AES加密
     * @Author: wangwq
     * @CreateDate: 2019/08/07 19:12
     */
    public static String encrypt(String content, String strKey, String ivKey) throws Exception {
        SecretKeySpec skeySpec = getKey(strKey);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(ivKey.getBytes());
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(content.getBytes());
        return bytesToString(encrypted);
    }

    /**
     * @Description: AES解密
     * @Author: wangwq
     * @CreateDate: 2019/08/07 19:18
     */
    public static String decrypt(String content, String strKey, String ivKey) throws Exception {
        SecretKeySpec skeySpec = getKey(strKey);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec iv = new IvParameterSpec(ivKey.getBytes());
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
        byte[] original = cipher.doFinal(stringToBytes(content));
        String originalString = new String(original);
        return originalString;
    }

    /**
     * @Description: 获取密钥
     * @Author: wangwq
     * @CreateDate: 2019/08/07 19:26
     */
    private static SecretKeySpec getKey(String strKey) throws Exception {
        byte[] arrBTmp = strKey.getBytes();
        byte[] arrB = new byte[16];

        for(int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }

        SecretKeySpec skeySpec = new SecretKeySpec(arrB, "AES");
        return skeySpec;
    }

    /**
     * @Description: 字符串转换
     * @Author: wangwq
     * @CreateDate: 2019/08/07 19:31
     */
    private static byte[] stringToBytes(String content) {
        return Base64.getDecoder().decode(content);
    }

    private static String bytesToString(byte[] content) {
        return Base64.getEncoder().encodeToString(content);
    }
}
