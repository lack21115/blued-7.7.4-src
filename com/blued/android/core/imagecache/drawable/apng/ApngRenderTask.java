package com.blued.android.core.imagecache.drawable.apng;

import android.graphics.Bitmap;
import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

public class ApngRenderTask implements Runnable {
  private ApngDrawable a;
  
  private ApngFrameDecode b;
  
  public ApngRenderTask(ApngDrawable paramApngDrawable, ApngFrameDecode paramApngFrameDecode) {
    this.a = paramApngDrawable;
    this.b = paramApngFrameDecode;
  }
  
  public void run() {
    int j = this.a.e + 1;
    int i = j;
    if (j >= this.b.b)
      if (this.a.h()) {
        this.a.e = -1;
        i = 0;
      } else {
        return;
      }  
    long l1 = SystemClock.uptimeMillis();
    Bitmap bitmap = this.b.b(i);
    if (this.a.j != null && this.a.j != bitmap)
      this.a.h.b(this.a.j); 
    ApngDrawable apngDrawable = this.a;
    apngDrawable.j = bitmap;
    apngDrawable.e++;
    long l2 = SystemClock.uptimeMillis();
    i = (int)(this.b.a(i) - l2 - l1);
    this.a.f.schedule(this, i, TimeUnit.MILLISECONDS);
    if (this.a.isVisible() && this.a.isRunning() && !this.a.i.hasMessages(0))
      this.a.i.sendEmptyMessageAtTime(0, 0L); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\drawable\apng\ApngRenderTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */