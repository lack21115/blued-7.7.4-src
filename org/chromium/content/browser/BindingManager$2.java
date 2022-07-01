package org.chromium.content.browser;

import org.chromium.base.Log;

final class BindingManager$2 implements Runnable {
  public final void run() {
    Log.i("cr_BindingManager", "onLowMemory: evict %d bindings", new Object[] { Integer.valueOf(BindingManager.access$000(this.this$0).size()) });
    BindingManager.this.removeAllConnections();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\BindingManager$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */