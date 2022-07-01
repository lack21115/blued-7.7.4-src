package com.soft.blued.customview;

import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

public class CustomLinkMovementMethod extends LinkMovementMethod {
  private static CustomLinkMovementMethod a;
  
  public static CustomLinkMovementMethod a() {
    if (a == null)
      a = new CustomLinkMovementMethod(); 
    return a;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent) {
    boolean bool = super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
    if (!bool && paramMotionEvent.getAction() == 1) {
      ViewParent viewParent = paramTextView.getParent();
      if (viewParent instanceof ViewGroup)
        return ((ViewGroup)viewParent).performClick(); 
    } 
    return bool;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\CustomLinkMovementMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */