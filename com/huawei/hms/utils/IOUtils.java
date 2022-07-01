package com.huawei.hms.utils;

import com.huawei.hms.support.log.HMSLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public final class IOUtils {
  public static void closeQuietly(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (IOException iOException) {
        HMSLog.e("IOUtils", "An exception occurred while closing the 'Closeable' object.");
      }  
  }
  
  public static void closeQuietly(InputStream paramInputStream) {
    closeQuietly(paramInputStream);
  }
  
  public static void closeQuietly(OutputStream paramOutputStream) {
    closeQuietly(paramOutputStream);
  }
  
  public static void closeQuietly(Reader paramReader) {
    closeQuietly(paramReader);
  }
  
  public static void closeQuietly(Writer paramWriter) {
    closeQuietly(paramWriter);
  }
  
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
    return copy(paramInputStream, paramOutputStream, new byte[4096]);
  }
  
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfbyte) throws IOException {
    long l = 0L;
    while (true) {
      int i = paramInputStream.read(paramArrayOfbyte);
      if (-1 != i) {
        paramOutputStream.write(paramArrayOfbyte, 0, i);
        l += i;
        continue;
      } 
      return l;
    } 
  }
  
  public static byte[] toByteArray(InputStream paramInputStream) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, byteArrayOutputStream);
    return byteArrayOutputStream.toByteArray();
  }
  
  public static InputStream toInputStream(byte[] paramArrayOfbyte) throws IOException {
    return new ByteArrayInputStream(paramArrayOfbyte);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\utils\IOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */