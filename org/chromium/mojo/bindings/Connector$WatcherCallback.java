package org.chromium.mojo.bindings;

import org.chromium.mojo.system.Watcher;

final class Connector$WatcherCallback implements Watcher.Callback {
  private Connector$WatcherCallback() {}
  
  public final void onResult(int paramInt) {
    Connector.access$100(Connector.this, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\Connector$WatcherCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */