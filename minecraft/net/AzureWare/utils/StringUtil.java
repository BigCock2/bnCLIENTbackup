package net.AzureWare.utils;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class StringUtil {
	
	private static final String KEY = "KillYourMotherIfYouLeakedSomeThing";
	
    public static String encrypt(String content) {
    	/*
    	content = Base64.encodeBase64String(content.getBytes());
    	content = content.replace("A", "��").replace("B", "��").replace("C", "��").replace("D", "��").replace("E", "ɵ").replace("F", "��").replace("G", "��").replace("/", "��").replace("=", "���᳡");
    	content = enCryptAndEncode(content);
    	*/
		return content;    
		
    }
    
    public static String decrypt(String content) {
    	/*
    	try {
			content = deCryptAndDecode(content);
		} catch (Exception e) {
			//e.printStackTrace();
		}
    	content = new String(Base64.decodeBase64(content.replace("��", "A").replace("��", "B").replace("��", "C").replace("��", "D").replace("ɵ", "E").replace("��", "F").replace("��", "G").replace("��", "/").replace("���᳡", "=")));
		*/
		return content;    
    }
    

    public static String enCryptAndEncode(String content) {
        try {
            byte[] sourceBytes = enCryptAndEncode(content, KEY);
            return Base64.encodeBase64URLSafeString(sourceBytes);
        } catch (Exception e) {
            return content;
        }
    }
 
    /**
     * ���ܺ���
     *
     * @param content ���ܵ�����
     * @param strKey  ��Կ
     * @return ���ض������ַ�����
     * @throws Exception
     */
    public static byte[] enCryptAndEncode(String content, String strKey) throws Exception {
 
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128, new SecureRandom(strKey.getBytes()));
 
        SecretKey desKey = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, desKey);
        return cipher.doFinal(content.getBytes("UTF-8"));
    }
 
    public static String deCryptAndDecode(String content) throws Exception {
        byte[] targetBytes = Base64.decodeBase64(content);
        return deCryptAndDecode(targetBytes, KEY);
    }
 
 
    /**
     * ���ܺ���
     *
     * @param src    ���ܹ��Ķ������ַ�����
     * @param strKey ��Կ
     * @return
     * @throws Exception
     */
    public static String deCryptAndDecode(byte[] src, String strKey) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128, new SecureRandom(strKey.getBytes()));
 
        SecretKey desKey = keyGenerator.generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, desKey);
        byte[] cByte = cipher.doFinal(src);
        return new String(cByte, "UTF-8");
    }

}
