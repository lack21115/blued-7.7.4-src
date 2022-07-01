package org.chromium.content.browser;

import org.chromium.base.Log;

final class BindingManager$1 implements Runnable {
  public final void run() {
    Log.i("cr_BindingManager", "onTrimMemory: level=%d, size=%d", new Object[] { Integer.valueOf(this.val$level), Integer.valueOf(BindingManager.access$000(this.this$0).size()) });
    if (BindingManager.access$000(BindingManager.this).isEmpty())
      return; 
    if (level <= 5) {
      BindingManager.access$100(BindingManager.this, 0.25F);
      return;
    } 
    if (level <= 10) {
      BindingManager.access$100(BindingManager.this, 0.5F);
      return;
    } 
    if (level == 20)
      return; 
    BindingManager.this.removeAllConnections();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\BindingManager$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */