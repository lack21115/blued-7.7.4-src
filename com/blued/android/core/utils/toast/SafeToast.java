package com.blued.android.core.utils.toast;

import android.app.Application;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;
import android.widget.Toast;
import java.lang.reflect.Field;

final class SafeToast extends BaseToast {
  SafeToast(Application paramApplication) {
    super(paramApplication);
    try {
      Field field = Toast.class.getDeclaredField("mTN");
      field.setAccessible(true);
      Object object = field.get(this);
      field = field.getType().getDeclaredField("mHandler");
      field.setAccessible(true);
      field.set(object, new SafeHandler((Handler)field.get(object)));
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  static final class SafeHandler extends Handler {
    private Handler a;
    
    private SafeHandler(Handler param1Handler) {
      this.a = param1Handler;
    }
    
    public void handleMessage(Message param1Message) {
      try {
        this.a.handleMessage(param1Message);
        return;
      } catch (android.view.WindowManager.BadTokenException|IllegalStateException badTokenException) {
        return;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\toast\SafeToast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */