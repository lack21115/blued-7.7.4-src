package com.huawei.hianalytics.ab.bc.kl;

import com.huawei.hianalytics.ab.bc.ef.ab;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.Deflater;

public final class de {
  public static String ab(File paramFile) {
    IOException iOException1;
    FileNotFoundException fileNotFoundException = null;
    ab ab = null;
    byte[] arrayOfByte = null;
    try {
    
    } catch (FileNotFoundException null) {
      return "";
    } catch (IOException iOException) {
    
    } finally {
      arrayOfByte = null;
      iOException1 = iOException2;
      byte[] arrayOfByte1 = arrayOfByte;
      ab((Closeable)iOException1);
    } 
    IOException iOException2 = iOException1;
    ab.fg("hmsSdk", "getInfoFromFile(): stream.read or new string exception");
    ab((Closeable)iOException1);
    return "";
  }
  
  public static String ab(InputStream paramInputStream) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      byte[] arrayOfByte = new byte[1024];
      while (true) {
        int i = paramInputStream.read(arrayOfByte);
        if (i != -1) {
          byteArrayOutputStream.write(arrayOfByte, 0, i);
          continue;
        } 
        return byteArrayOutputStream.toString("UTF-8");
      } 
    } finally {
      ab(byteArrayOutputStream);
    } 
  }
  
  public static void ab(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (IOException iOException) {
        ab.fg("hmsSdk", "closeQuietly(): Exception when closing the closeable!");
      }  
  }
  
  public static void ab(File paramFile, String paramString) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #4
    //   3: aconst_null
    //   4: astore_2
    //   5: aconst_null
    //   6: astore_3
    //   7: new java/io/FileOutputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial <init> : (Ljava/io/File;)V
    //   15: astore_0
    //   16: aload_0
    //   17: aload_1
    //   18: ldc 'UTF-8'
    //   20: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   23: invokevirtual write : ([B)V
    //   26: aload_0
    //   27: invokevirtual flush : ()V
    //   30: goto -> 67
    //   33: astore_1
    //   34: aload_0
    //   35: astore_2
    //   36: aload_1
    //   37: astore_0
    //   38: goto -> 73
    //   41: goto -> 47
    //   44: goto -> 61
    //   47: ldc 'saveInfoToFile(): io exc from write info to file!'
    //   49: astore_1
    //   50: aload_0
    //   51: astore_2
    //   52: ldc 'hmsSdk'
    //   54: aload_1
    //   55: invokestatic fg : (Ljava/lang/String;Ljava/lang/String;)V
    //   58: goto -> 67
    //   61: ldc 'saveInfoToFile(): No files need to be read'
    //   63: astore_1
    //   64: goto -> 50
    //   67: aload_0
    //   68: invokestatic ab : (Ljava/io/Closeable;)V
    //   71: return
    //   72: astore_0
    //   73: aload_2
    //   74: invokestatic ab : (Ljava/io/Closeable;)V
    //   77: aload_0
    //   78: athrow
    //   79: astore_0
    //   80: aload #4
    //   82: astore_0
    //   83: goto -> 61
    //   86: astore_0
    //   87: aload_3
    //   88: astore_0
    //   89: goto -> 47
    //   92: astore_1
    //   93: goto -> 44
    //   96: astore_1
    //   97: goto -> 41
    // Exception table:
    //   from	to	target	type
    //   7	16	79	java/io/FileNotFoundException
    //   7	16	86	java/io/IOException
    //   7	16	72	finally
    //   16	30	92	java/io/FileNotFoundException
    //   16	30	96	java/io/IOException
    //   16	30	33	finally
    //   52	58	72	finally
  }
  
  private static void ab(OutputStream paramOutputStream) {
    if (paramOutputStream != null)
      try {
        paramOutputStream.close();
        return;
      } catch (IOException iOException) {
        ab.fg("hmsSdk", "closeStream(): Exception: close OutputStream error!");
      }  
  }
  
  public static void ab(HttpURLConnection paramHttpURLConnection) {
    try {
      paramHttpURLConnection.getInputStream().close();
    } catch (Exception exception) {
      ab.fg("hmsSdk", "closeQuietly(): Exception when connHttp.getInputStream()!,There may be no network, or no INTERNET permission");
    } 
    paramHttpURLConnection.disconnect();
    ab.ab("hmsSdk", " connHttp disconnect");
  }
  
  public static byte[] ab(byte[] paramArrayOfbyte) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    Deflater deflater = new Deflater();
    deflater.setInput(paramArrayOfbyte);
    deflater.finish();
    paramArrayOfbyte = new byte[1024];
    while (!deflater.finished())
      byteArrayOutputStream.write(paramArrayOfbyte, 0, deflater.deflate(paramArrayOfbyte)); 
    paramArrayOfbyte = byteArrayOutputStream.toByteArray();
    deflater.end();
    ab(byteArrayOutputStream);
    return paramArrayOfbyte;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\kl\de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */