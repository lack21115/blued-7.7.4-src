package com.blued.android.module.common.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;

public class NoScrollViewPager extends ViewPager {
  public NoScrollViewPager(Context paramContext) {
    this(paramContext, null);
  }
  
  public NoScrollViewPager(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean canScrollHorizontally(int paramInt) {
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\view\NoScrollViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */