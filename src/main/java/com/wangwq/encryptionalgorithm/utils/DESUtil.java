package com.wangwq.encryptionalgorithm.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * @Description: DES加密实现
 * @Author: wangwq
 * @CreateDate: 2019/08/07 19:59
 */
public class DESUtil {
    /**
     * @Description: DES加密
     * @Author: wangwq
     * @CreateDate: 2019/08/07 20:01
     */
    public static String EncryptAsDoNet(String content, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        byte[] encryptbyte = cipher.doFinal(content.getBytes());

        return new String(encryptbyte);
    }

    /**
     * @Description: DES解密
     * @Author: wangwq
     * @CreateDate: 2019/08/07 20:22
     */
    public static String DecryptDoNet(String content, String key) throws Exception {
        byte[] bytesrc = Base64.decode(content);
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));

        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        byte[] retByte = cipher.doFinal(bytesrc);

        return new String(retByte);
    }
}
