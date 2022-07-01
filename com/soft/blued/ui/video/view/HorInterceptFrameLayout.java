package com.soft.blued.ui.video.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.soft.blued.utils.Logger;

public class HorInterceptFrameLayout extends FrameLayout {
  private float a;
  
  private float b;
  
  private float c;
  
  private float d;
  
  private int e;
  
  private boolean f;
  
  private OnHorScrollListener g;
  
  public HorInterceptFrameLayout(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public HorInterceptFrameLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a() {
    this.e = ViewConfiguration.get(getContext()).getScaledPagingTouchSlop();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    try {
      int i = paramMotionEvent.getAction();
      i &= 0xFF;
      if (i != 3) {
        if (i == 1)
          return false; 
        if (i != 0) {
          if (i != 2) {
            if (i == 6)
              Logger.b("HorInterceptFrameLayout", new Object[] { "onInterceptTouchEvent ACTION_POINTER_UP" }); 
          } else {
            float f1 = Math.abs(paramMotionEvent.getX() - this.c);
            float f2 = Math.abs(paramMotionEvent.getY() - this.d);
            if (f1 > this.e && f1 * 0.5F > f2)
              this.f = true; 
            Logger.b("HorInterceptFrameLayout", new Object[] { "onInterceptTouchEvent ACTION_MOVE" });
          } 
        } else {
          float f = paramMotionEvent.getX();
          this.c = f;
          this.a = f;
          f = paramMotionEvent.getY();
          this.d = f;
          this.b = f;
          this.f = false;
          Logger.b("HorInterceptFrameLayout", new Object[] { "onInterceptTouchEvent ACTION_DOWN" });
        } 
      } else {
        return false;
      } 
    } catch (Exception exception) {}
    return this.f;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    try {
      if (paramMotionEvent.getAction() == 0 && paramMotionEvent.getEdgeFlags() != 0)
        return false; 
      int i = paramMotionEvent.getAction();
      int j = i & 0xFF;
      if (j != 0) {
        if (j != 1)
          if (j != 2) {
            if (j != 3) {
              if (j != 5) {
                if (j != 6)
                  return true; 
              } else {
                Logger.b("HorInterceptFrameLayout", new Object[] { "ACTION_POINTER_DOWN" });
                return true;
              } 
            } else {
              Logger.b("HorInterceptFrameLayout", new Object[] { "ACTION_CANCEL" });
              if (this.g != null) {
                this.g.a(i, 0.0F);
                return true;
              } 
              return true;
            } 
          } else {
            float f1 = paramMotionEvent.getX();
            float f2 = Math.abs(f1 - this.a);
            float f3 = paramMotionEvent.getY();
            if (f2 > Math.abs(f3 - this.b) && this.g != null)
              this.g.a(i, f1 - this.a); 
            this.a = f1;
            this.b = f3;
            return true;
          }  
        Logger.b("HorInterceptFrameLayout", new Object[] { "ACTION_UP" });
        if (this.g != null) {
          this.g.a(i, 0.0F);
          return true;
        } 
      } else {
        float f = paramMotionEvent.getX();
        this.c = f;
        this.a = f;
        f = paramMotionEvent.getY();
        this.d = f;
        this.b = f;
        Logger.b("HorInterceptFrameLayout", new Object[] { "ACTION_DOWN" });
      } 
      return true;
    } catch (Exception exception) {
      return true;
    } 
  }
  
  public void setOnHorScrollListener(OnHorScrollListener paramOnHorScrollListener) {
    this.g = paramOnHorScrollListener;
  }
  
  public static interface OnHorScrollListener {
    void a(int param1Int, float param1Float);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\view\HorInterceptFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */