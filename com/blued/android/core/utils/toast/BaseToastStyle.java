package com.blued.android.core.utils.toast;

import android.content.Context;
import android.util.TypedValue;

public abstract class BaseToastStyle implements IToastStyle {
  private Context a;
  
  public BaseToastStyle(Context paramContext) {
    this.a = paramContext;
  }
  
  public int a() {
    return 17;
  }
  
  protected int a(float paramFloat) {
    return (int)TypedValue.applyDimension(1, paramFloat, this.a.getResources().getDisplayMetrics());
  }
  
  public int b() {
    return 0;
  }
  
  protected int b(float paramFloat) {
    return (int)TypedValue.applyDimension(2, paramFloat, this.a.getResources().getDisplayMetrics());
  }
  
  public int c() {
    return 0;
  }
  
  public int d() {
    return 30;
  }
  
  public int e() {
    return 5;
  }
  
  public int f() {
    return l();
  }
  
  public int g() {
    return m();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\toast\BaseToastStyle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */