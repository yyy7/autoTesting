package com.katey2658.web.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 11456 on 2016/11/23.
 */
public class StringEncryption {

    /**
     * 输入一个字符串然后返回一个加密后的字符串
     * @param str
     * @return
     */
    public static String getEncryptionString(String str){
        try {
            //获取一个MD5转换器
            MessageDigest messageDigest =MessageDigest.getInstance("MD5");

            byte[] strByteArray=str.getBytes();

            //转换得到的字节数组
            messageDigest.update(strByteArray);

            //转换并返回字节数据
            strByteArray=messageDigest.digest();

            //字节数组转换为字符串返回
            return byteArrayToString(strByteArray);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    //将字节数组转换成字符串返回
    private static String byteArrayToString(byte[] byteArray) {
        //初始化一个字节数组用来存放每一个16进制数组
        char[] hexDigits={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        //原因：两个字节为一个十六进制数
        char[] charArray=new char[byteArray.length*2];

        //遍历字节数组，通过位运算,分别取低4位和高4位转换成字符
        int index=0;
        for (byte b:byteArray){
            charArray[index++]=hexDigits[b>>>4&0xf];
            charArray[index++]=hexDigits[b&0xf];
        }

        //将字符数组作为字符串返回
        return new String(charArray);
    }

}
