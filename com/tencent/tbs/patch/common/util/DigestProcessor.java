package com.tencent.tbs.patch.common.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestProcessor {
  private static DigestProcessor b;
  
  private Processor a;
  
  public DigestProcessor(Processor paramProcessor) {
    this.a = paramProcessor;
  }
  
  public static DigestProcessor getInstance() {
    if (b == null)
      b = new DigestProcessor(new a()); 
    return b;
  }
  
  public String calcDigest(File paramFile) {
    // Byte code:
    //   0: new java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial <init> : (Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: aload_0
    //   12: getfield a : Lcom/tencent/tbs/patch/common/util/DigestProcessor$Processor;
    //   15: aload_2
    //   16: invokeinterface encrypt : (Ljava/io/InputStream;)Ljava/lang/String;
    //   21: astore_3
    //   22: aload_2
    //   23: invokevirtual close : ()V
    //   26: aload_3
    //   27: areturn
    //   28: astore_1
    //   29: aload_1
    //   30: invokevirtual printStackTrace : ()V
    //   33: aload_3
    //   34: areturn
    //   35: astore_3
    //   36: goto -> 48
    //   39: astore_2
    //   40: aconst_null
    //   41: astore_1
    //   42: goto -> 72
    //   45: astore_3
    //   46: aconst_null
    //   47: astore_2
    //   48: aload_2
    //   49: astore_1
    //   50: aload_3
    //   51: invokevirtual printStackTrace : ()V
    //   54: aload_2
    //   55: ifnull -> 69
    //   58: aload_2
    //   59: invokevirtual close : ()V
    //   62: aconst_null
    //   63: areturn
    //   64: astore_1
    //   65: aload_1
    //   66: invokevirtual printStackTrace : ()V
    //   69: aconst_null
    //   70: areturn
    //   71: astore_2
    //   72: aload_1
    //   73: ifnull -> 88
    //   76: aload_1
    //   77: invokevirtual close : ()V
    //   80: goto -> 88
    //   83: astore_1
    //   84: aload_1
    //   85: invokevirtual printStackTrace : ()V
    //   88: aload_2
    //   89: athrow
    // Exception table:
    //   from	to	target	type
    //   0	9	45	java/io/FileNotFoundException
    //   0	9	39	finally
    //   11	22	35	java/io/FileNotFoundException
    //   11	22	71	finally
    //   22	26	28	java/io/IOException
    //   50	54	71	finally
    //   58	62	64	java/io/IOException
    //   76	80	83	java/io/IOException
  }
  
  public String calcDigest(String paramString) {
    return calcDigest(new File(paramString));
  }
  
  public String calcDigest(byte[] paramArrayOfbyte) {
    return this.a.encrypt(paramArrayOfbyte);
  }
  
  public static interface Processor {
    String encrypt(InputStream param1InputStream);
    
    String encrypt(byte[] param1ArrayOfbyte);
  }
  
  private static class a implements Processor {
    private a() {}
    
    public static String a(byte[] param1ArrayOfbyte) {
      if (param1ArrayOfbyte == null || param1ArrayOfbyte.length <= 0)
        return null; 
      StringBuffer stringBuffer = new StringBuffer(param1ArrayOfbyte.length * 2);
      for (int i = 0; i < param1ArrayOfbyte.length; i++) {
        if ((param1ArrayOfbyte[i] & 0xFF) < 16)
          stringBuffer.append("0"); 
        stringBuffer.append(Long.toString((param1ArrayOfbyte[i] & 0xFF), 16));
      } 
      return stringBuffer.toString();
    }
    
    public String encrypt(InputStream param1InputStream) {
      try {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] arrayOfByte = new byte[8192];
        while (true) {
          int i = param1InputStream.read(arrayOfByte);
          if (i != -1) {
            messageDigest.update(arrayOfByte, 0, i);
            continue;
          } 
          return a(messageDigest.digest());
        } 
      } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      
      } catch (IOException iOException) {}
      iOException.printStackTrace();
      return "";
    }
    
    public String encrypt(byte[] param1ArrayOfbyte) {
      try {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(param1ArrayOfbyte);
        return a(messageDigest.digest());
      } catch (Exception exception) {
        exception.printStackTrace();
        return null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\commo\\util\DigestProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */