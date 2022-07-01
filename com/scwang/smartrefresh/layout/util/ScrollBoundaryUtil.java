package com.scwang.smartrefresh.layout.util;

import android.graphics.PointF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

public class ScrollBoundaryUtil {
  public static boolean a(View paramView) {
    if (Build.VERSION.SDK_INT < 14) {
      boolean bool1 = paramView instanceof AbsListView;
      boolean bool = true;
      if (bool1) {
        ViewGroup viewGroup = (ViewGroup)paramView;
        AbsListView absListView = (AbsListView)paramView;
        if (viewGroup.getChildCount() > 0)
          if (absListView.getFirstVisiblePosition() <= 0) {
            if (viewGroup.getChildAt(0).getTop() < paramView.getPaddingTop())
              return true; 
          } else {
            return bool;
          }  
        return false;
      } 
      return (paramView.getScrollY() > 0);
    } 
    return paramView.canScrollVertically(-1);
  }
  
  public static boolean a(View paramView, PointF paramPointF) {
    if (a(paramView) && paramView.getVisibility() == 0)
      return false; 
    if (paramView instanceof ViewGroup && paramPointF != null) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      int i = viewGroup.getChildCount();
      PointF pointF = new PointF();
      while (i > 0) {
        View view = viewGroup.getChildAt(i - 1);
        if (a((View)viewGroup, view, paramPointF.x, paramPointF.y, pointF)) {
          paramPointF.offset(pointF.x, pointF.y);
          boolean bool = a(view, paramPointF);
          paramPointF.offset(-pointF.x, -pointF.y);
          return bool;
        } 
        i--;
      } 
    } 
    return true;
  }
  
  public static boolean a(View paramView, PointF paramPointF, boolean paramBoolean) {
    boolean bool1 = b(paramView);
    boolean bool = false;
    if (bool1 && paramView.getVisibility() == 0)
      return false; 
    if (paramView instanceof ViewGroup && paramPointF != null && !SmartUtil.b(paramView)) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      int j = viewGroup.getChildCount();
      PointF pointF = new PointF();
      for (int i = 0; i < j; i++) {
        View view = viewGroup.getChildAt(i);
        if (a((View)viewGroup, view, paramPointF.x, paramPointF.y, pointF)) {
          paramPointF.offset(pointF.x, pointF.y);
          paramBoolean = a(view, paramPointF, paramBoolean);
          paramPointF.offset(-pointF.x, -pointF.y);
          return paramBoolean;
        } 
      } 
    } 
    if (!paramBoolean) {
      paramBoolean = bool;
      return a(paramView) ? true : paramBoolean;
    } 
    return true;
  }
  
  public static boolean a(View paramView1, View paramView2, float paramFloat1, float paramFloat2, PointF paramPointF) {
    boolean bool;
    if (paramView2.getVisibility() != 0)
      return false; 
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    arrayOfFloat[0] = arrayOfFloat[0] + (paramView1.getScrollX() - paramView2.getLeft());
    arrayOfFloat[1] = arrayOfFloat[1] + (paramView1.getScrollY() - paramView2.getTop());
    if (arrayOfFloat[0] >= 0.0F && arrayOfFloat[1] >= 0.0F && arrayOfFloat[0] < paramView2.getWidth() && arrayOfFloat[1] < paramView2.getHeight()) {
      bool = true;
    } else {
      bool = false;
    } 
    if (bool && paramPointF != null)
      paramPointF.set(arrayOfFloat[0] - paramFloat1, arrayOfFloat[1] - paramFloat2); 
    return bool;
  }
  
  public static boolean b(View paramView) {
    int i = Build.VERSION.SDK_INT;
    boolean bool = true;
    if (i < 14) {
      if (paramView instanceof AbsListView) {
        ViewGroup viewGroup = (ViewGroup)paramView;
        AbsListView absListView = (AbsListView)paramView;
        int j = viewGroup.getChildCount();
        if (j > 0) {
          i = absListView.getLastVisiblePosition();
          if (i >= --j) {
            if (viewGroup.getChildAt(j).getBottom() > paramView.getPaddingBottom())
              return true; 
          } else {
            return bool;
          } 
        } 
        return false;
      } 
      return (paramView.getScrollY() < 0);
    } 
    return paramView.canScrollVertically(1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layou\\util\ScrollBoundaryUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */