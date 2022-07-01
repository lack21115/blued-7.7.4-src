package com.blued.android.module.common.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.utils.skin.listener.BluedSkinSupportable;
import skin.support.widget.SkinCompatBackgroundHelper;

public class CustomViewPager extends ViewPager implements BluedSkinSupportable {
  private int d;
  
  private Rect e;
  
  private SkinCompatBackgroundHelper f = new SkinCompatBackgroundHelper((View)this);
  
  public CustomViewPager(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.f.a(paramAttributeSet, 0);
    this.e = new Rect();
  }
  
  public void g() {
    SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f;
    if (skinCompatBackgroundHelper != null)
      skinCompatBackgroundHelper.a(); 
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    try {
      if (this.d > 0) {
        View view = findViewById(this.d);
        if (view != null) {
          if (this.e.bottom == 0)
            view.getHitRect(this.e); 
          if (this.e.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
            return false; 
        } 
      } 
      return super.onInterceptTouchEvent(paramMotionEvent);
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    try {
      return super.onTouchEvent(paramMotionEvent);
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public void setBackgroundResource(int paramInt) {
    super.setBackgroundResource(paramInt);
    SkinCompatBackgroundHelper skinCompatBackgroundHelper = this.f;
    if (skinCompatBackgroundHelper != null)
      skinCompatBackgroundHelper.a(paramInt); 
  }
  
  public void setChildId(int paramInt) {
    this.d = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\view\CustomViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */