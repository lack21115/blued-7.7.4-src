package com.blued.android.core.image;

import com.blued.android.core.net.IRequestHost;
import java.util.concurrent.ConcurrentHashMap;

public class ImageLoaderHostManager {
  private static final ConcurrentHashMap<IRequestHost, Object> a = new ConcurrentHashMap<IRequestHost, Object>();
  
  public static Object a(IRequestHost paramIRequestHost) {
    return (paramIRequestHost == null) ? null : a.get(paramIRequestHost);
  }
  
  public static void a(IRequestHost paramIRequestHost, Object paramObject) {
    if (paramIRequestHost != null) {
      if (paramObject == null)
        return; 
      a.put(paramIRequestHost, paramObject);
    } 
  }
  
  public static void b(IRequestHost paramIRequestHost) {
    if (paramIRequestHost == null)
      return; 
    a.remove(paramIRequestHost);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\ImageLoaderHostManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */