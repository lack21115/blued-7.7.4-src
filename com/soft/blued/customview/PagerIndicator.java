package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.framework.utils.DensityUtils;

public class PagerIndicator extends LinearLayout {
  private LinearLayout.LayoutParams a;
  
  public PagerIndicator(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public PagerIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    this.a = new LinearLayout.LayoutParams(-2, -2);
    this.a.setMargins(0, 0, DensityUtils.a(getContext(), 2.5F), 0);
  }
  
  public int getPageCount() {
    return getChildCount();
  }
  
  public void setCurrentPage(int paramInt) {
    if (getChildCount() <= 0)
      return; 
    int j = getChildCount();
    for (int i = 0; i < getChildCount(); i++) {
      View view = getChildAt(i);
      if (i == paramInt % j) {
        view.setSelected(true);
      } else {
        view.setSelected(false);
      } 
    } 
  }
  
  public void setTotalPageSize(int paramInt) {
    if (paramInt == 1) {
      removeAllViews();
      return;
    } 
    if (paramInt == getChildCount())
      return; 
    if (paramInt > getChildCount()) {
      while (getChildCount() < paramInt) {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(2131233506);
        addView((View)imageView, (ViewGroup.LayoutParams)this.a);
      } 
    } else {
      while (getChildCount() > paramInt)
        removeViewAt(getChildCount() - 1); 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\PagerIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */