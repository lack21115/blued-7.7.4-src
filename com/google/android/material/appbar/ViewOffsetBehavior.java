package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
  private ViewOffsetHelper a;
  
  private int b = 0;
  
  private int c = 0;
  
  public ViewOffsetBehavior() {}
  
  public ViewOffsetBehavior(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  protected void a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt) {
    paramCoordinatorLayout.onLayoutChild((View)paramV, paramInt);
  }
  
  public boolean a(int paramInt) {
    ViewOffsetHelper viewOffsetHelper = this.a;
    if (viewOffsetHelper != null)
      return viewOffsetHelper.a(paramInt); 
    this.b = paramInt;
    return false;
  }
  
  public int b() {
    ViewOffsetHelper viewOffsetHelper = this.a;
    return (viewOffsetHelper != null) ? viewOffsetHelper.c() : 0;
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt) {
    a(paramCoordinatorLayout, paramV, paramInt);
    if (this.a == null)
      this.a = new ViewOffsetHelper((View)paramV); 
    this.a.a();
    this.a.b();
    paramInt = this.b;
    if (paramInt != 0) {
      this.a.a(paramInt);
      this.b = 0;
    } 
    paramInt = this.c;
    if (paramInt != 0) {
      this.a.b(paramInt);
      this.c = 0;
    } 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\appbar\ViewOffsetBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */