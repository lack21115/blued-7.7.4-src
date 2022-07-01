package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import skin.support.widget.SkinCompatBackgroundHelper;

public class NearbyHomeViewPager extends ViewPager implements BluedSkinSupportable {
  private Rect d;
  
  private SkinCompatBackgroundHelper e;
  
  public NearbyHomeViewPager(Context paramContext) {
    super(paramContext);
  }
  
  public NearbyHomeViewPager(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.e = new SkinCompatBackgroundHelper((View)this);
    this.e.a(paramAttributeSet, 0);
  }
  
  public void g() {
    SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.e;
    if (skinCompatBackgroundHelper != null)
      skinCompatBackgroundHelper.a(); 
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    try {
      return (getCurrentItem() == 0 && this.d != null && this.d.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) ? false : super.onInterceptTouchEvent(paramMotionEvent);
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.e;
    if (skinCompatBackgroundHelper != null)
      skinCompatBackgroundHelper.a(paramInt); 
  }
  
  public void setIgnoreRect(Rect paramRect) {
    this.d = paramRect;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\NearbyHomeViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */