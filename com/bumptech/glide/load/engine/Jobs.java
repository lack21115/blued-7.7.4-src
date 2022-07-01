package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;

final class Jobs {
  private final Map<Key, EngineJob<?>> a = new HashMap<Key, EngineJob<?>>();
  
  private final Map<Key, EngineJob<?>> b = new HashMap<Key, EngineJob<?>>();
  
  private Map<Key, EngineJob<?>> a(boolean paramBoolean) {
    return paramBoolean ? this.b : this.a;
  }
  
  EngineJob<?> a(Key paramKey, boolean paramBoolean) {
    return a(paramBoolean).get(paramKey);
  }
  
  void a(Key paramKey, EngineJob<?> paramEngineJob) {
    a(paramEngineJob.a()).put(paramKey, paramEngineJob);
  }
  
  void b(Key paramKey, EngineJob<?> paramEngineJob) {
    Map<Key, EngineJob<?>> map = a(paramEngineJob.a());
    if (paramEngineJob.equals(map.get(paramKey)))
      map.remove(paramKey); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\Jobs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */