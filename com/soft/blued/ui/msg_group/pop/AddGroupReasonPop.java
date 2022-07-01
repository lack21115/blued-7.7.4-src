package com.soft.blued.ui.msg_group.pop;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.module.common.utils.ToastUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class AddGroupReasonPop extends BottomPopupView {
  private EditText b;
  
  public void b() {
    super.b();
    this.b = (EditText)findViewById(2131297010);
    findViewById(2131300519).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (TextUtils.isEmpty(AddGroupReasonPop.a(this.a).getText().toString())) {
              ToastUtils.a(this.a.getResources().getString(2131758687));
              return;
            } 
            LiveEventBus.get("add_group").post(AddGroupReasonPop.a(this.a).getText().toString());
            this.a.p();
          }
        });
  }
  
  public int getImplLayoutId() {
    return 2131494027;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\pop\AddGroupReasonPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */