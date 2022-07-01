package com.blued.android.core.image;

import android.text.TextUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.Log;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class ImageFileLoader {
  private static HashMap<Integer, LinkedHashSet<ImageFileWrapper>> a = new HashMap<Integer, LinkedHashSet<ImageFileWrapper>>();
  
  private static HashMap<Integer, LinkedHashSet<ImageFileWrapper>> b = new HashMap<Integer, LinkedHashSet<ImageFileWrapper>>();
  
  protected static int a(Object paramObject, String paramString) {
    return Util.a(paramString, Util.a(paramObject, Util.a(1.0F)));
  }
  
  public static ImageFileWrapper a(IRequestHost paramIRequestHost) {
    return new ImageFileWrapper(paramIRequestHost, (RequestBuilder)((RequestBuilder)((RequestBuilder)ImageLoader.a((IRequestHost)null).d().b(DiskCacheStrategy.c)).e(-2147483648)).d(true));
  }
  
  protected static HashMap<Integer, LinkedHashSet<ImageFileWrapper>> a(boolean paramBoolean) {
    return paramBoolean ? a : b;
  }
  
  public static void a(IRequestHost paramIRequestHost, Object paramObject, String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      int i = a(paramObject, paramString);
      if (ImageLoader.a()) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cancel @");
        stringBuilder.append(Thread.currentThread().getName());
        stringBuilder.append(", tag=");
        stringBuilder.append(paramObject);
        stringBuilder.append(", url=");
        stringBuilder.append(paramString);
        Log.c("IMAGE", stringBuilder.toString());
      } 
      a(a, i);
      a(b, i);
    } 
  }
  
  private static void a(HashMap<Integer, LinkedHashSet<ImageFileWrapper>> paramHashMap, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   7: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast java/util/HashSet
    //   13: astore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: iload_1
    //   17: invokestatic a : (I)V
    //   20: aload_2
    //   21: ifnull -> 57
    //   24: aload_2
    //   25: invokevirtual iterator : ()Ljava/util/Iterator;
    //   28: astore_0
    //   29: aload_0
    //   30: invokeinterface hasNext : ()Z
    //   35: ifeq -> 53
    //   38: aload_0
    //   39: invokeinterface next : ()Ljava/lang/Object;
    //   44: checkcast com/blued/android/core/image/ImageFileWrapper
    //   47: invokevirtual b : ()V
    //   50: goto -> 29
    //   53: aload_2
    //   54: invokevirtual clear : ()V
    //   57: return
    //   58: astore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_2
    //   62: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	58	finally
    //   59	61	58	finally
  }
  
  public static interface OnLoadFileListener {
    void onUIFinish(File param1File, Exception param1Exception);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\ImageFileLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */