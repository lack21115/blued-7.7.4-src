package com.soft.blued.customview.consecutivescroller;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;

public class ConsecutiveViewPager extends ViewPager implements IConsecutiveScroller {
  private int d;
  
  public ConsecutiveViewPager(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private void c(View paramView) {
    paramView.setVerticalScrollBarEnabled(false);
    paramView.setHorizontalScrollBarEnabled(false);
    paramView.setOverScrollMode(2);
    ViewCompat.setNestedScrollingEnabled(paramView, false);
  }
  
  private boolean f() {
    ViewParent viewParent = getParent();
    boolean bool = viewParent instanceof ConsecutiveScrollerLayout;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      ConsecutiveScrollerLayout consecutiveScrollerLayout = (ConsecutiveScrollerLayout)viewParent;
      bool1 = bool2;
      if (consecutiveScrollerLayout.indexOfChild((View)this) == consecutiveScrollerLayout.getChildCount() - 1)
        bool1 = true; 
    } 
    return bool1;
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams) {
    super.addView(paramView, paramInt, paramLayoutParams);
    if (ScrollUtils.g((View)this)) {
      c(paramView);
      if (paramView instanceof ViewGroup)
        ((ViewGroup)paramView).setClipToPadding(false); 
    } 
  }
  
  public int getAdjustHeight() {
    return this.d;
  }
  
  public View getCurrentScrollerView() {
    int j = getChildCount();
    for (int i = 0; i < j; i++) {
      View view = getChildAt(i);
      if (view.getX() == (getScrollX() + getPaddingLeft()))
        return view; 
    } 
    return (View)this;
  }
  
  public List<View> getScrolledViews() {
    ArrayList<View> arrayList = new ArrayList();
    int i = getChildCount();
    if (i > 0)
      for (int j = 0; j < i; j++)
        arrayList.add(getChildAt(j));  
    return arrayList;
  }
  
  public void onMeasure(int paramInt1, int paramInt2) {
    if (f() && this.d > 0) {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(getDefaultSize(0, paramInt2) - this.d, View.MeasureSpec.getMode(paramInt2)));
      return;
    } 
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setAdjustHeight(int paramInt) {
    if (this.d != paramInt) {
      this.d = paramInt;
      requestLayout();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\consecutivescroller\ConsecutiveViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */