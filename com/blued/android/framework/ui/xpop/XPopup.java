package com.blued.android.framework.ui.xpop;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.PopupInfo;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.enums.PopupType;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;

public class XPopup {
  public static int a;
  
  private static int b = Color.parseColor("#121212");
  
  private static int c = 350;
  
  private static int d;
  
  static {
    a = Color.parseColor("#55000000");
    d = Color.parseColor("#6F000000");
  }
  
  public static int a() {
    return d;
  }
  
  public static int b() {
    return c;
  }
  
  public static class Builder {
    private final PopupInfo a = new PopupInfo();
    
    private Context b;
    
    public Builder(Context param1Context) {
      this.b = param1Context;
    }
    
    public Builder a(View param1View) {
      this.a.g = param1View;
      return this;
    }
    
    public Builder a(PopupAnimation param1PopupAnimation) {
      this.a.i = param1PopupAnimation;
      return this;
    }
    
    public Builder a(PopupPosition param1PopupPosition) {
      this.a.s = param1PopupPosition;
      return this;
    }
    
    public Builder a(PopupType param1PopupType) {
      this.a.a = param1PopupType;
      return this;
    }
    
    public Builder a(XPopupCallback param1XPopupCallback) {
      this.a.p = param1XPopupCallback;
      return this;
    }
    
    public Builder a(Boolean param1Boolean) {
      this.a.b = param1Boolean;
      return this;
    }
    
    public Builder a(boolean param1Boolean) {
      this.a.A = param1Boolean;
      return this;
    }
    
    public BasePopupView a(BasePopupView param1BasePopupView) {
      if (param1BasePopupView instanceof com.blued.android.framework.ui.xpop.core.CenterPopupView) {
        a(PopupType.a);
      } else if (param1BasePopupView instanceof com.blued.android.framework.ui.xpop.core.BottomPopupView) {
        a(PopupType.b);
      } else if (param1BasePopupView instanceof com.blued.android.framework.ui.xpop.core.AttachPopupView) {
        a(PopupType.c);
      } else if (param1BasePopupView instanceof com.blued.android.framework.ui.xpop.core.PositionPopupView) {
        a(PopupType.e);
      } 
      param1BasePopupView.l = this.a;
      return param1BasePopupView;
    }
    
    public Builder b(Boolean param1Boolean) {
      this.a.c = param1Boolean;
      return this;
    }
    
    public Builder c(Boolean param1Boolean) {
      this.a.e = param1Boolean;
      return this;
    }
    
    public Builder d(Boolean param1Boolean) {
      this.a.o = param1Boolean;
      return this;
    }
    
    public Builder e(Boolean param1Boolean) {
      this.a.r = param1Boolean;
      return this;
    }
  }
  
  class null implements View.OnTouchListener {
    public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
      if ((XPopup.Builder.a(this.a)).k == null || param1MotionEvent.getAction() == 0)
        (XPopup.Builder.a(this.a)).k = new PointF(param1MotionEvent.getRawX(), param1MotionEvent.getRawY()); 
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\ui\xpop\XPopup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */