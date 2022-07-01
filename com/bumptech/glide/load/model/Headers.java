package com.bumptech.glide.load.model;

import java.util.Collections;
import java.util.Map;

public interface Headers {
  @Deprecated
  public static final Headers a = new Headers() {
      public Map<String, String> a() {
        return Collections.emptyMap();
      }
    };
  
  public static final Headers b = (new LazyHeaders.Builder()).a();
  
  Map<String, String> a();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\model\Headers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */