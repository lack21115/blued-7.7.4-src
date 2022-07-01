package com.baidu.mobads.production;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.utils.q;

class k extends Handler {
  k(b paramb, Looper paramLooper, IXAdInstanceInfo paramIXAdInstanceInfo) {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage) {
    if (paramMessage.what != 0)
      return; 
    try {
      b.a(this.b, paramMessage, this.a);
      return;
    } catch (Exception exception) {
      q.a().d(exception);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */