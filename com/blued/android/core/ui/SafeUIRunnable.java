package com.blued.android.core.ui;

import com.blued.android.core.net.IRequestHost;

@Deprecated
public class SafeUIRunnable implements Runnable {
  private final IRequestHost a;
  
  private final Runnable b;
  
  public void run() {
    IRequestHost iRequestHost = this.a;
    if (iRequestHost != null && iRequestHost.isActive())
      this.b.run(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\ui\SafeUIRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */