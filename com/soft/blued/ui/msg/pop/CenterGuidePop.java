package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.ui.xpop.interfaces.XPopupCallback;
import com.soft.blued.utils.StringUtils;

public class CenterGuidePop extends AttachPopupView {
  private String t;
  
  private int u = 5000;
  
  public CenterGuidePop(Context paramContext, String paramString) {
    super(paramContext);
    this.t = paramString;
  }
  
  public void a(View paramView, XPopupCallback paramXPopupCallback) {
    (new XPopup.Builder(getContext())).a(paramXPopupCallback).a(PopupAnimation.a).c(Boolean.valueOf(false)).a(PopupPosition.c).a(true).a(paramView).a((BasePopupView)this).h();
  }
  
  public void b() {
    super.b();
    if (!StringUtils.e(this.t))
      ((TextView)findViewById(2131300890)).setText(this.t); 
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            if (!this.a.s())
              this.a.p(); 
          }
        },  this.u);
  }
  
  public int getImplLayoutId() {
    return 2131494041;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    p();
    return false;
  }
  
  public void t() {
    super.t();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\pop\CenterGuidePop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */