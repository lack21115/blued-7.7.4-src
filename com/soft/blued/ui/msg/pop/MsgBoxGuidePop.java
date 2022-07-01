package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;

public class MsgBoxGuidePop extends CenterPopupView {
  public TextView c;
  
  public MsgBoxGuidePop(Context paramContext) {
    super(paramContext);
  }
  
  public void b() {
    super.b();
    this.c = (TextView)findViewById(2131300805);
    findViewById(2131300611).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.p();
          }
        });
  }
  
  public int getImplLayoutId() {
    return 2131493022;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\pop\MsgBoxGuidePop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */