package com.soft.blued.bluedBus;

import android.os.Looper;

public interface MainThreadSupport {
  Poster a(BluedBus paramBluedBus);
  
  public static class AndroidHandlerMainThreadSupport implements MainThreadSupport {
    private final Looper a;
    
    public AndroidHandlerMainThreadSupport(Looper param1Looper) {
      this.a = param1Looper;
    }
    
    public Poster a(BluedBus param1BluedBus) {
      return new HandlerPoster(param1BluedBus, this.a, 10);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\bluedBus\MainThreadSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */