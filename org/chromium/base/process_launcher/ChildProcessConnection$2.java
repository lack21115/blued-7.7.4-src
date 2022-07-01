package org.chromium.base.process_launcher;

import android.os.IBinder;

final class ChildProcessConnection$2 implements ChildProcessConnection$ChildServiceConnectionDelegate {
  public final void onServiceConnected(IBinder paramIBinder) {
    ChildProcessConnection.access$200(ChildProcessConnection.this).post(new ChildProcessConnection$2$1(this, paramIBinder));
  }
  
  public final void onServiceDisconnected() {
    ChildProcessConnection.access$200(ChildProcessConnection.this).post(new ChildProcessConnection$2$2(this));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\ChildProcessConnection$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */