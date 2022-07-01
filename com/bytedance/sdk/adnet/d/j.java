package com.bytedance.sdk.adnet.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class j extends Handler {
  private final WeakReference<a> a;
  
  public j(Looper paramLooper, a parama) {
    super(paramLooper);
    this.a = new WeakReference<a>(parama);
  }
  
  public void handleMessage(Message paramMessage) {
    a a = this.a.get();
    if (a != null && paramMessage != null)
      a.a(paramMessage); 
  }
  
  public static interface a {
    void a(Message param1Message);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\adnet\d\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */