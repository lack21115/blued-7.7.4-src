package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.transition.Transition;

public final class PreloadTarget<Z> extends CustomTarget<Z> {
  private static final Handler a = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message param1Message) {
          if (param1Message.what == 1) {
            ((PreloadTarget)param1Message.obj).e();
            return true;
          } 
          return false;
        }
      });
  
  private final RequestManager b;
  
  public void a(Z paramZ, Transition<? super Z> paramTransition) {
    a.obtainMessage(1, this).sendToTarget();
  }
  
  public void c(Drawable paramDrawable) {}
  
  void e() {
    this.b.a(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\request\target\PreloadTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */