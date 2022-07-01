package com.qq.e.comm.plugin.aa.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class c extends FrameLayout {
  private long a;
  
  private a b;
  
  public c(Context paramContext) {
    super(paramContext);
  }
  
  public void a(a parama) {
    this.b = parama;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
    if (this.b != null) {
      long l = SystemClock.elapsedRealtime();
      if (l - this.a > 1000L) {
        this.a = l;
        this.b.h();
      } 
    } 
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public static interface a {
    void h();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\aa\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */