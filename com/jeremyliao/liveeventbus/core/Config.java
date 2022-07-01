package com.jeremyliao.liveeventbus.core;

import android.content.Context;
import com.jeremyliao.liveeventbus.ipc.json.JsonConverter;
import com.jeremyliao.liveeventbus.logger.Logger;

public class Config {
  public Config autoClear(boolean paramBoolean) {
    LiveEventBusCore.get().setAutoClear(paramBoolean);
    return this;
  }
  
  public Config enableLogger(boolean paramBoolean) {
    LiveEventBusCore.get().enableLogger(paramBoolean);
    return this;
  }
  
  public Config lifecycleObserverAlwaysActive(boolean paramBoolean) {
    LiveEventBusCore.get().setLifecycleObserverAlwaysActive(paramBoolean);
    return this;
  }
  
  public Config setJsonConverter(JsonConverter paramJsonConverter) {
    LiveEventBusCore.get().setJsonConverter(paramJsonConverter);
    return this;
  }
  
  public Config setLogger(Logger paramLogger) {
    LiveEventBusCore.get().setLogger(paramLogger);
    return this;
  }
  
  public Config supportBroadcast(Context paramContext) {
    LiveEventBusCore.get().registerReceiver(paramContext);
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\jeremyliao\liveeventbus\core\Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */