package com.blued.android.framework.ui.xpop.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.blued.android.framework.ui.xpop.interfaces.OnClickOutsideListener;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;

public class PartShadowContainer extends FrameLayout {
  public boolean a = true;
  
  private float b;
  
  private float c;
  
  private OnClickOutsideListener d;
  
  public PartShadowContainer(Context paramContext) {
    super(paramContext);
  }
  
  public PartShadowContainer(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PartShadowContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    View view = getChildAt(0);
    int[] arrayOfInt = new int[2];
    view.getLocationInWindow(arrayOfInt);
    Rect rect = new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + view.getMeasuredWidth(), arrayOfInt[1] + view.getMeasuredHeight());
    if (!XPopupUtils.a(paramMotionEvent.getRawX(), paramMotionEvent.getRawY(), rect)) {
      OnClickOutsideListener onClickOutsideListener;
      int i = paramMotionEvent.getAction();
      if (i != 0) {
        if (i != 1)
          return true; 
        float f1 = paramMotionEvent.getX();
        float f2 = this.b;
        float f3 = paramMotionEvent.getY();
        float f4 = this.c;
        if ((float)Math.sqrt(Math.pow((f1 - f2), 2.0D) + Math.pow((f3 - f4), 2.0D)) < ViewConfiguration.get(getContext()).getScaledTouchSlop() && this.a) {
          onClickOutsideListener = this.d;
          if (onClickOutsideListener != null)
            onClickOutsideListener.a(); 
        } 
        this.b = 0.0F;
        this.c = 0.0F;
        return true;
      } 
      this.b = onClickOutsideListener.getX();
      this.c = onClickOutsideListener.getY();
    } 
    return true;
  }
  
  public void setOnClickOutsideListener(OnClickOutsideListener paramOnClickOutsideListener) {
    this.d = paramOnClickOutsideListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\widget\PartShadowContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */