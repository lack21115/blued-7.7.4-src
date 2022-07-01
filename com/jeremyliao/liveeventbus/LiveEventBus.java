package com.jeremyliao.liveeventbus;

import com.jeremyliao.liveeventbus.core.Config;
import com.jeremyliao.liveeventbus.core.LiveEventBusCore;
import com.jeremyliao.liveeventbus.core.Observable;

public final class LiveEventBus {
  public static Config config() {
    return LiveEventBusCore.get().config();
  }
  
  public static Observable<Object> get(String paramString) {
    return get(paramString, Object.class);
  }
  
  public static <T> Observable<T> get(String paramString, Class<T> paramClass) {
    return LiveEventBusCore.get().with(paramString, paramClass);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jeremyliao\liveeventbus\LiveEventBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */