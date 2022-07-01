package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

class ViewOffsetHelper {
  private final View a;
  
  private int b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private boolean f = true;
  
  private boolean g = true;
  
  public ViewOffsetHelper(View paramView) {
    this.a = paramView;
  }
  
  void a() {
    this.b = this.a.getTop();
    this.c = this.a.getLeft();
  }
  
  public boolean a(int paramInt) {
    if (this.f && this.d != paramInt) {
      this.d = paramInt;
      b();
      return true;
    } 
    return false;
  }
  
  void b() {
    View view = this.a;
    ViewCompat.offsetTopAndBottom(view, this.d - view.getTop() - this.b);
    view = this.a;
    ViewCompat.offsetLeftAndRight(view, this.e - view.getLeft() - this.c);
  }
  
  public boolean b(int paramInt) {
    if (this.g && this.e != paramInt) {
      this.e = paramInt;
      b();
      return true;
    } 
    return false;
  }
  
  public int c() {
    return this.d;
  }
  
  public int d() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\appbar\ViewOffsetHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */