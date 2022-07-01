package com.soft.blued.ui.mine.pop;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.soft.blued.utils.StringUtils;

public class UnreadMsgPop extends AttachPopupView {
  public String t;
  
  public UnreadMsgPop(Context paramContext) {
    super(paramContext);
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
        },  5000L);
  }
  
  public int getImplLayoutId() {
    return 2131494068;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    p();
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\mine\pop\UnreadMsgPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */