package com.scwang.smartrefresh.layout.impl;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.legacy.widget.Space;
import com.scwang.smartrefresh.layout.api.RefreshContent;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider;
import com.scwang.smartrefresh.layout.listener.CoordinatorLayoutListener;
import com.scwang.smartrefresh.layout.util.DesignUtil;
import com.scwang.smartrefresh.layout.util.ScrollBoundaryUtil;
import com.scwang.smartrefresh.layout.util.SmartUtil;
import java.util.Collections;
import java.util.LinkedList;

public class RefreshContentWrapper implements ValueAnimator.AnimatorUpdateListener, RefreshContent, CoordinatorLayoutListener {
  protected View a;
  
  protected View b;
  
  protected View c;
  
  protected View d;
  
  protected View e;
  
  protected int f = 0;
  
  protected boolean g = true;
  
  protected boolean h = true;
  
  protected ScrollBoundaryDeciderAdapter i = new ScrollBoundaryDeciderAdapter();
  
  public RefreshContentWrapper(View paramView) {
    this.c = paramView;
    this.b = paramView;
    this.a = paramView;
  }
  
  public ValueAnimator.AnimatorUpdateListener a(int paramInt) {
    View view = this.c;
    if (view != null && paramInt != 0 && ((paramInt < 0 && ScrollBoundaryUtil.b(view)) || (paramInt > 0 && ScrollBoundaryUtil.a(this.c)))) {
      this.f = paramInt;
      return this;
    } 
    return null;
  }
  
  public View a() {
    return this.a;
  }
  
  protected View a(View paramView1, PointF paramPointF, View paramView2) {
    if (paramView1 instanceof ViewGroup && paramPointF != null) {
      ViewGroup viewGroup = (ViewGroup)paramView1;
      int i = viewGroup.getChildCount();
      PointF pointF = new PointF();
      while (true) {
        View view2;
        if (i > 0) {
          view2 = viewGroup.getChildAt(i - 1);
          if (ScrollBoundaryUtil.a((View)viewGroup, view2, paramPointF.x, paramPointF.y, pointF)) {
            if (!(view2 instanceof androidx.viewpager.widget.ViewPager)) {
              View view = view2;
              if (!SmartUtil.c(view2)) {
                paramPointF.offset(pointF.x, pointF.y);
                view = a(view2, paramPointF, paramView2);
                paramPointF.offset(-pointF.x, -pointF.y);
                return view;
              } 
              return view;
            } 
          } else {
            i--;
            continue;
          } 
        } else {
          break;
        } 
        paramPointF.offset(pointF.x, pointF.y);
        View view1 = a(view2, paramPointF, paramView2);
        paramPointF.offset(-pointF.x, -pointF.y);
        return view1;
      } 
    } 
    return paramView2;
  }
  
  protected View a(View paramView, boolean paramBoolean) {
    LinkedList<View> linkedList = new LinkedList(Collections.singletonList(paramView));
    View view = null;
    while (!linkedList.isEmpty() && view == null) {
      View view1 = linkedList.poll();
      if (view1 != null) {
        if ((paramBoolean || view1 != paramView) && SmartUtil.c(view1)) {
          view = view1;
          continue;
        } 
        if (view1 instanceof ViewGroup) {
          ViewGroup viewGroup = (ViewGroup)view1;
          for (int i = 0; i < viewGroup.getChildCount(); i++)
            linkedList.add(viewGroup.getChildAt(i)); 
        } 
      } 
    } 
    return (view == null) ? paramView : view;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt2 != -1) {
      View view = this.b.findViewById(paramInt2);
      if (view != null) {
        if (paramInt1 > 0) {
          view.setTranslationY(paramInt1);
          paramInt2 = 1;
        } else {
          if (view.getTranslationY() > 0.0F)
            view.setTranslationY(0.0F); 
          paramInt2 = 0;
        } 
        int i = paramInt2;
        if (paramInt3 != -1) {
          view = this.b.findViewById(paramInt3);
          i = paramInt2;
          if (view != null)
            if (paramInt1 < 0) {
              view.setTranslationY(paramInt1);
              i = 1;
            } else {
              i = paramInt2;
              if (view.getTranslationY() < 0.0F) {
                view.setTranslationY(0.0F);
                i = paramInt2;
              } 
            }  
        } 
        if (i == 0) {
          this.b.setTranslationY(paramInt1);
        } else {
          this.b.setTranslationY(0.0F);
        } 
        view = this.d;
        if (view != null)
          view.setTranslationY(Math.max(0, paramInt1)); 
        view = this.e;
        if (view != null)
          view.setTranslationY(Math.min(0, paramInt1)); 
        return;
      } 
    } 
    paramInt2 = 0;
  }
  
  public void a(MotionEvent paramMotionEvent) {
    PointF pointF = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
    pointF.offset(-this.a.getLeft(), -this.a.getTop());
    View view1 = this.c;
    View view2 = this.a;
    if (view1 != view2)
      this.c = a(view2, pointF, view1); 
    if (this.c == this.a) {
      this.i.a = null;
      return;
    } 
    this.i.a = pointF;
  }
  
  protected void a(View paramView, RefreshKernel paramRefreshKernel) {
    boolean bool = this.a.isInEditMode();
    View view2 = null;
    View view1 = paramView;
    paramView = view2;
    while (true) {
      if (paramView == null || (paramView instanceof androidx.core.view.NestedScrollingParent && !(paramView instanceof androidx.core.view.NestedScrollingChild))) {
        boolean bool1;
        if (paramView == null) {
          bool1 = true;
        } else {
          bool1 = false;
        } 
        view1 = a(view1, bool1);
        if (view1 != paramView) {
          if (!bool)
            DesignUtil.a(view1, paramRefreshKernel, this); 
          paramView = view1;
          continue;
        } 
      } 
      if (paramView != null)
        this.c = paramView; 
      return;
    } 
  }
  
  public void a(RefreshKernel paramRefreshKernel, View paramView1, View paramView2) {
    a(this.a, paramRefreshKernel);
    if (paramView1 != null || paramView2 != null) {
      this.d = paramView1;
      this.e = paramView2;
      FrameLayout frameLayout = new FrameLayout(this.a.getContext());
      paramRefreshKernel.a().getLayout().removeView(this.a);
      ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
      frameLayout.addView(this.a, -1, -1);
      paramRefreshKernel.a().getLayout().addView((View)frameLayout, layoutParams);
      this.a = (View)frameLayout;
      if (paramView1 != null) {
        paramView1.setClickable(true);
        ViewGroup.LayoutParams layoutParams1 = paramView1.getLayoutParams();
        ViewGroup viewGroup = (ViewGroup)paramView1.getParent();
        int i = viewGroup.indexOfChild(paramView1);
        viewGroup.removeView(paramView1);
        layoutParams1.height = SmartUtil.a(paramView1);
        viewGroup.addView((View)new Space(this.a.getContext()), i, layoutParams1);
        frameLayout.addView(paramView1);
      } 
      if (paramView2 != null) {
        paramView2.setClickable(true);
        ViewGroup.LayoutParams layoutParams1 = paramView2.getLayoutParams();
        ViewGroup viewGroup = (ViewGroup)paramView2.getParent();
        int i = viewGroup.indexOfChild(paramView2);
        viewGroup.removeView(paramView2);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams1);
        layoutParams1.height = SmartUtil.a(paramView2);
        viewGroup.addView((View)new Space(this.a.getContext()), i, layoutParams1);
        layoutParams2.gravity = 80;
        frameLayout.addView(paramView2, (ViewGroup.LayoutParams)layoutParams2);
      } 
    } 
  }
  
  public void a(ScrollBoundaryDecider paramScrollBoundaryDecider) {
    if (paramScrollBoundaryDecider instanceof ScrollBoundaryDeciderAdapter) {
      this.i = (ScrollBoundaryDeciderAdapter)paramScrollBoundaryDecider;
      return;
    } 
    this.i.b = paramScrollBoundaryDecider;
  }
  
  public void a(boolean paramBoolean) {
    this.i.c = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {
    this.g = paramBoolean1;
    this.h = paramBoolean2;
  }
  
  public View b() {
    return this.c;
  }
  
  public boolean c() {
    return (this.g && this.i.a(this.a));
  }
  
  public boolean d() {
    return (this.h && this.i.b(this.a));
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator) {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    try {
      if (this.c instanceof AbsListView) {
        SmartUtil.a((AbsListView)this.c, i - this.f);
      } else {
        this.c.scrollBy(0, i - this.f);
      } 
    } finally {}
    this.f = i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\scwang\smartrefresh\layout\impl\RefreshContentWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */