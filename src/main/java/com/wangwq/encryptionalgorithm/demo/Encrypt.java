package com.wangwq.encryptionalgorithm.demo;

import com.wangwq.encryptionalgorithm.utils.AESUtil;
import com.wangwq.encryptionalgorithm.utils.DESUtil;
import com.wangwq.encryptionalgorithm.utils.MD5Util;

public class Encrypt {
    public static void main(String[] args) throws Exception {
        //md
        System.out.println("-------------md5-------------");
        String password = "1";
        System.out.println(password + "   "   + MD5Util.MD5(password));

        //AES
        System.out.println("-------------AES-------------");
        String key = "test";
        String iv = "ckm1552362258051";
        String content = "wangwq";

        System.out.println(content);
        System.out.println(AESUtil.encrypt(content, key, iv));
        System.out.println(AESUtil.decrypt(AESUtil.encrypt(content, key, iv), key,iv));

        //DES
        System.out.println("-------------DES-------------");
        String deskey = "test1234";
        System.out.println(content);
        System.out.println(DESUtil.EncryptAsDoNet(content, deskey));
        System.out.println(DESUtil.DecryptDoNet(DESUtil.EncryptAsDoNet(content, deskey), deskey));
    }
}
