package com.soft.blued.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build;
import android.util.LruCache;
import com.blued.android.core.image.GlideApp;
import com.blued.android.framework.utils.Logger;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MemoryBitmapCache {
  public static final String a = MemoryBitmapCache.class.getSimpleName();
  
  private static volatile MemoryBitmapCache b;
  
  private LruCache<String, BitmapWrapper> c = new LruCache<String, BitmapWrapper>(this, (int)Runtime.getRuntime().maxMemory() / 10) {
      protected int a(String param1String, MemoryBitmapCache.BitmapWrapper param1BitmapWrapper) {
        return param1BitmapWrapper.b;
      }
    };
  
  private int a(Bitmap paramBitmap) {
    return (paramBitmap == null) ? 0 : ((Build.VERSION.SDK_INT >= 19) ? paramBitmap.getAllocationByteCount() : paramBitmap.getByteCount());
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat1, float paramFloat2) {
    float f2 = paramBitmap.getWidth();
    float f3 = paramBitmap.getHeight();
    if (f2 <= paramFloat1 && f3 <= paramFloat2)
      return paramBitmap; 
    Matrix matrix = new Matrix();
    float f1 = 1.0F;
    if (paramFloat1 < f2) {
      paramFloat1 /= f2;
    } else {
      paramFloat1 = 1.0F;
    } 
    if (paramFloat2 < f3)
      f1 = paramFloat2 / f3; 
    paramFloat1 = Math.min(paramFloat1, f1);
    matrix.postScale(paramFloat1, paramFloat1);
    return Bitmap.createBitmap(paramBitmap, 0, 0, (int)f2, (int)f3, matrix, true);
  }
  
  public static MemoryBitmapCache a() {
    // Byte code:
    //   0: getstatic com/soft/blued/utils/MemoryBitmapCache.b : Lcom/soft/blued/utils/MemoryBitmapCache;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/utils/MemoryBitmapCache
    //   8: monitorenter
    //   9: getstatic com/soft/blued/utils/MemoryBitmapCache.b : Lcom/soft/blued/utils/MemoryBitmapCache;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/utils/MemoryBitmapCache
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/utils/MemoryBitmapCache.b : Lcom/soft/blued/utils/MemoryBitmapCache;
    //   25: ldc com/soft/blued/utils/MemoryBitmapCache
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/utils/MemoryBitmapCache
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/utils/MemoryBitmapCache.b : Lcom/soft/blued/utils/MemoryBitmapCache;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private String a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      String str = Integer.toHexString(paramArrayOfbyte[i] & 0xFF);
      if (str.length() == 1)
        stringBuilder.append('0'); 
      stringBuilder.append(str);
    } 
    return stringBuilder.toString();
  }
  
  private String c(String paramString) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      messageDigest.update(paramString.getBytes());
      return a(messageDigest.digest());
    } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
      return String.valueOf(paramString.hashCode());
    } 
  }
  
  public Bitmap a(String paramString) {
    BitmapWrapper bitmapWrapper = (BitmapWrapper)this.c.get(c(paramString));
    return (bitmapWrapper == null) ? null : bitmapWrapper.a;
  }
  
  public void a(Context paramContext, String paramString) {
    if (a(paramString) != null)
      return; 
    GlideApp.b(paramContext).a().a(DiskCacheStrategy.b).d(-1).a(paramString).a((Target)new SimpleTarget<Bitmap>(this, paramString) {
          public void a(Bitmap param1Bitmap, Transition<? super Bitmap> param1Transition) {
            try {
              return;
            } finally {
              param1Bitmap = null;
            } 
          }
        });
  }
  
  public void a(String paramString, Bitmap paramBitmap) {
    String str = a;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("put : ");
    stringBuilder2.append(paramString);
    Logger.c(str, new Object[] { stringBuilder2.toString() });
    if (a(paramString) == null) {
      BitmapWrapper bitmapWrapper = new BitmapWrapper();
      bitmapWrapper.b = a(paramBitmap);
      bitmapWrapper.a = paramBitmap;
      this.c.put(c(paramString), bitmapWrapper);
    } 
    paramString = a;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("currentSize : ");
    stringBuilder1.append(this.c.size());
    stringBuilder1.append("   maxSize : ");
    stringBuilder1.append(this.c.maxSize());
    Logger.c(paramString, new Object[] { stringBuilder1.toString() });
  }
  
  public BitmapWrapper b(String paramString) {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("remove : ");
    stringBuilder.append(paramString);
    Logger.c(str, new Object[] { stringBuilder.toString() });
    return (BitmapWrapper)this.c.remove(c(paramString));
  }
  
  public static class BitmapWrapper {
    public Bitmap a;
    
    public int b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\MemoryBitmapCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */