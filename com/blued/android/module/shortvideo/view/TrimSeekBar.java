package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatSeekBar;

public class TrimSeekBar extends AppCompatSeekBar {
  private static int a = 150;
  
  public TrimSeekBar(Context paramContext) {
    super(paramContext);
  }
  
  public TrimSeekBar(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public TrimSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    int j = (getThumb().getBounds()).left - a;
    int i = j;
    if (j < 0)
      i = 0; 
    j = (getThumb().getBounds()).right;
    int k = a;
    int m = (int)paramMotionEvent.getX();
    return (paramMotionEvent.getAction() == 0 && (m <= i || m >= j + k)) ? false : super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\TrimSeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */