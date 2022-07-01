package com.soft.blued.ui.msg.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class AutoHeightViewPager extends ViewPager {
  private int d;
  
  private int e;
  
  private HashMap<Integer, View> f = new LinkedHashMap<Integer, View>();
  
  public AutoHeightViewPager(Context paramContext) {
    super(paramContext);
  }
  
  public AutoHeightViewPager(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(View paramView, int paramInt) {
    this.f.put(Integer.valueOf(paramInt), paramView);
  }
  
  public void c(int paramInt) {
    this.d = paramInt;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    return false;
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    int i = this.f.size();
    int j = this.d;
    if (i > j) {
      View view = this.f.get(Integer.valueOf(j));
      view.measure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, 0));
      this.e = view.getMeasuredHeight();
    } 
    if (this.f.size() != 0)
      paramInt2 = View.MeasureSpec.makeMeasureSpec(this.e, 1073741824); 
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\customview\AutoHeightViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */