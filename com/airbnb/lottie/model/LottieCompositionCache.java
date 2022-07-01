package com.airbnb.lottie.model;

import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

public class LottieCompositionCache {
  private static final LottieCompositionCache a = new LottieCompositionCache();
  
  private final LruCache<String, LottieComposition> b = new LruCache(20);
  
  public static LottieCompositionCache a() {
    return a;
  }
  
  public LottieComposition a(String paramString) {
    return (paramString == null) ? null : (LottieComposition)this.b.get(paramString);
  }
  
  public void a(String paramString, LottieComposition paramLottieComposition) {
    if (paramString == null)
      return; 
    this.b.put(paramString, paramLottieComposition);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\model\LottieCompositionCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */