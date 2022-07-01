package com.qq.e.comm.net.rr;

import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Arrays;
import javax.crypto.Cipher;

public final class a {
  private static final byte[] a = new byte[] { 91, -62 };
  
  private static Cipher b = null;
  
  private static Cipher c = null;
  
  private static String d = String.format("AES/%s/PKCS7Padding", new Object[] { "ECB" });
  
  private static byte[] e = Base64.decode("4M3PpUC4Vu1uMp+Y0Mxd+vfc6v4ggJAINfgTlH74pis=", 0);
  
  private static Cipher a() throws a {
    // Byte code:
    //   0: ldc com/qq/e/comm/net/rr/a
    //   2: monitorenter
    //   3: getstatic com/qq/e/comm/net/rr/a.b : Ljavax/crypto/Cipher;
    //   6: ifnull -> 16
    //   9: getstatic com/qq/e/comm/net/rr/a.b : Ljavax/crypto/Cipher;
    //   12: astore_0
    //   13: goto -> 47
    //   16: getstatic com/qq/e/comm/net/rr/a.d : Ljava/lang/String;
    //   19: invokestatic getInstance : (Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   22: astore_0
    //   23: aload_0
    //   24: iconst_1
    //   25: new javax/crypto/spec/SecretKeySpec
    //   28: dup
    //   29: getstatic com/qq/e/comm/net/rr/a.e : [B
    //   32: ldc 'AES'
    //   34: invokespecial <init> : ([BLjava/lang/String;)V
    //   37: invokevirtual init : (ILjava/security/Key;)V
    //   40: aload_0
    //   41: putstatic com/qq/e/comm/net/rr/a.b : Ljavax/crypto/Cipher;
    //   44: goto -> 9
    //   47: ldc com/qq/e/comm/net/rr/a
    //   49: monitorexit
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: new com/qq/e/comm/net/rr/a$a
    //   56: dup
    //   57: ldc 'Fail To Init Cipher'
    //   59: aload_0
    //   60: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   63: athrow
    //   64: astore_0
    //   65: ldc com/qq/e/comm/net/rr/a
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    // Exception table:
    //   from	to	target	type
    //   3	9	64	finally
    //   9	13	64	finally
    //   16	44	52	java/lang/Exception
    //   16	44	64	finally
    //   53	64	64	finally
  }
  
  public static byte[] a(byte[] paramArrayOfbyte) throws b {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    try {
      dataOutputStream.write(a);
      dataOutputStream.writeByte(1);
      dataOutputStream.writeByte(2);
      dataOutputStream.write(c(com.qq.e.comm.a.a(paramArrayOfbyte)));
      dataOutputStream.close();
      return byteArrayOutputStream.toByteArray();
    } catch (Exception exception) {
      throw new b("Exception while packaging byte array", exception);
    } 
  }
  
  private static Cipher b() throws a {
    // Byte code:
    //   0: ldc com/qq/e/comm/net/rr/a
    //   2: monitorenter
    //   3: getstatic com/qq/e/comm/net/rr/a.c : Ljavax/crypto/Cipher;
    //   6: ifnull -> 16
    //   9: getstatic com/qq/e/comm/net/rr/a.c : Ljavax/crypto/Cipher;
    //   12: astore_0
    //   13: goto -> 47
    //   16: getstatic com/qq/e/comm/net/rr/a.d : Ljava/lang/String;
    //   19: invokestatic getInstance : (Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   22: astore_0
    //   23: aload_0
    //   24: iconst_2
    //   25: new javax/crypto/spec/SecretKeySpec
    //   28: dup
    //   29: getstatic com/qq/e/comm/net/rr/a.e : [B
    //   32: ldc 'AES'
    //   34: invokespecial <init> : ([BLjava/lang/String;)V
    //   37: invokevirtual init : (ILjava/security/Key;)V
    //   40: aload_0
    //   41: putstatic com/qq/e/comm/net/rr/a.c : Ljavax/crypto/Cipher;
    //   44: goto -> 9
    //   47: ldc com/qq/e/comm/net/rr/a
    //   49: monitorexit
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: new com/qq/e/comm/net/rr/a$a
    //   56: dup
    //   57: ldc 'Fail To Init Cipher'
    //   59: aload_0
    //   60: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   63: athrow
    //   64: astore_0
    //   65: ldc com/qq/e/comm/net/rr/a
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    // Exception table:
    //   from	to	target	type
    //   3	9	64	finally
    //   9	13	64	finally
    //   16	44	52	java/lang/Exception
    //   16	44	64	finally
    //   53	64	64	finally
  }
  
  public static byte[] b(byte[] paramArrayOfbyte) throws b {
    if (paramArrayOfbyte != null && paramArrayOfbyte.length >= 4)
      try {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfbyte));
        byte[] arrayOfByte = new byte[4];
        dataInputStream.read(arrayOfByte);
        if (a[0] == arrayOfByte[0]) {
          byte b1 = a[1];
          byte b2 = arrayOfByte[1];
          if (b1 == b2 && 1 == arrayOfByte[2] && 2 == arrayOfByte[3])
            return com.qq.e.comm.a.b(d(Arrays.copyOfRange(paramArrayOfbyte, 4, paramArrayOfbyte.length))); 
        } 
        throw new b("S2SS Package Magic/Version FormatError", null);
      } catch (Exception exception) {
        throw new b("Exception while packaging byte array", exception);
      }  
    throw new b("S2SS Package FormatError", null);
  }
  
  private static byte[] c(byte[] paramArrayOfbyte) throws a {
    Cipher cipher = a();
    try {
      return cipher.doFinal(paramArrayOfbyte);
    } catch (Exception exception) {
      throw new a("Exception While encrypt byte array", exception);
    } 
  }
  
  private static byte[] d(byte[] paramArrayOfbyte) throws a {
    Cipher cipher = b();
    try {
      return cipher.doFinal(paramArrayOfbyte);
    } catch (Exception exception) {
      throw new a("Exception While dencrypt byte array", exception);
    } 
  }
  
  static final class a extends Exception {
    public a(String param1String, Throwable param1Throwable) {
      super(param1String, param1Throwable);
    }
  }
  
  public static final class b extends Exception {
    public b(String param1String, Throwable param1Throwable) {
      super(param1String, param1Throwable);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\net\rr\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */