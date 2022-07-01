package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import java.io.File;
import java.io.IOException;

public class DiskLruCacheWrapper implements DiskCache {
  private final SafeKeyGenerator a;
  
  private final File b;
  
  private final long c;
  
  private final DiskCacheWriteLocker d = new DiskCacheWriteLocker();
  
  private DiskLruCache e;
  
  @Deprecated
  protected DiskLruCacheWrapper(File paramFile, long paramLong) {
    this.b = paramFile;
    this.c = paramLong;
    this.a = new SafeKeyGenerator();
  }
  
  public static DiskCache a(File paramFile, long paramLong) {
    return new DiskLruCacheWrapper(paramFile, paramLong);
  }
  
  private DiskLruCache b() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield e : Lcom/bumptech/glide/disklrucache/DiskLruCache;
    //   6: ifnonnull -> 26
    //   9: aload_0
    //   10: aload_0
    //   11: getfield b : Ljava/io/File;
    //   14: iconst_1
    //   15: iconst_1
    //   16: aload_0
    //   17: getfield c : J
    //   20: invokestatic a : (Ljava/io/File;IIJ)Lcom/bumptech/glide/disklrucache/DiskLruCache;
    //   23: putfield e : Lcom/bumptech/glide/disklrucache/DiskLruCache;
    //   26: aload_0
    //   27: getfield e : Lcom/bumptech/glide/disklrucache/DiskLruCache;
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
    //   26	31	35	finally
  }
  
  private void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aconst_null
    //   4: putfield e : Lcom/bumptech/glide/disklrucache/DiskLruCache;
    //   7: aload_0
    //   8: monitorexit
    //   9: return
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	10	finally
  }
  
  public File a(Key paramKey) {
    String str = this.a.a(paramKey);
    if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Get: Obtained: ");
      stringBuilder.append(str);
      stringBuilder.append(" for for Key: ");
      stringBuilder.append(paramKey);
      Log.v("DiskLruCacheWrapper", stringBuilder.toString());
    } 
    try {
      DiskLruCache.Value value = b().a(str);
      if (value != null)
        return value.a(0); 
    } catch (IOException iOException) {
      if (Log.isLoggable("DiskLruCacheWrapper", 5))
        Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", iOException); 
    } 
    return null;
  }
  
  public void a() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial b : ()Lcom/bumptech/glide/disklrucache/DiskLruCache;
    //   6: invokevirtual a : ()V
    //   9: aload_0
    //   10: invokespecial c : ()V
    //   13: goto -> 42
    //   16: astore_1
    //   17: goto -> 45
    //   20: astore_1
    //   21: ldc 'DiskLruCacheWrapper'
    //   23: iconst_5
    //   24: invokestatic isLoggable : (Ljava/lang/String;I)Z
    //   27: ifeq -> 9
    //   30: ldc 'DiskLruCacheWrapper'
    //   32: ldc 'Unable to clear disk cache or disk cache cleared externally'
    //   34: aload_1
    //   35: invokestatic w : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   38: pop
    //   39: goto -> 9
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: aload_0
    //   46: invokespecial c : ()V
    //   49: aload_1
    //   50: athrow
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	20	java/io/IOException
    //   2	9	16	finally
    //   9	13	51	finally
    //   21	39	16	finally
    //   45	51	51	finally
  }
  
  public void a(Key paramKey, DiskCache.Writer paramWriter) {
    String str = this.a.a(paramKey);
    this.d.a(str);
    try {
      if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Put: Obtained: ");
        stringBuilder.append(str);
        stringBuilder.append(" for for Key: ");
        stringBuilder.append(paramKey);
        Log.v("DiskLruCacheWrapper", stringBuilder.toString());
      } 
      try {
        DiskLruCache diskLruCache = b();
        DiskLruCache.Value value = diskLruCache.a(str);
        if (value != null)
          return; 
        DiskLruCache.Editor editor = diskLruCache.b(str);
        if (editor != null) {
          try {
            if (paramWriter.a(editor.a(0)))
              editor.a(); 
          } finally {
            editor.c();
          } 
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Had two simultaneous puts for: ");
          stringBuilder.append(str);
          throw new IllegalStateException(stringBuilder.toString());
        } 
      } catch (IOException iOException) {
        if (Log.isLoggable("DiskLruCacheWrapper", 5))
          Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", iOException); 
      } 
      return;
    } finally {
      this.d.b(str);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\cache\DiskLruCacheWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */