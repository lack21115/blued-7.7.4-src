package com.sina.weibo.sdk.utils;

import java.io.PrintStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AesEncrypt {
  public static String Decrypt(String paramString) {
    try {
      byte[] arrayOfByte = deBase64(paramString);
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(2, generateKey("Stark"));
      try {
        return new String(cipher.doFinal(arrayOfByte), "utf-8");
      } catch (Exception exception) {
        LogUtil.e("Decrypt", exception.getMessage());
        return null;
      } 
    } catch (Exception exception) {
      LogUtil.e("Decrypt", exception.getMessage());
      return null;
    } 
  }
  
  public static String Encrypt(String paramString) {
    try {
      Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
      cipher.init(1, generateKey("Stark"));
      return enBase64(cipher.doFinal(paramString.getBytes("utf-8")));
    } catch (Exception exception) {
      LogUtil.e("Encrypt", exception.getMessage());
      return null;
    } 
  }
  
  private static byte[] deBase64(String paramString) {
    return Base64.decode(paramString.getBytes());
  }
  
  private static String enBase64(byte[] paramArrayOfbyte) {
    return new String(Base64.encode(paramArrayOfbyte));
  }
  
  protected static Key generateKey(String paramString) {
    try {
      paramString = MD5.hexdigest(paramString).substring(2, 18);
      if (paramString == null) {
        LogUtil.v("Decrypt", "Key为空null");
        return null;
      } 
      if (paramString.length() != 16) {
        LogUtil.v("Decrypt", "Key长度不是16位");
        return null;
      } 
      return new SecretKeySpec(paramString.getBytes("utf-8"), "AES");
    } catch (Exception exception) {
      LogUtil.e("generateKey", exception.getMessage());
      return null;
    } 
  }
  
  public static void main(String[] paramArrayOfString) throws Exception {
    String str = Decrypt("u7FFIamNkcuNHMwmAa+VaIrn96etbed19m6VA0iWPoJB8tcFkKkLIgLCScynfkClC9/IRHmXbKa4+ySqhnIjK7P3TgRj0n9KGsLQIVxiT/h2HWmUZj9Bum4EJuSjfSJBVjf/78GWl4zw2EQBOTZyF/9En8JLeLv1YO1tzDwKP3+5S8nnmvV26sjHFAhyRNifFZqUAxMoO1j02c48G/C7vYisBIahWr+vGRmlpxliexdbmR3CKKTSmTmT7jGWVhv5dP5DPcYKEpchtuRnR/rrjI0Nhj3Jcz8gPCegdi+sC+nLij0IjxFf1N5xvyl8CTkbLAF/QjyHq2Y0UU1pOq+oyy88TWp/rym9+vLP5NTT+VObXbduol8UQg0PeRVuTsx4iHHROb4i+Pc5DEVAWsX6Cnn2z7B9gKph0y6JLIddzmUqyeBTzZ3rJEAW/h4JrN9X8nI3HES88cHdQn9YXP7XQrlP6qhy7Z7TKpPda44tWJhR4kZLxflu9pMkCwr2upkDquCgqdgCmeD6vzBd80U0AZphXxFw6GGrFTbkYYbRcmBfrlg5ypEyXoaDujnS15s/6y8Wkmfge/6T6L5t+CHgarkSuNUl0yrZ32R8P9wMDMKs+nzy50pkRugEUFbG8C202SN7DyexqBguwEN4QFqZh2j9vs5kpdfzNYVIxfnuivbriWvNZvRmesdrxnvmaYJH0ssWD5XzJrOeUdzJvqqzjXh8kCw90NuaIMh+5eF2c8MrP81Jh+82kdlmrD0fybdOPap5RRIe/UAIqcOIChbyjO6iDQ6G/ChShzHGwbxxQsQ22tdmOC+tJq4kAqk5Y9uPtyEV7r38nyBsfiyDWMgweIxnCfvDxIe5frXIE+OKziNGeUXuJf6FYc1Kex/ASjdE");
    PrintStream printStream = System.out;
    StringBuilder stringBuilder = new StringBuilder("解密后的字串是：");
    stringBuilder.append(str);
    printStream.println(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sd\\utils\AesEncrypt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */