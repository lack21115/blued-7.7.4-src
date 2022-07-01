package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;

public class TouchEnableKeyboardLinearLayout extends KeyboardListenLinearLayout {
  private boolean a;
  
  public TouchEnableKeyboardLinearLayout(Context paramContext) {
    super(paramContext);
  }
  
  public TouchEnableKeyboardLinearLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public TouchEnableKeyboardLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    return this.a ? true : super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return this.a ? true : super.onTouchEvent(paramMotionEvent);
  }
  
  public void setIntercept(boolean paramBoolean) {
    this.a = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\TouchEnableKeyboardLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */