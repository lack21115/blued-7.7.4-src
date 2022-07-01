package com.bumptech.glide.request;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class RequestOptions extends BaseRequestOptions<RequestOptions> {
  private static RequestOptions a;
  
  private static RequestOptions b;
  
  public static RequestOptions c(Key paramKey) {
    return (new RequestOptions()).b(paramKey);
  }
  
  public static RequestOptions c(DiskCacheStrategy paramDiskCacheStrategy) {
    return (new RequestOptions()).b(paramDiskCacheStrategy);
  }
  
  public static RequestOptions c(Class<?> paramClass) {
    return (new RequestOptions()).b(paramClass);
  }
  
  public static RequestOptions g(boolean paramBoolean) {
    if (paramBoolean) {
      if (a == null)
        a = (new RequestOptions()).d(true).g(); 
      return a;
    } 
    if (b == null)
      b = (new RequestOptions()).d(false).g(); 
    return b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\RequestOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */