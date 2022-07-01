package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ShowableListMenu;

public abstract class ForwardingListener implements View.OnAttachStateChangeListener, View.OnTouchListener {
  private final float a;
  
  private final int b;
  
  final View c;
  
  private final int d;
  
  private Runnable e;
  
  private Runnable f;
  
  private boolean g;
  
  private int h;
  
  private final int[] i = new int[2];
  
  public ForwardingListener(View paramView) {
    this.c = paramView;
    paramView.setLongClickable(true);
    paramView.addOnAttachStateChangeListener(this);
    this.a = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    this.b = ViewConfiguration.getTapTimeout();
    this.d = (this.b + ViewConfiguration.getLongPressTimeout()) / 2;
  }
  
  private boolean a(MotionEvent paramMotionEvent) {
    View view = this.c;
    if (!view.isEnabled())
      return false; 
    int i = paramMotionEvent.getActionMasked();
    if (i != 0) {
      if (i != 1)
        if (i != 2) {
          if (i != 3)
            return false; 
        } else {
          i = paramMotionEvent.findPointerIndex(this.h);
          if (i >= 0 && !a(view, paramMotionEvent.getX(i), paramMotionEvent.getY(i), this.a)) {
            b();
            view.getParent().requestDisallowInterceptTouchEvent(true);
            return true;
          } 
          return false;
        }  
      b();
      return false;
    } 
    this.h = paramMotionEvent.getPointerId(0);
    if (this.e == null)
      this.e = new DisallowIntercept(this); 
    view.postDelayed(this.e, this.b);
    if (this.f == null)
      this.f = new TriggerLongPress(this); 
    view.postDelayed(this.f, this.d);
    return false;
  }
  
  private static boolean a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3) {
    float f = -paramFloat3;
    return (paramFloat1 >= f && paramFloat2 >= f && paramFloat1 < (paramView.getRight() - paramView.getLeft()) + paramFloat3 && paramFloat2 < (paramView.getBottom() - paramView.getTop()) + paramFloat3);
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent) {
    int[] arrayOfInt = this.i;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(-arrayOfInt[0], -arrayOfInt[1]);
    return true;
  }
  
  private void b() {
    Runnable runnable = this.f;
    if (runnable != null)
      this.c.removeCallbacks(runnable); 
    runnable = this.e;
    if (runnable != null)
      this.c.removeCallbacks(runnable); 
  }
  
  private boolean b(MotionEvent paramMotionEvent) {
    View view = this.c;
    ShowableListMenu showableListMenu = getPopup();
    if (showableListMenu != null) {
      if (!showableListMenu.isShowing())
        return false; 
      DropDownListView dropDownListView = (DropDownListView)showableListMenu.getListView();
      if (dropDownListView != null) {
        if (!dropDownListView.isShown())
          return false; 
        MotionEvent motionEvent = MotionEvent.obtainNoHistory(paramMotionEvent);
        b(view, motionEvent);
        a((View)dropDownListView, motionEvent);
        boolean bool = dropDownListView.onForwardedEvent(motionEvent, this.h);
        motionEvent.recycle();
        int i = paramMotionEvent.getActionMasked();
        if (i != 1 && i != 3) {
          i = 1;
        } else {
          i = 0;
        } 
        return (bool && i != 0);
      } 
    } 
    return false;
  }
  
  private boolean b(View paramView, MotionEvent paramMotionEvent) {
    int[] arrayOfInt = this.i;
    paramView.getLocationOnScreen(arrayOfInt);
    paramMotionEvent.offsetLocation(arrayOfInt[0], arrayOfInt[1]);
    return true;
  }
  
  void a() {
    b();
    View view = this.c;
    if (view.isEnabled()) {
      if (view.isLongClickable())
        return; 
      if (!onForwardingStarted())
        return; 
      view.getParent().requestDisallowInterceptTouchEvent(true);
      long l = SystemClock.uptimeMillis();
      MotionEvent motionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      view.onTouchEvent(motionEvent);
      motionEvent.recycle();
      this.g = true;
    } 
  }
  
  public abstract ShowableListMenu getPopup();
  
  protected boolean onForwardingStarted() {
    ShowableListMenu showableListMenu = getPopup();
    if (showableListMenu != null && !showableListMenu.isShowing())
      showableListMenu.show(); 
    return true;
  }
  
  protected boolean onForwardingStopped() {
    ShowableListMenu showableListMenu = getPopup();
    if (showableListMenu != null && showableListMenu.isShowing())
      showableListMenu.dismiss(); 
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    boolean bool1;
    boolean bool = this.g;
    boolean bool3 = true;
    if (bool) {
      if (b(paramMotionEvent) || !onForwardingStopped()) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
    } else {
      boolean bool4;
      if (a(paramMotionEvent) && onForwardingStarted()) {
        bool4 = true;
      } else {
        bool4 = false;
      } 
      bool1 = bool4;
      if (bool4) {
        long l = SystemClock.uptimeMillis();
        MotionEvent motionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
        this.c.onTouchEvent(motionEvent);
        motionEvent.recycle();
        bool1 = bool4;
      } 
    } 
    this.g = bool1;
    boolean bool2 = bool3;
    if (!bool1) {
      if (bool)
        return true; 
      bool2 = false;
    } 
    return bool2;
  }
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView) {
    this.g = false;
    this.h = -1;
    Runnable runnable = this.e;
    if (runnable != null)
      this.c.removeCallbacks(runnable); 
  }
  
  class DisallowIntercept implements Runnable {
    DisallowIntercept(ForwardingListener this$0) {}
    
    public void run() {
      ViewParent viewParent = this.a.c.getParent();
      if (viewParent != null)
        viewParent.requestDisallowInterceptTouchEvent(true); 
    }
  }
  
  class TriggerLongPress implements Runnable {
    TriggerLongPress(ForwardingListener this$0) {}
    
    public void run() {
      this.a.a();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\ForwardingListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */