package com.scwang.smartrefresh.layout.util;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

public class SmartUtil {
  public static int a(Context paramContext, int paramInt) {
    return (Build.VERSION.SDK_INT >= 23) ? paramContext.getColor(paramInt) : paramContext.getResources().getColor(paramInt);
  }
  
  public static int a(View paramView) {
    int i;
    ViewGroup.LayoutParams layoutParams2 = paramView.getLayoutParams();
    ViewGroup.LayoutParams layoutParams1 = layoutParams2;
    if (layoutParams2 == null)
      layoutParams1 = new ViewGroup.LayoutParams(-1, -2); 
    int j = ViewGroup.getChildMeasureSpec(0, 0, layoutParams1.width);
    if (layoutParams1.height > 0) {
      i = View.MeasureSpec.makeMeasureSpec(layoutParams1.height, 1073741824);
    } else {
      i = View.MeasureSpec.makeMeasureSpec(0, 0);
    } 
    paramView.measure(j, i);
    return paramView.getMeasuredHeight();
  }
  
  public static void a(View paramView, int paramInt) {
    if (paramView instanceof ScrollView) {
      ((ScrollView)paramView).fling(paramInt);
      return;
    } 
    if (paramView instanceof AbsListView) {
      if (Build.VERSION.SDK_INT >= 21) {
        ((AbsListView)paramView).fling(paramInt);
        return;
      } 
    } else {
      if (paramView instanceof WebView) {
        ((WebView)paramView).flingScroll(0, paramInt);
        return;
      } 
      if (paramView instanceof NestedScrollView) {
        ((NestedScrollView)paramView).fling(paramInt);
        return;
      } 
      if (paramView instanceof RecyclerView)
        ((RecyclerView)paramView).fling(0, paramInt); 
    } 
  }
  
  public static void a(AbsListView paramAbsListView, int paramInt) {
    if (Build.VERSION.SDK_INT >= 19) {
      paramAbsListView.scrollListBy(paramInt);
      return;
    } 
    if (paramAbsListView instanceof ListView) {
      int i = paramAbsListView.getFirstVisiblePosition();
      if (i == -1)
        return; 
      View view = paramAbsListView.getChildAt(0);
      if (view == null)
        return; 
      int j = view.getTop();
      ((ListView)paramAbsListView).setSelectionFromTop(i, j - paramInt);
      return;
    } 
    paramAbsListView.smoothScrollBy(paramInt, 0);
  }
  
  public static boolean b(View paramView) {
    return (paramView instanceof AbsListView || paramView instanceof ScrollView || paramView instanceof androidx.core.view.ScrollingView || paramView instanceof WebView || paramView instanceof androidx.core.view.NestedScrollingChild);
  }
  
  public static boolean c(View paramView) {
    return (b(paramView) || paramView instanceof androidx.viewpager.widget.ViewPager || paramView instanceof androidx.core.view.NestedScrollingParent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layou\\util\SmartUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */