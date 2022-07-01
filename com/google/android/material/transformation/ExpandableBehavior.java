package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {
  private int a = 0;
  
  public ExpandableBehavior() {}
  
  public ExpandableBehavior(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  private boolean a(boolean paramBoolean) {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramBoolean) {
      int i = this.a;
      if (i != 0) {
        paramBoolean = bool1;
        return (i == 2) ? true : paramBoolean;
      } 
    } else {
      paramBoolean = bool2;
      if (this.a == 1)
        paramBoolean = true; 
      return paramBoolean;
    } 
    return true;
  }
  
  protected ExpandableWidget a(CoordinatorLayout paramCoordinatorLayout, View paramView) {
    List<View> list = paramCoordinatorLayout.getDependencies(paramView);
    int j = list.size();
    for (int i = 0; i < j; i++) {
      View view = list.get(i);
      if (layoutDependsOn(paramCoordinatorLayout, paramView, view))
        return (ExpandableWidget)view; 
    } 
    return null;
  }
  
  protected abstract boolean a(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2);
  
  public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2) {
    ExpandableWidget expandableWidget = (ExpandableWidget)paramView2;
    if (a(expandableWidget.a())) {
      byte b;
      if (expandableWidget.a()) {
        b = 1;
      } else {
        b = 2;
      } 
      this.a = b;
      return a((View)expandableWidget, paramView1, expandableWidget.a(), true);
    } 
    return false;
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt) {
    if (!ViewCompat.isLaidOut(paramView)) {
      ExpandableWidget expandableWidget = a(paramCoordinatorLayout, paramView);
      if (expandableWidget != null && a(expandableWidget.a())) {
        if (expandableWidget.a()) {
          paramInt = 1;
        } else {
          paramInt = 2;
        } 
        this.a = paramInt;
        paramInt = this.a;
        paramView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener(this, paramView, paramInt, expandableWidget) {
              public boolean onPreDraw() {
                this.a.getViewTreeObserver().removeOnPreDrawListener(this);
                if (ExpandableBehavior.a(this.d) == this.b) {
                  ExpandableBehavior expandableBehavior = this.d;
                  ExpandableWidget expandableWidget = this.c;
                  expandableBehavior.a((View)expandableWidget, this.a, expandableWidget.a(), false);
                } 
                return false;
              }
            });
      } 
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transformation\ExpandableBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */