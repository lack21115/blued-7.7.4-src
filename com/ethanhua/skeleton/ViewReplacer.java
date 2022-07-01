package com.ethanhua.skeleton;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class ViewReplacer {
  private static final String a = ViewReplacer.class.getName();
  
  private final View b;
  
  private View c;
  
  private int d = -1;
  
  private View e;
  
  private ViewGroup f;
  
  private final ViewGroup.LayoutParams g;
  
  private int h = 0;
  
  private final int i;
  
  public ViewReplacer(View paramView) {
    this.b = paramView;
    this.g = this.b.getLayoutParams();
    paramView = this.b;
    this.e = paramView;
    this.i = paramView.getId();
  }
  
  private boolean c() {
    if (this.f == null) {
      this.f = (ViewGroup)this.b.getParent();
      ViewGroup viewGroup = this.f;
      int i = 0;
      if (viewGroup == null) {
        Log.e(a, "the source view have not attach to any view");
        return false;
      } 
      int j = viewGroup.getChildCount();
      while (i < j) {
        if (this.b == this.f.getChildAt(i)) {
          this.h = i;
          break;
        } 
        i++;
      } 
    } 
    return true;
  }
  
  public void a() {
    ViewGroup viewGroup = this.f;
    if (viewGroup != null) {
      viewGroup.removeView(this.e);
      this.f.addView(this.b, this.h, this.g);
      this.e = this.b;
      this.c = null;
      this.d = -1;
    } 
  }
  
  public void a(View paramView) {
    if (this.e == paramView)
      return; 
    if (paramView.getParent() != null)
      ((ViewGroup)paramView.getParent()).removeView(paramView); 
    if (c()) {
      this.c = paramView;
      this.f.removeView(this.e);
      this.c.setId(this.i);
      this.f.addView(this.c, this.h, this.g);
      this.e = this.c;
    } 
  }
  
  public View b() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\ethanhua\skeleton\ViewReplacer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */