package com.soft.blued.ui.user.utils;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.reflect.Field;

public class FixAppBarLayoutBehavior extends AppBarLayout.Behavior {
  public FixAppBarLayoutBehavior() {}
  
  public FixAppBarLayoutBehavior(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private Object a(Object paramObject, String paramString) {
    try {
      Field field = paramObject.getClass().getSuperclass().getSuperclass().getDeclaredField(paramString);
      field.setAccessible(true);
      return field.get(paramObject);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  private Object b(Object paramObject, String paramString) {
    try {
      Field field = paramObject.getClass().getSuperclass().getSuperclass().getSuperclass().getDeclaredField(paramString);
      field.setAccessible(true);
      return field.get(paramObject);
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() == 0) {
      Object object;
      if (Build.VERSION.SDK_INT >= 28) {
        object = b(this, "scroller");
      } else {
        object = a(this, "mScroller");
      } 
      if (object != null && object instanceof OverScroller)
        ((OverScroller)object).abortAnimation(); 
    } 
    return super.onInterceptTouchEvent(paramCoordinatorLayout, (View)paramAppBarLayout, paramMotionEvent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\use\\utils\FixAppBarLayoutBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */