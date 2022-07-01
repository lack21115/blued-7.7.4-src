package com.blued.android.core.utils.toast;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

final class ToastHelper extends Handler {
  private final Toast a;
  
  private final WindowHelper b;
  
  private final String c;
  
  private boolean d;
  
  ToastHelper(Toast paramToast, Application paramApplication) {
    super(Looper.getMainLooper());
    this.a = paramToast;
    this.c = paramApplication.getPackageName();
    this.b = WindowHelper.a(this, paramApplication);
  }
  
  void a() {
    if (!this.d) {
      WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
      layoutParams.height = -2;
      layoutParams.width = -2;
      layoutParams.format = -3;
      layoutParams.windowAnimations = 16973828;
      layoutParams.flags = 152;
      layoutParams.packageName = this.c;
      layoutParams.gravity = this.a.getGravity();
      layoutParams.x = this.a.getXOffset();
      layoutParams.y = this.a.getYOffset();
      try {
        long l;
        this.b.a().addView(this.a.getView(), (ViewGroup.LayoutParams)layoutParams);
        this.d = true;
        if (this.a.getDuration() == 1) {
          l = 3500L;
        } else {
          l = 2000L;
        } 
        sendEmptyMessageDelayed(0, l);
        return;
      } catch (NullPointerException|IllegalStateException|android.view.WindowManager.BadTokenException nullPointerException) {
        return;
      } 
    } 
  }
  
  void b() {
    removeMessages(0);
    if (this.d) {
      try {
        this.b.a().removeViewImmediate(this.a.getView());
      } catch (NullPointerException|IllegalArgumentException nullPointerException) {}
      this.d = false;
    } 
  }
  
  public void handleMessage(Message paramMessage) {
    b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\toast\ToastHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */