package com.blued.android.module.yy_china.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.yy_china.utils.PopupwindowFactory;

public class YYPopupWindow extends PopupWindow {
  private PopupwindowFactory.Builder a;
  
  private View b;
  
  public YYPopupWindow(Context paramContext, PopupwindowFactory.Builder paramBuilder) {
    super(paramContext);
    this.a = paramBuilder;
    a();
  }
  
  private void a() {
    setContentView(this.a.c());
    setWidth(this.a.a());
    setHeight(this.a.b());
    setBackgroundDrawable((Drawable)new ColorDrawable(0));
    if (!this.a.f()) {
      setFocusable(true);
      setOutsideTouchable(false);
      getContentView().setFocusable(true);
      getContentView().setFocusableInTouchMode(true);
      getContentView().setOnKeyListener(new View.OnKeyListener(this) {
            public boolean onKey(View param1View, int param1Int, KeyEvent param1KeyEvent) {
              if (param1Int == 4) {
                this.a.dismiss();
                return true;
              } 
              return false;
            }
          });
      setTouchInterceptor(new View.OnTouchListener(this) {
            public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
              int i = (int)param1MotionEvent.getX();
              int j = (int)param1MotionEvent.getY();
              return (param1MotionEvent.getAction() == 0 && (i < 0 || i >= YYPopupWindow.a(this.a).a() || j < 0 || j >= YYPopupWindow.a(this.a).b())) ? true : ((param1MotionEvent.getAction() == 4));
            }
          });
      return;
    } 
    setOutsideTouchable(true);
    setFocusable(true);
  }
  
  private void a(float paramFloat) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("backgroundAlpha ... bgAlpha = ");
    stringBuilder.append(paramFloat);
    Logger.e("YYPopupWindow", new Object[] { stringBuilder.toString() });
    if (this.b == null) {
      Window window = ((Activity)this.a.d()).getWindow();
      this.b = new View(this.a.d());
      window.addContentView(this.b, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    } 
    if (paramFloat < 1.0F) {
      this.b.setBackgroundColor(this.a.d().getResources().getColor(this.a.e()));
      return;
    } 
    View view = this.b;
    if (view != null && view.getParent() != null && this.b.getParent() instanceof ViewGroup)
      ((ViewGroup)this.b.getParent()).removeView(this.b); 
  }
  
  public void dismiss() {
    super.dismiss();
    Logger.e("YYPopupWindow", new Object[] { "dismiss ... " });
    a(1.0F);
    if (this.a.g() != null)
      this.a.g().b(); 
    PopupwindowFactory.Builder builder = this.a;
    if (builder != null)
      builder.a(null); 
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2, int paramInt3) {
    super.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
    if (this.a.g() != null)
      this.a.g().a(); 
  }
  
  public void showAtLocation(View paramView, int paramInt1, int paramInt2, int paramInt3) {
    super.showAtLocation(paramView, paramInt1, paramInt2, paramInt3);
    Logger.e("YYPopupWindow", new Object[] { "showAtLocation ... " });
    a(0.3F);
    if (this.a.g() != null)
      this.a.g().a(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYPopupWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */