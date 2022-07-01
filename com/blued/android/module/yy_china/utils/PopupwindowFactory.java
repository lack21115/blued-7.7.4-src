package com.blued.android.module.yy_china.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.listener.IPopShowAndDismissListener;
import com.blued.android.module.yy_china.view.YYPopupWindow;

public class PopupwindowFactory {
  public static class Builder {
    private int a;
    
    private int b;
    
    private int c;
    
    private View d;
    
    private Context e;
    
    private int f;
    
    private int g = -1;
    
    private IPopShowAndDismissListener h;
    
    private boolean i = true;
    
    public Builder(Context param1Context) {
      this.e = param1Context;
    }
    
    public int a() {
      return this.b;
    }
    
    public PopupWindow a(View param1View, int param1Int1, int param1Int2) {
      YYPopupWindow yYPopupWindow = new YYPopupWindow(this.e, this);
      yYPopupWindow.showAsDropDown(param1View, param1Int1, param1Int2);
      return (PopupWindow)yYPopupWindow;
    }
    
    public Builder a(int param1Int) {
      this.a = param1Int;
      return this;
    }
    
    public Builder a(View param1View) {
      this.d = param1View;
      return this;
    }
    
    public Builder a(IPopShowAndDismissListener param1IPopShowAndDismissListener) {
      this.h = param1IPopShowAndDismissListener;
      return this;
    }
    
    public Builder a(boolean param1Boolean) {
      this.i = param1Boolean;
      return this;
    }
    
    public void a(Context param1Context) {
      this.e = param1Context;
    }
    
    public int b() {
      return this.c;
    }
    
    public Builder b(int param1Int) {
      this.b = param1Int;
      return this;
    }
    
    public View c() {
      return this.d;
    }
    
    public Builder c(int param1Int) {
      this.c = param1Int;
      return this;
    }
    
    public Context d() {
      return this.e;
    }
    
    public Builder d(int param1Int) {
      this.f = param1Int;
      return this;
    }
    
    public int e() {
      return this.f;
    }
    
    public Builder e(int param1Int) {
      this.g = param1Int;
      return this;
    }
    
    public boolean f() {
      return this.i;
    }
    
    public IPopShowAndDismissListener g() {
      return this.h;
    }
    
    public PopupWindow h() {
      YYPopupWindow yYPopupWindow = new YYPopupWindow(this.e, this);
      int i = this.a;
      if (i == 80) {
        yYPopupWindow.setAnimationStyle(R.style.yy_pop_bottom_in_anim);
      } else if (i == 48) {
        yYPopupWindow.setAnimationStyle(R.style.yy_pop_top_in_anim);
        yYPopupWindow.setClippingEnabled(false);
      } 
      i = this.g;
      if (i != -1)
        yYPopupWindow.setAnimationStyle(i); 
      yYPopupWindow.showAtLocation(((Activity)this.e).getWindow().getDecorView(), this.a, 0, 0);
      return (PopupWindow)yYPopupWindow;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_chin\\utils\PopupwindowFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */