package com.google.android.material.expandable;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public final class ExpandableWidgetHelper {
  private final View a;
  
  private boolean b = false;
  
  private int c = 0;
  
  public ExpandableWidgetHelper(ExpandableWidget paramExpandableWidget) {
    this.a = (View)paramExpandableWidget;
  }
  
  private void d() {
    ViewParent viewParent = this.a.getParent();
    if (viewParent instanceof CoordinatorLayout)
      ((CoordinatorLayout)viewParent).dispatchDependentViewsChanged(this.a); 
  }
  
  public void a(int paramInt) {
    this.c = paramInt;
  }
  
  public void a(Bundle paramBundle) {
    this.b = paramBundle.getBoolean("expanded", false);
    this.c = paramBundle.getInt("expandedComponentIdHint", 0);
    if (this.b)
      d(); 
  }
  
  public boolean a() {
    return this.b;
  }
  
  public Bundle b() {
    Bundle bundle = new Bundle();
    bundle.putBoolean("expanded", this.b);
    bundle.putInt("expandedComponentIdHint", this.c);
    return bundle;
  }
  
  public int c() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\expandable\ExpandableWidgetHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */