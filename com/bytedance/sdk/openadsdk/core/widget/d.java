package com.bytedance.sdk.openadsdk.core.widget;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ai;

public class d {
  private final a a;
  
  private boolean b = false;
  
  private boolean c = false;
  
  private float d;
  
  private float e;
  
  private int f;
  
  private int g;
  
  private boolean h = true;
  
  private boolean i = false;
  
  private final View.OnTouchListener j = new View.OnTouchListener(this) {
      public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
        boolean bool1 = d.a(this.a).m();
        boolean bool = false;
        null = false;
        if (bool1) {
          if (d.b(this.a) || !d.c(this.a))
            null = true; 
          return null;
        } 
        float f1 = param1MotionEvent.getX();
        float f2 = param1MotionEvent.getY();
        int i = param1MotionEvent.getAction();
        if (i != 0) {
          if (i != 1) {
            if (i != 2) {
              if (i == 3)
                d.a(this.a, false); 
            } else if (d.b(this.a) && !d.d(this.a)) {
              float f4 = d.e(this.a);
              float f3 = d.f(this.a);
              f4 = Math.abs(f1 - f4);
              f3 = Math.abs(f2 - f3);
              if (!d.g(this.a))
                if (f4 > 20.0F || f3 > 20.0F) {
                  d.c(this.a, true);
                } else {
                  return true;
                }  
              if (d.a(this.a) != null)
                d.a(this.a).l(); 
              d.a(this.a, f1);
              d.b(this.a, f2);
            } 
          } else {
            if (Math.abs(f1 - d.h(this.a)) > 20.0F || Math.abs(f2 - d.i(this.a)) > 20.0F)
              d.b(this.a, false); 
            if (!d.b(this.a))
              d.b(this.a, true); 
            d.c(this.a, false);
            d.a(this.a, 0.0F);
            d.b(this.a, 0.0F);
            d.a(this.a, 0);
            if (d.a(this.a) != null)
              d.a(this.a).a(param1View, d.j(this.a)); 
            d.a(this.a, false);
          } 
        } else {
          d d1 = this.a;
          d.a(d1, d.a(d1, param1MotionEvent));
          d.a(this.a, f1);
          d.b(this.a, f2);
          d.a(this.a, (int)f1);
          d.b(this.a, (int)f2);
          d.b(this.a, true);
          if (d.a(this.a) != null && d.c(this.a) && !d.b(this.a))
            d.a(this.a).a(param1View, true); 
        } 
        if (!d.b(this.a)) {
          null = bool;
          return !d.c(this.a) ? true : null;
        } 
        return true;
      }
    };
  
  private boolean k;
  
  public d(a parama) {
    this.a = parama;
  }
  
  private boolean a(MotionEvent paramMotionEvent) {
    int i = paramMotionEvent.getActionMasked();
    boolean bool = false;
    null = bool;
    if (i == 0) {
      i = ai.c(o.a().getApplicationContext());
      int j = ai.d(o.a().getApplicationContext());
      float f2 = paramMotionEvent.getRawX();
      float f1 = paramMotionEvent.getRawY();
      float f3 = i;
      if (f2 > f3 * 0.01F && f2 < f3 * 0.99F) {
        f2 = j;
        if (f1 > 0.01F * f2) {
          null = bool;
          return (f1 >= f2 * 0.99F) ? true : null;
        } 
      } 
    } else {
      return null;
    } 
    return true;
  }
  
  public void a(View paramView) {
    if (paramView != null)
      paramView.setOnTouchListener(this.j); 
  }
  
  public void a(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public static interface a {
    void a(View param1View, boolean param1Boolean);
    
    void l();
    
    boolean m();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */