package com.blued.android.module.common.utils;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class LinkMovementClickMethod extends LinkMovementMethod {
  private static LinkMovementClickMethod c;
  
  private long a;
  
  private boolean b;
  
  public static LinkMovementClickMethod a() {
    if (c == null)
      c = new LinkMovementClickMethod(); 
    return c;
  }
  
  public boolean b() {
    return this.b;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent) {
    try {
      int i = paramMotionEvent.getAction();
      if (i == 1 || i == 0) {
        int j = (int)paramMotionEvent.getX();
        int k = (int)paramMotionEvent.getY();
        int m = paramTextView.getTotalPaddingLeft();
        int n = paramTextView.getTotalPaddingTop();
        int i1 = paramTextView.getScrollX();
        int i2 = paramTextView.getScrollY();
        Layout layout = paramTextView.getLayout();
        j = layout.getOffsetForHorizontal(layout.getLineForVertical(k - n + i2), (j - m + i1));
        ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])paramSpannable.getSpans(j, j, ClickableSpan.class);
        if (arrayOfClickableSpan.length != 0) {
          if (i == 1) {
            if (System.currentTimeMillis() - this.a < 500L)
              arrayOfClickableSpan[0].onClick((View)paramTextView); 
          } else if (i == 0) {
            Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(arrayOfClickableSpan[0]), paramSpannable.getSpanEnd(arrayOfClickableSpan[0]));
            this.a = System.currentTimeMillis();
          } 
          this.b = true;
          return true;
        } 
        Selection.removeSelection(paramSpannable);
        this.b = false;
      } 
    } catch (Exception exception) {}
    return super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\commo\\utils\LinkMovementClickMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */