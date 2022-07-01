package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

public class CompluteViewPager extends ViewPager {
  public CompluteViewPager(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    int j = 0;
    int i;
    for (i = 0; j < getChildCount(); i = k) {
      View view = getChildAt(j);
      view.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
      int m = view.getMeasuredHeight();
      int k = i;
      if (m > i)
        k = m; 
      j++;
    } 
    if (i > 0)
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824); 
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\CompluteViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */