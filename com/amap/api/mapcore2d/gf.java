package com.amap.api.mapcore2d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public final class gf extends Handler {
  gd a = null;
  
  public gf(Looper paramLooper, gd paramgd) {
    super(paramLooper);
    this.a = paramgd;
  }
  
  public gf(gd paramgd) {
    this.a = paramgd;
  }
  
  public final void handleMessage(Message paramMessage) {
    if (paramMessage.what != 1)
      return; 
    try {
      return;
    } finally {
      paramMessage = null;
      gu.a((Throwable)paramMessage, "ClientResultHandler", "RESULT_LOCATION_FINISH");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\gf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */