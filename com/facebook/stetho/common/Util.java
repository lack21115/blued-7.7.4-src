package com.facebook.stetho.common;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Util {
  public static void awaitUninterruptibly(CountDownLatch paramCountDownLatch) {
    while (true) {
      try {
        paramCountDownLatch.await();
        return;
      } catch (InterruptedException interruptedException) {}
    } 
  }
  
  public static void close(Closeable paramCloseable, boolean paramBoolean) throws IOException {
    if (paramCloseable != null) {
      if (paramBoolean)
        try {
          paramCloseable.close();
          return;
        } catch (IOException iOException) {
          LogUtil.e(iOException, "Hiding IOException because another is pending");
          return;
        }  
      iOException.close();
    } 
  }
  
  public static void copy(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfbyte) throws IOException {
    while (true) {
      int i = paramInputStream.read(paramArrayOfbyte);
      if (i != -1) {
        paramOutputStream.write(paramArrayOfbyte, 0, i);
        continue;
      } 
      break;
    } 
  }
  
  public static <T> T getUninterruptibly(Future<T> paramFuture) throws ExecutionException {
    while (true) {
      try {
        return paramFuture.get();
      } catch (InterruptedException interruptedException) {}
    } 
  }
  
  public static <T> T getUninterruptibly(Future<T> paramFuture, long paramLong, TimeUnit paramTimeUnit) throws TimeoutException, ExecutionException {
    paramLong = paramTimeUnit.toMillis(paramLong);
    long l = System.currentTimeMillis();
    while (true) {
      try {
        return paramFuture.get(paramLong, TimeUnit.MILLISECONDS);
      } catch (InterruptedException interruptedException) {
        paramLong -= System.currentTimeMillis() - l;
      } 
    } 
  }
  
  public static void joinUninterruptibly(Thread paramThread) {
    while (true) {
      try {
        paramThread.join();
        return;
      } catch (InterruptedException interruptedException) {}
    } 
  }
  
  public static String readAsUTF8(InputStream paramInputStream) throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, byteArrayOutputStream, new byte[1024]);
    return byteArrayOutputStream.toString("UTF-8");
  }
  
  public static void sleepUninterruptibly(long paramLong) {
    long l = System.currentTimeMillis();
    while (true) {
      try {
        Thread.sleep(paramLong);
        return;
      } catch (InterruptedException interruptedException) {
        long l1 = paramLong - System.currentTimeMillis() - l;
        paramLong = l1;
        if (l1 <= 0L)
          return; 
      } 
    } 
  }
  
  public static void throwIf(boolean paramBoolean) {
    if (!paramBoolean)
      return; 
    throw new IllegalStateException();
  }
  
  public static void throwIfNot(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException();
  }
  
  public static void throwIfNot(boolean paramBoolean, String paramString, Object... paramVarArgs) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(String.format(paramString, paramVarArgs));
  }
  
  public static void throwIfNotNull(Object paramObject) {
    if (paramObject == null)
      return; 
    throw new IllegalStateException();
  }
  
  public static <T> T throwIfNull(T paramT) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException();
  }
  
  public static <T1, T2> void throwIfNull(T1 paramT1, T2 paramT2) {
    throwIfNull(paramT1);
    throwIfNull(paramT2);
  }
  
  public static <T1, T2, T3> void throwIfNull(T1 paramT1, T2 paramT2, T3 paramT3) {
    throwIfNull(paramT1);
    throwIfNull(paramT2);
    throwIfNull(paramT3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\common\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */