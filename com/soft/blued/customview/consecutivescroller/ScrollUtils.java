package com.soft.blued.customview.consecutivescroller;

import android.graphics.Rect;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.core.view.ScrollingView;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ScrollUtils {
  private static final Rect a = new Rect();
  
  static int a(View paramView) {
    paramView = h(paramView);
    if (paramView instanceof ScrollingView)
      return ((ScrollingView)paramView).computeVerticalScrollOffset(); 
    try {
      Method method = View.class.getDeclaredMethod("computeVerticalScrollOffset", new Class[0]);
      method.setAccessible(true);
      return ((Integer)method.invoke(paramView, new Object[0])).intValue();
    } catch (Exception exception) {
      exception.printStackTrace();
      return paramView.getScrollY();
    } 
  }
  
  static int a(View paramView, MotionEvent paramMotionEvent, int paramInt) {
    if (Build.VERSION.SDK_INT >= 29) {
      float f1 = paramMotionEvent.getRawX(paramInt);
      return (int)f1;
    } 
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    float f = arrayOfInt[0] + paramMotionEvent.getX(paramInt);
    return (int)f;
  }
  
  static List<View> a(View paramView, int paramInt1, int paramInt2) {
    ArrayList<View> arrayList = new ArrayList();
    a(arrayList, paramView, paramInt1, paramInt2);
    return arrayList;
  }
  
  private static void a(List<View> paramList, View paramView, int paramInt1, int paramInt2) {
    if (b(paramView, paramInt1, paramInt2))
      paramList.add(paramView); 
    if (paramView instanceof ViewGroup) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      int j = viewGroup.getChildCount();
      int i;
      for (i = 0; i < j; i++)
        a(paramList, viewGroup.getChildAt(i), paramInt1, paramInt2); 
    } 
  }
  
  static boolean a(View paramView, int paramInt) {
    AbsListView absListView;
    RecyclerView recyclerView;
    paramView = h(paramView);
    if (paramView instanceof AbsListView) {
      absListView = (AbsListView)paramView;
      return (Build.VERSION.SDK_INT >= 19) ? absListView.canScrollList(paramInt) : false;
    } 
    if (absListView instanceof RecyclerView) {
      recyclerView = (RecyclerView)absListView;
      RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
      RecyclerView.Adapter adapter = recyclerView.getAdapter();
      if (layoutManager != null && adapter != null && adapter.getItemCount() > 0) {
        if (paramInt > 0) {
          i = adapter.getItemCount() - 1;
        } else {
          i = 0;
        } 
        if (layoutManager.findViewByPosition(i) == null)
          return true; 
        int i = recyclerView.getChildCount();
        if (paramInt > 0) {
          for (paramInt = i - 1; paramInt >= 0; paramInt--) {
            recyclerView.getDecoratedBoundsWithMargins(recyclerView.getChildAt(paramInt), a);
            if (a.bottom > recyclerView.getHeight() - recyclerView.getPaddingBottom())
              return true; 
          } 
          return false;
        } 
        for (paramInt = 0; paramInt < i; paramInt++) {
          recyclerView.getDecoratedBoundsWithMargins(recyclerView.getChildAt(paramInt), a);
          if (a.top < recyclerView.getPaddingTop())
            return true; 
        } 
      } 
      return false;
    } 
    return recyclerView.canScrollVertically(paramInt);
  }
  
  static boolean a(RecyclerView paramRecyclerView) {
    if ("InterceptRequestLayout".equals(paramRecyclerView.getTag()))
      try {
        Method method = RecyclerView.class.getDeclaredMethod("e", new Class[0]);
        method.setAccessible(true);
        method.invoke(paramRecyclerView, new Object[0]);
        return true;
      } catch (Exception exception) {
        return false;
      }  
    return false;
  }
  
  static int b(View paramView) {
    paramView = h(paramView);
    if (paramView instanceof ScrollingView)
      return ((ScrollingView)paramView).computeVerticalScrollRange(); 
    try {
      Method method = View.class.getDeclaredMethod("computeVerticalScrollRange", new Class[0]);
      method.setAccessible(true);
      return ((Integer)method.invoke(paramView, new Object[0])).intValue();
    } catch (Exception exception) {
      exception.printStackTrace();
      return paramView.getHeight();
    } 
  }
  
  static int b(View paramView, MotionEvent paramMotionEvent, int paramInt) {
    if (Build.VERSION.SDK_INT >= 29) {
      float f1 = paramMotionEvent.getRawY(paramInt);
      return (int)f1;
    } 
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    float f = arrayOfInt[1] + paramMotionEvent.getY(paramInt);
    return (int)f;
  }
  
  static void b(RecyclerView paramRecyclerView) {
    if ("InterceptRequestLayout".equals(paramRecyclerView.getTag()))
      try {
        Method method = RecyclerView.class.getDeclaredMethod("a", new Class[] { boolean.class });
        method.setAccessible(true);
        method.invoke(paramRecyclerView, new Object[] { Boolean.valueOf(false) });
        return;
      } catch (Exception exception) {
        return;
      }  
  }
  
  static boolean b(View paramView, int paramInt1, int paramInt2) {
    if (paramView == null)
      return false; 
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = paramView.getMeasuredWidth();
    int m = paramView.getMeasuredHeight();
    return (paramInt1 >= i && paramInt1 <= k + i && paramInt2 >= j && paramInt2 <= m + j);
  }
  
  static int c(View paramView) {
    paramView = h(paramView);
    if (paramView instanceof ScrollingView)
      return ((ScrollingView)paramView).computeVerticalScrollExtent(); 
    try {
      Method method = View.class.getDeclaredMethod("computeVerticalScrollExtent", new Class[0]);
      method.setAccessible(true);
      return ((Integer)method.invoke(paramView, new Object[0])).intValue();
    } catch (Exception exception) {
      exception.printStackTrace();
      return paramView.getHeight();
    } 
  }
  
  static boolean c(View paramView, int paramInt1, int paramInt2) {
    for (View view : a(paramView, paramInt1, paramInt2)) {
      if (view.canScrollHorizontally(1) || view.canScrollHorizontally(-1))
        return true; 
    } 
    return false;
  }
  
  static int d(View paramView) {
    return (g(paramView) && a(paramView, -1)) ? Math.min(-a(paramView), -1) : 0;
  }
  
  static int e(View paramView) {
    return (g(paramView) && a(paramView, 1)) ? Math.max(b(paramView) - a(paramView) - c(paramView), 1) : 0;
  }
  
  static boolean f(View paramView) {
    boolean bool = g(paramView);
    null = true;
    if (bool)
      if (!a(paramView, 1)) {
        if (a(paramView, -1))
          return true; 
      } else {
        return null;
      }  
    return false;
  }
  
  static boolean g(View paramView) {
    if (paramView != null) {
      ViewGroup.LayoutParams layoutParams = paramView.getLayoutParams();
      return (layoutParams instanceof ConsecutiveScrollerLayout.LayoutParams) ? ((ConsecutiveScrollerLayout.LayoutParams)layoutParams).a : true;
    } 
    return false;
  }
  
  static View h(View paramView) {
    while (paramView instanceof IConsecutiveScroller) {
      View view = ((IConsecutiveScroller)paramView).getCurrentScrollerView();
      if (paramView == view)
        return view; 
      paramView = view;
    } 
    return paramView;
  }
  
  static boolean i(View paramView) {
    while (paramView.getParent() instanceof ViewGroup && !(paramView.getParent() instanceof ConsecutiveScrollerLayout))
      paramView = (View)paramView.getParent(); 
    return (paramView.getParent() instanceof ConsecutiveScrollerLayout) ? g(paramView) : false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\consecutivescroller\ScrollUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */