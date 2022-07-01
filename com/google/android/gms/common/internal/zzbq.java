package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

public final class zzbq {
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
  
  public static Object checkNotNull(Object paramObject) {
    if (paramObject != null)
      return paramObject; 
    throw new NullPointerException("null reference");
  }
  
  public static Object checkNotNull(Object paramObject1, Object paramObject2) {
    if (paramObject1 != null)
      return paramObject1; 
    throw new NullPointerException(String.valueOf(paramObject2));
  }
  
  public static void checkState(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException();
  }
  
  public static void zza(Handler paramHandler) {
    if (Looper.myLooper() == paramHandler.getLooper())
      return; 
    throw new IllegalStateException("Must be called on the handler thread");
  }
  
  public static void zza(boolean paramBoolean, Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(String.valueOf(paramObject));
  }
  
  public static void zza(boolean paramBoolean, String paramString, Object... paramVarArgs) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(String.format(paramString, paramVarArgs));
  }
  
  public static String zzgv(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      return paramString; 
    throw new IllegalArgumentException("Given String is empty or null");
  }
  
  public static String zzh(String paramString, Object paramObject) {
    if (!TextUtils.isEmpty(paramString))
      return paramString; 
    throw new IllegalArgumentException(String.valueOf(paramObject));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzbq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */