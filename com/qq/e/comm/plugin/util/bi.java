package com.qq.e.comm.plugin.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class bi extends Handler {
  final WeakReference<a> a;
  
  public bi(a parama, Looper paramLooper) {
    super(paramLooper);
    this.a = new WeakReference<a>(parama);
  }
  
  public void handleMessage(Message paramMessage) {
    super.handleMessage(paramMessage);
    a a = this.a.get();
    if (a != null && paramMessage != null)
      a.a(paramMessage); 
  }
  
  public static interface a {
    void a(Message param1Message);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugi\\util\bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */