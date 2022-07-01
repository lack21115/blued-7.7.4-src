package com.google.android.gms.common.util;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

@Deprecated
public final class IOUtils {
  public static void closeQuietly(@Nullable ParcelFileDescriptor paramParcelFileDescriptor) {
    if (paramParcelFileDescriptor != null)
      try {
        paramParcelFileDescriptor.close();
        return;
      } catch (IOException iOException) {
        return;
      }  
  }
  
  public static void closeQuietly(@Nullable Closeable paramCloseable) {
    if (paramCloseable != null)
      try {
        paramCloseable.close();
        return;
      } catch (IOException iOException) {
        return;
      }  
  }
  
  @Deprecated
  public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
    return zza(paramInputStream, paramOutputStream, false);
  }
  
  @Deprecated
  public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean, int paramInt) throws IOException {
    null = new byte[paramInt];
    long l = 0L;
    try {
      while (true) {
        int i = paramInputStream.read(null, 0, paramInt);
        if (i != -1) {
          l += i;
          paramOutputStream.write(null, 0, i);
          continue;
        } 
        return l;
      } 
    } finally {
      if (paramBoolean) {
        closeQuietly(paramInputStream);
        closeQuietly(paramOutputStream);
      } 
    } 
  }
  
  public static boolean isGzipByteBuffer(byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte.length > 1) {
      byte b = paramArrayOfbyte[0];
      if (((paramArrayOfbyte[1] & 0xFF) << 8 | b & 0xFF) == 35615)
        return true; 
    } 
    return false;
  }
  
  @Deprecated
  public static byte[] readInputStreamFully(InputStream paramInputStream) throws IOException {
    return readInputStreamFully(paramInputStream, true);
  }
  
  @Deprecated
  public static byte[] readInputStreamFully(InputStream paramInputStream, boolean paramBoolean) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    zza(paramInputStream, byteArrayOutputStream, paramBoolean);
    return byteArrayOutputStream.toByteArray();
  }
  
  @Deprecated
  public static byte[] toByteArray(InputStream paramInputStream) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    Preconditions.checkNotNull(paramInputStream);
    Preconditions.checkNotNull(byteArrayOutputStream);
    byte[] arrayOfByte = new byte[4096];
    while (true) {
      int i = paramInputStream.read(arrayOfByte);
      if (i != -1) {
        byteArrayOutputStream.write(arrayOfByte, 0, i);
        continue;
      } 
      return byteArrayOutputStream.toByteArray();
    } 
  }
  
  @Deprecated
  private static long zza(InputStream paramInputStream, OutputStream paramOutputStream, boolean paramBoolean) throws IOException {
    return copyStream(paramInputStream, paramOutputStream, paramBoolean, 1024);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\IOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */