package ar.com.hjg.pngj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.logging.Logger;

public final class PngHelperInternal {
  public static final Logger a = Logger.getLogger("ar.com.pngj");
  
  public static String b = "ISO-8859-1";
  
  public static Charset c = Charset.forName(b);
  
  public static String d = "UTF-8";
  
  public static Charset e = Charset.forName(d);
  
  private static ThreadLocal<Boolean> f = new ThreadLocal<Boolean>() {
      protected Boolean a() {
        return Boolean.FALSE;
      }
    };
  
  public static double a(int paramInt) {
    return paramInt / 100000.0D;
  }
  
  static final int a(int paramInt1, int paramInt2, int paramInt3) {
    int i;
    int j;
    int k = paramInt1 + paramInt2 - paramInt3;
    if (k >= paramInt1) {
      i = k - paramInt1;
    } else {
      i = paramInt1 - k;
    } 
    if (k >= paramInt2) {
      j = k - paramInt2;
    } else {
      j = paramInt2 - k;
    } 
    if (k >= paramInt3) {
      k -= paramInt3;
    } else {
      k = paramInt3 - k;
    } 
    return (i <= j && i <= k) ? paramInt1 : ((j <= k) ? paramInt2 : paramInt3);
  }
  
  public static int a(InputStream paramInputStream) {
    try {
      return paramInputStream.read();
    } catch (IOException iOException) {
      throw new PngjInputException("error reading byte", iOException);
    } 
  }
  
  public static int a(byte[] paramArrayOfbyte, int paramInt) {
    return paramArrayOfbyte[paramInt] & 0xFF;
  }
  
  public static InputStream a(File paramFile) {
    try {
      return new FileInputStream(paramFile);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not open ");
      stringBuilder.append(paramFile);
      throw new PngjInputException(stringBuilder.toString(), exception);
    } 
  }
  
  public static void a(int paramInt1, byte[] paramArrayOfbyte, int paramInt2) {
    paramArrayOfbyte[paramInt2] = (byte)(paramInt1 >> 24 & 0xFF);
    paramArrayOfbyte[paramInt2 + 1] = (byte)(paramInt1 >> 16 & 0xFF);
    paramArrayOfbyte[paramInt2 + 2] = (byte)(paramInt1 >> 8 & 0xFF);
    paramArrayOfbyte[paramInt2 + 3] = (byte)(paramInt1 & 0xFF);
  }
  
  public static void a(OutputStream paramOutputStream, int paramInt) {
    byte[] arrayOfByte = new byte[4];
    a(paramInt, arrayOfByte, 0);
    a(paramOutputStream, arrayOfByte);
  }
  
  public static void a(OutputStream paramOutputStream, byte[] paramArrayOfbyte) {
    try {
      paramOutputStream.write(paramArrayOfbyte);
      return;
    } catch (IOException iOException) {
      throw new PngjOutputException(iOException);
    } 
  }
  
  public static void a(OutputStream paramOutputStream, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    try {
      paramOutputStream.write(paramArrayOfbyte, paramInt1, paramInt2);
      return;
    } catch (IOException iOException) {
      throw new PngjOutputException(iOException);
    } 
  }
  
  public static byte[] a() {
    return new byte[] { -119, 80, 78, 71, 13, 10, 26, 10 };
  }
  
  public static int b(InputStream paramInputStream) {
    try {
      int i = paramInputStream.read();
      int j = paramInputStream.read();
      int k = paramInputStream.read();
      int m = paramInputStream.read();
      return (i != -1 && j != -1 && k != -1) ? ((m == -1) ? -1 : (i << 24 | j << 16 | (k << 8) + m)) : -1;
    } catch (IOException iOException) {
      throw new PngjInputException("error reading Int4", iOException);
    } 
  }
  
  public static int b(byte[] paramArrayOfbyte, int paramInt) {
    byte b = paramArrayOfbyte[paramInt];
    return paramArrayOfbyte[paramInt + 1] & 0xFF | (b & 0xFF) << 8;
  }
  
  public static final int c(byte[] paramArrayOfbyte, int paramInt) {
    byte b1 = paramArrayOfbyte[paramInt];
    byte b2 = paramArrayOfbyte[paramInt + 1];
    byte b3 = paramArrayOfbyte[paramInt + 2];
    return paramArrayOfbyte[paramInt + 3] & 0xFF | (b1 & 0xFF) << 24 | (b2 & 0xFF) << 16 | (b3 & 0xFF) << 8;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\PngHelperInternal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */