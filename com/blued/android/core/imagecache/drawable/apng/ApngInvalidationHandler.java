package com.blued.android.core.imagecache.drawable.apng;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class ApngInvalidationHandler extends Handler {
  private final WeakReference<ApngDrawable> a;
  
  public ApngInvalidationHandler(ApngDrawable paramApngDrawable) {
    super(Looper.getMainLooper());
    this.a = new WeakReference<ApngDrawable>(paramApngDrawable);
  }
  
  public void handleMessage(Message paramMessage) {
    ApngDrawable apngDrawable = this.a.get();
    if (apngDrawable != null)
      apngDrawable.invalidateSelf(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\drawable\apng\ApngInvalidationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */