package cn.shuzilm.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

final class AIClient$AC implements ServiceConnection {
  boolean a = false;
  
  private final LinkedBlockingQueue b = new LinkedBlockingQueue(1);
  
  private AIClient$AC() {}
  
  public IBinder getBinder() {
    if (!this.a) {
      this.a = true;
      return this.b.take();
    } 
    throw new IllegalStateException();
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    try {
      this.b.put(paramIBinder);
      return;
    } catch (InterruptedException interruptedException) {
      return;
    } 
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\AIClient$AC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */