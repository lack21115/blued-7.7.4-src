package com.blued.android.module.common.view;

import android.app.Dialog;
import android.content.Context;
import androidx.lifecycle.Observer;
import com.blued.android.framework.utils.Logger;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class LifecycleDialog extends Dialog {
  private Observer<String> a = new Observer<String>(this) {
      public void a(String param1String) {
        Logger.e("LifecycleDialog", new Object[] { "关闭 LifecycleDialog 。。。" });
        this.a.cancel();
      }
    };
  
  public LifecycleDialog(Context paramContext) {
    super(paramContext);
  }
  
  public void dismiss() {
    super.dismiss();
    LiveEventBus.get("dialog_cancel_event", String.class).removeObserver(this.a);
  }
  
  public void show() {
    super.show();
    LiveEventBus.get("dialog_cancel_event", String.class).observeForever(this.a);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\view\LifecycleDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */