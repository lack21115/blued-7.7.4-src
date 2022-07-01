package com.google.android.material.dialog;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class InsetDialogOnTouchListener implements View.OnTouchListener {
  private final Dialog a;
  
  private final int b;
  
  private final int c;
  
  private final int d;
  
  public InsetDialogOnTouchListener(Dialog paramDialog, Rect paramRect) {
    this.a = paramDialog;
    this.b = paramRect.left;
    this.c = paramRect.top;
    this.d = ViewConfiguration.get(paramDialog.getContext()).getScaledWindowTouchSlop();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    View view = paramView.findViewById(16908290);
    int i = this.b + view.getLeft();
    int j = view.getWidth();
    int k = this.c + view.getTop();
    int m = view.getHeight();
    if ((new RectF(i, k, (j + i), (m + k))).contains(paramMotionEvent.getX(), paramMotionEvent.getY()))
      return false; 
    MotionEvent motionEvent = MotionEvent.obtain(paramMotionEvent);
    if (paramMotionEvent.getAction() == 1)
      motionEvent.setAction(4); 
    if (Build.VERSION.SDK_INT < 28) {
      motionEvent.setAction(0);
      i = this.d;
      motionEvent.setLocation((-i - 1), (-i - 1));
    } 
    paramView.performClick();
    return this.a.onTouchEvent(motionEvent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\dialog\InsetDialogOnTouchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */