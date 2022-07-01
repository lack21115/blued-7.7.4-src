package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;

final class c implements Runnable {
  c(b paramb) {}
  
  public final void run() {
    try {
      Process.setThreadPriority(0);
    } catch (Exception exception) {
    
    } finally {
      b.b(this.a);
    } 
    b.b(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\apmobilesecuritysdk\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */