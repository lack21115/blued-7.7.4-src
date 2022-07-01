package com.huawei.hms.framework.common;

import android.database.Cursor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class IoUtils {
  private static final int BUFF_SIZE = 4096;
  
  private static final int MAX_SIZE = 16777216;
  
  private static final String TAG = "IoUtils";
  
  public static void close(Cursor paramCursor) {
    if (paramCursor != null)
      paramCursor.close(); 
  }
  
  public static void closeSecure(Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (IOException iOException) {
        Logger.w("IOUtil", "closeSecure IOException", iOException);
        return;
      }  
    Logger.w("IOUtil", "closeable is null");
  }
  
  public static void closeSecure(InputStream paramInputStream) {
    closeSecure(paramInputStream);
  }
  
  public static void closeSecure(OutputStream paramOutputStream) {
    closeSecure(paramOutputStream);
  }
  
  public static void closeSecure(Reader paramReader) {
    closeSecure(paramReader);
  }
  
  public static void closeSecure(Writer paramWriter) {
    closeSecure(paramWriter);
  }
  
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream) {
    byte[] arrayOfByte = new byte[4096];
    long l = 0L;
    while (true) {
      int i = paramInputStream.read(arrayOfByte);
      if (-1 != i) {
        if (l <= 16777216L) {
          paramOutputStream.write(arrayOfByte, 0, i);
          l += i;
          continue;
        } 
        throw new IOException("input data too large for byte.");
      } 
      return l;
    } 
  }
  
  public static byte[] toByteArray(InputStream paramInputStream) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, byteArrayOutputStream);
    return byteArrayOutputStream.toByteArray();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\IoUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */