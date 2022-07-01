package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.util.zzc;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class Preconditions {
  private Preconditions() {
    throw new AssertionError("Uninstantiable");
  }
  
  public static void checkArgument(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException();
  }
  
  public static void checkArgument(boolean paramBoolean, Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static void checkArgument(boolean paramBoolean, String paramString, Object... paramVarArgs) {
    if (paramBoolean)
      return; 
    throw new IllegalArgumentException(String.format(paramString, paramVarArgs));
  }
  
  public static void checkHandlerThread(Handler paramHandler) {
    Looper looper = Looper.myLooper();
    if (looper != paramHandler.getLooper()) {
      String str2;
      if (looper != null) {
        str2 = looper.getThread().getName();
      } else {
        str2 = "null current looper";
      } 
      String str1 = paramHandler.getLooper().getThread().getName();
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str1).length() + 36 + String.valueOf(str2).length());
      stringBuilder.append("Must be called on ");
      stringBuilder.append(str1);
      stringBuilder.append(" thread, but got ");
      stringBuilder.append(str2);
      stringBuilder.append(".");
      throw new IllegalStateException(stringBuilder.toString());
    } 
  }
  
  public static void checkHandlerThread(Handler paramHandler, String paramString) {
    if (Looper.myLooper() == paramHandler.getLooper())
      return; 
    throw new IllegalStateException(paramString);
  }
  
  public static void checkMainThread(String paramString) {
    if (zzc.zza())
      return; 
    throw new IllegalStateException(paramString);
  }
  
  public static String checkNotEmpty(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      return paramString; 
    throw new IllegalArgumentException("Given String is empty or null");
  }
  
  public static String checkNotEmpty(String paramString, Object paramObject) {
    if (!TextUtils.isEmpty(paramString))
      return paramString; 
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static void checkNotMainThread() {
    checkNotMainThread("Must not be called on the main application thread");
  }
  
  public static void checkNotMainThread(String paramString) {
    if (!zzc.zza())
      return; 
    throw new IllegalStateException(paramString);
  }
  
  @EnsuresNonNull({"#1"})
  public static <T> T checkNotNull(T paramT) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException("null reference");
  }
  
  @EnsuresNonNull({"#1"})
  public static <T> T checkNotNull(T paramT, Object paramObject) {
    if (paramT != null)
      return paramT; 
    throw new NullPointerException(String.valueOf(paramObject));
  }
  
  public static int checkNotZero(int paramInt) {
    if (paramInt != 0)
      return paramInt; 
    throw new IllegalArgumentException("Given Integer is zero");
  }
  
  public static int checkNotZero(int paramInt, Object paramObject) {
    if (paramInt != 0)
      return paramInt; 
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static long checkNotZero(long paramLong) {
    if (paramLong != 0L)
      return paramLong; 
    throw new IllegalArgumentException("Given Long is zero");
  }
  
  public static long checkNotZero(long paramLong, Object paramObject) {
    if (paramLong != 0L)
      return paramLong; 
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
  
  public static void checkState(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException();
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(String.valueOf(paramObject));
  }
  
  public static void checkState(boolean paramBoolean, String paramString, Object... paramVarArgs) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(String.format(paramString, paramVarArgs));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */