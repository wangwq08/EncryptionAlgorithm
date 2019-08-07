package com.wangwq.encryptionalgorithm.demo;

import com.wangwq.encryptionalgorithm.utils.MD5Util;

import java.security.NoSuchAlgorithmException;

public class Encrypt {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        //md
        String password = "1";
        System.out.println(password + "   "   + MD5Util.MD5(password));

        //AES
        String key = "test";
        String iv = "test";
        String content = "wangwq";
    }
}
